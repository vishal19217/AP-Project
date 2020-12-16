package sample;

import javafx.animation.*;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.util.ArrayList;

public class CircleObstacle extends Obstacle {
    Arc arc1,arc2,arc3,arc4;
    Star s = new Star(300,370);
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
        Group pt = s.draw();

        //star
        //Path pt = new Path();double s = 1;int k=300, p=370;

        g.getChildren().addAll(arc1,arc2,arc3,arc4);
        pt.setLayoutY(g.getLayoutY()-200);
       // g.getChildren().add(pt);
//        Group g2 = new Group();
//        g2.getChildren().add(pt);;
//        Group g1 = new Group();

//        g2.setLayoutY(g1.getLayoutY()-200);
//        g.getChildren().addAll(g1,g2);
        //g.getChildren().add(pt);
       // a.getChildren().add(pt);
        a.getChildren().add(g);
        a.getChildren().add(pt);
        g.setLayoutY(g.getLayoutY()+200);



        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(g.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(g.rotateProperty(), 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(pt.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(pt.rotateProperty(), 360, Interpolator.LINEAR)));


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


//                new KeyFrame(Duration.ZERO, new KeyValue(g.rotateProperty(), 0, Interpolator.LINEAR)),
//                new KeyFrame(Duration.seconds(4), new KeyValue(g.rotateProperty(), -360, Interpolator.LINEAR)));
//
//        timeline1.play();
////        timeline1.setCycleCount(Animation.INDEFINITE);
//        g.getTransforms().addAll(translate);


//  g.setVisible(false);
// g.translateYProperty().bind(anchorPane.heightProperty().subtract(10));
// System.out.println(g.getBoundsInParent());
//System.out.println(anchorPane.getBoundsInLocal());
//        Translate translate = new Translate();
//        g.getTransforms().add(translate);
//g.setTranslateY(-160);
// System.out.println(g.getLayoutX()+" "+g.getLayoutY());