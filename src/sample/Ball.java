package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

import static java.lang.Math.abs;
import static java.lang.Math.getExponent;

class Ball {
    private final Circle ball;
    public Ball(Circle ball){
        this.ball = ball;

    }

    public void moveBall(Button playButton){
        Mytimer t = new Mytimer();
        t.start();


    }
    public void bounceBall(){
        ball.setLayoutY(ball.getLayoutY()-50);
    }
    private class Mytimer extends AnimationTimer{
        private long time = 0;

        @Override
        public void handle(long arg0) {
            long dt = arg0 - time;
            System.out.println(dt);
            double dY = 1.25;
            if (dt>15e5){
                time = arg0;


                if(ball.getLayoutY()== 575){
                    ball.setLayoutY(575);


                }
                else{
                    ball.setLayoutY(ball.getLayoutY()+dY);
                }


            }
        }
    }
}
