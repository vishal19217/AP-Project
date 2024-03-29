package sample;
import java.util.*;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.shape.*;

         
public class CrossObstacle extends Obstacle {
    private Rectangle line,line1,line2,line3,recs,recs1,recs2,recs3;
    Star s;
    Group g= new Group();
    public Path myStar ;
    AnchorPane anchorPane ;
    Timeline tl1 = new Timeline();

    @Override
    public void initialpos(){

        g.setLayoutY(-300);
    }
   
	@Override 
   public void addObstacle(Timeline tll,AnchorPane anchorPane) {
        s = new Star(300,170);
        Path pt = s.draw();
        myStar = pt;
        isVisible = true;
	    int dx = 60;
        this.anchorPane = anchorPane;
        line = new Rectangle(120-dx,160,110,15);
        line.setFill(Color.BLUE);
        line1 = new Rectangle(245-dx,160,110,15);
        line1.setFill(Color.CRIMSON);

        line2 = new Rectangle(230-dx,175,15,110);
        line2.setFill(Color.YELLOW);
        line3 = new Rectangle(230-dx,50,15,110);
        line3.setFill(Color.DARKVIOLET);
        recs = new Rectangle(345-dx,160,110,15);
        recs.setFill(Color.CRIMSON);
        recs1 = new Rectangle(470-dx,160,110,15);
        recs1.setFill(Color.BLUE);
        recs2 = new Rectangle(455-dx,175,15,110);
        recs2.setFill(Color.YELLOW);
        recs3 = new Rectangle(455-dx,50,15,110);
        recs3.setFill(Color.DARKVIOLET);


        Group tl = new Group();
        Group root = new Group();
        tl.getChildren().addAll(recs,recs1,recs2,recs3);

      //Creating a Group object  
      root.getChildren().addAll(line,line1,line2,line3);


      g.getChildren().addAll(tl,root,pt);





        tll.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(root.rotateProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(4), new KeyValue(root.rotateProperty(), 360, Interpolator.LINEAR)),
        new KeyFrame(Duration.ZERO, new KeyValue(tl.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(tl.rotateProperty(), -360, Interpolator.LINEAR)),
        new KeyFrame(Duration.ZERO, new KeyValue(pt.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(pt.rotateProperty(), -360, Interpolator.LINEAR)));




    }
    public void resetpos(){

        anchorPane.getChildren().add(g);

        g.setLayoutY(-200);
        s.setVisibility(true);
        myStar.setVisible(true);
        //tl.setLayoutY();
        isVisible =true;
    }
@Override
public int checkCollision(Circle ball) {
	ArrayList<Rectangle> compo = new ArrayList<>();
    compo.add(line);compo.add(line1);
    compo.add(line2);compo.add(line3);
    compo.add(recs);compo.add(recs1);
    compo.add(recs2);compo.add(recs3);
    
    for(Rectangle ls:compo){
        Shape intersect = Shape.intersect(ls,ball);
        if(intersect.getBoundsInLocal().getWidth()!=-1) {
           if(checkCorrectCollision(ls,ball)){
               return 1;
           }
           else{
               return 0;
           }
        }

    }
    return -1;
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
public boolean checkCorrectCollision(Rectangle ls, Circle ball) {
	if(ls.getFill()==ball.getFill()){
        return true;
    }
    else{
        return false;
    }
}
    int tot_distance = 0;
    @Override
    public void moveDown() {


        if(g.getBoundsInParent().getMinY()>=550){
            anchorPane.getChildren().remove(g);

            isVisible = false;
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
