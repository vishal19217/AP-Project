package sample;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.getExponent;

class Ball {
    private final Circle ball;
    private Label scoreLabel;
    private  boolean collision;
    private int MyScore = 0;
    private Obstacle myObstacle;
    private ArrayList<Color>colorArrayList  = new ArrayList<Color>();
    int i=2;
    Mytimer t =new Mytimer();
    public Ball(Circle ball, Label scoreLabel){
      this.ball = ball;
      collision = false;
      this.scoreLabel = scoreLabel;
      colorArrayList.add(Color.CRIMSON);
        colorArrayList.add(Color.BLUE);
        colorArrayList.add(Color.YELLOW);

    }

    public void callTimerStop(){
        t.stop();

    }

    public void moveBall(){

        t.start();



    }
    public void bounceBall(){
        ball.setCenterY(ball.getCenterY()-50);
    }
    public void setMyObstacle(Obstacle ob){
        this.myObstacle = ob;
    }
    public int getMyScore(){
        return MyScore;
    }
    public double getX(){
        return ball.getLayoutX();
    }
    public double getY(){
        return ball.getLayoutY();
    }
    public boolean checkColCir(Circle c){

        Shape intersect = Shape.intersect(ball,c);
        if(intersect.getBoundsInLocal().getWidth()!=-1){
            if(i==3){
                i=0;
            }



            ball.setFill(colorArrayList.get(i));
            i++;
            return true;
        }
        else
            return false;


    }
    public void setMyScore(){
        scoreLabel.setText(Integer.toString(MyScore));
    }
    private class Mytimer extends AnimationTimer{
        private long time = 0;
        int c=0;
        @Override
        public void handle(long arg0) {
            long dt = arg0 - time;
            int check = myObstacle.checkCollision(ball);





            double dY = 1.40;
            if (dt>15e4){
                time = arg0;


                if(ball.getCenterY()>= 700){
                    ball.setCenterY(700);




                }
                else{
                    ball.setCenterY((ball.getCenterY()+dY));
                }

                if(myObstacle.checkStarCollision(ball)){
                    MyScore++;
                    setMyScore();
                   // myObstacle.s.setVisibility(false);
                }

                if(check == 1 ){

                }
                else if(check == 0){

                    t.stop();
                    collision = true;

                    //System.out.println("Wrong collision");
                }

            }
        }
    }

    public boolean isCollision() {
        return collision;
    }
}
