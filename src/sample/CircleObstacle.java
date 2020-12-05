package sample;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class CircleObstacle extends Obstacle {
    Arc arc1,arc2,arc3,arc4;
    CircleObstacle(Arc arc1,Arc arc2,Arc arc3,Arc arc4){
        this.arc1 = arc1;
        this.arc2 = arc2;
        this.arc3 = arc3;
        this.arc4 = arc4;

    }
    @Override
    public void addObstacle(AnchorPane ap,Timeline timeline){
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle() - 360, Interpolator.LINEAR)));

            }

    public int checkCollision(Circle ball){
        ArrayList<Arc>components = new ArrayList<Arc>();
        components.add(arc1);components.add(arc2);
        components.add(arc3);components.add(arc4);
        for(Arc arc:components){
            Shape intersect = Shape.intersect(arc,ball);
            if(intersect.getBoundsInLocal().getWidth()!=-1) {
               if(checkCorrectCollision(arc,ball)){
                   return 1;
               }
               else{
                   return 0;
               }
            }

        }
        return -1;

    }

    public boolean checkCorrectCollision(Arc arc,Circle ball) {
        //System.out.println(ball.getFill()+"   "+arc.getStroke());
        if(arc.getStroke()==ball.getFill()){
            return true;
        }
        else{
            return false;
        }
    }
}
