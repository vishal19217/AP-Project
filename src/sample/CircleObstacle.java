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
    AnchorPane anchorPane;


    Timeline timeline1 = new Timeline();
    Group g = new Group();
    Path myStar  = null;
    CircleObstacle(Arc arc1,Arc arc2,Arc arc3,Arc arc4){
        this.arc1 = arc1;
        this.arc2 = arc2;
        this.arc3 = arc3;
        this.arc4 = arc4;
        this.arc1.setFill(Color.DEEPPINK);
        this.arc2.setFill(Color.YELLOW);
        this.arc3.setFill(Color.BLUE);
        this.arc4.setFill(Color.VIOLET);
        s = new Star(300,370);
        //this.arc1.setStroke();
        //
    }
    @Override
    public void addObstacle(Timeline timeline, AnchorPane a){
        //Setting the properties of the arc



        isVisible = true;
        this.anchorPane = a;
        Path pt = s.draw();
        myStar = pt;

        a.getChildren().add(pt);

        //c.setVisible(true);
        Group g1 = new Group();
        g.getChildren().addAll(arc1,arc2,arc3,arc4);
        pt.setLayoutY(g.getLayoutY()-200);
        //c.setCenterY(pt.getLayoutY()+30);
        g.getChildren().addAll(pt);
        a.getChildren().addAll(g);
        //a.getChildren().add(c);

        g.setLayoutY(g.getLayoutY()+200);



        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(g.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(g.rotateProperty(), 360, Interpolator.LINEAR)));



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

        if(arc.getStroke()==ball.getFill()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean checkStarCollision(Circle ball) {
        if (s.isVisible()) {
            Shape intersect = Shape.intersect(ball,myStar);
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                s.setVisibility(false);
                myStar.setVisible(false);
                return true;
            }

            else
            {
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public void initialpos() {

    }
    public void resetpos(){
        anchorPane.getChildren().add(g);
        s.setVisibility(true);
        myStar.setVisible(true);
        g.setLayoutY(-160);
        s.setVisibility(true);
        isVisible = true;
    }
    @Override
    public void moveDown() {



        if(g.getLayoutY()>=550){
            isVisible = false;
            anchorPane.getChildren().remove(g);
            System.out.println("Circle removed");

        }
        else {
            if(s.isVisible())
            g.setLayoutY(g.getLayoutY() + 20);
            else{
                g.setLayoutY(g.getLayoutY()+35);
            }
        }

    }
}


