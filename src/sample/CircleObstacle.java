package sample;

import javafx.animation.*;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.util.ArrayList;

public class CircleObstacle extends Obstacle {
    Arc arc1,arc2,arc3,arc4;

    AnchorPane anchorPane;


    Timeline timeline1 = new Timeline();
    Group g = new Group();
    CircleObstacle(Arc arc1,Arc arc2,Arc arc3,Arc arc4){
        this.arc1 = arc1;
        this.arc2 = arc2;
        this.arc3 = arc3;
        this.arc4 = arc4;
        this.arc1.setFill(Color.DEEPPINK);
        this.arc2.setFill(Color.YELLOW);
        this.arc3.setFill(Color.BLUE);
        this.arc4.setFill(Color.VIOLET);


    }
    @Override
    public void addObstacle(Timeline timeline, AnchorPane a){
        isVisible = true;
        this.anchorPane = a;
        g.getChildren().addAll(arc1,arc2,arc3,arc4);

        a.getChildren().add(g);
        g.setLayoutY(g.getLayoutY()+200);
      //  g.setVisible(false);
       // g.translateYProperty().bind(anchorPane.heightProperty().subtract(10));
       // System.out.println(g.getBoundsInParent());
        //System.out.println(anchorPane.getBoundsInLocal());
//        Translate translate = new Translate();
//        g.getTransforms().add(translate);
        //g.setTranslateY(-160);
       // System.out.println(g.getLayoutX()+" "+g.getLayoutY());


        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(g.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(g.rotateProperty(), 360, Interpolator.LINEAR)));
//                new KeyFrame(Duration.ZERO, new KeyValue(g.rotateProperty(), 0, Interpolator.LINEAR)),
//                new KeyFrame(Duration.seconds(4), new KeyValue(g.rotateProperty(), -360, Interpolator.LINEAR)));
//
//        timeline1.play();
////        timeline1.setCycleCount(Animation.INDEFINITE);
//        g.getTransforms().addAll(translate);
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

    @Override
    public void initialpos() {
   //     g.setTranslateY(200);
    }
    public void resetpos(){
        anchorPane.getChildren().add(g);
        g.setLayoutY(-160);
        g.setVisible(true);
        isVisible = true;
    }
    @Override
    public void moveDown() {


        //System.out.println(g.getBoundsInParent());
       // tl.setTranslateY(tl.getLayoutY()+3);
        if(g.getLayoutY()>=380){
            isVisible = false;
            anchorPane.getChildren().remove(g);
            g.setLayoutY(-300);
            System.out.println("Circle removed");

        }
        g.setLayoutY(g.getLayoutY()+20);
    }
}
