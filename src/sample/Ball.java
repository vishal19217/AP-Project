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
    Mytimer t =new Mytimer();
    public Ball(Circle ball, Label scoreLabel){
      this.ball = ball;
      this.scoreLabel = scoreLabel;

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
                    //System.out.println("Wrong collision");
                }

            }
        }
    }
}
