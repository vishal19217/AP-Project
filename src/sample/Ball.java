package sample;

import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import static java.lang.Math.abs;
import static java.lang.Math.getExponent;

class Ball {
    private final Circle ball;
    private Label scoreLabel;
    private int MyScore = 0;
    private Obstacle myObstacle;
    public Ball(Circle ball, Label scoreLabel){
      this.ball = ball;
      this.scoreLabel = scoreLabel;

    }

    public void moveBall(){
        Mytimer t = new Mytimer();
        t.start();


    }
    public void bounceBall(){
        ball.setLayoutY(ball.getLayoutY()-50);
    }
    public void setMyObstacle(Obstacle ob){
        this.myObstacle = ob;
    }
    public int getMyScore(){
        return MyScore;
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


                if(ball.getLayoutY()>= 575){
                    ball.setLayoutY(575);



                }
                else{
                    ball.setLayoutY(ball.getLayoutY()+dY);
                }
                if(check == 1 ){
                    MyScore++;
                    setMyScore();
                }
                else if(check == 0){
                    //System.out.println("Wrong collision");
                }

            }
        }
    }
}
