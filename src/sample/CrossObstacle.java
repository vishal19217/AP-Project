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
    Group tl = new Group();
    Group root = new Group();
   
	@Override 
   public void addObstacle(Timeline tl1,AnchorPane anchorPane) {

        line = new Rectangle(120-110,160,110,15);
        line.setFill(Color.BLUE);
        line1 = new Rectangle(245-110,160,110,15);
        line1.setFill(Color.RED);
        line2 = new Rectangle(230-110,175,15,110);
        line2.setFill(Color.YELLOW);
        line3 = new Rectangle(230-110,50,15,110);
        line3.setFill(Color.GREEN);
        recs = new Rectangle(345-110,160,110,15);
        recs.setFill(Color.RED);
        recs1 = new Rectangle(470-110,160,110,15);
        recs1.setFill(Color.BLUE);
        recs2 = new Rectangle(455-110,175,15,110);
        recs2.setFill(Color.YELLOW);
        recs3 = new Rectangle(455-110,50,15,110);
        recs3.setFill(Color.GREEN);







        tl.getChildren().addAll(recs,recs1,recs2,recs3);
      //Creating a Group object  
      root.getChildren().addAll(line,line1,line2,line3);

//      RotateTransition uu = new RotateTransition(Duration.seconds(3),root);uu.setCycleCount(RotateTransition.INDEFINITE);
//      uu.setFromAngle(0);uu.setToAngle(360);uu.play();
        anchorPane.getChildren().add(root);
        anchorPane.getChildren().add(tl);

        root.setTranslateX(anchorPane.getLayoutX());
        tl.setTranslateX(anchorPane.getLayoutX());
        tl1.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(root.rotateProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(4), new KeyValue(root.rotateProperty(), 360, Interpolator.LINEAR)),
        new KeyFrame(Duration.ZERO, new KeyValue(tl.rotateProperty(), 0, Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(tl.rotateProperty(), -360, Interpolator.LINEAR)));
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
public boolean checkCorrectCollision(Rectangle ls, Circle ball) {
	if(ls.getFill()==ball.getFill()){
        return true;
    }
    else{
        return false;
    }
}

    @Override
    public void moveDown() {

    }
}
