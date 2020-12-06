package application;
import java.util.ArrayList;

import javafx.scene.shape.Shape;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path; 
         
public class Cross_Obstacle extends Obstacle { 
	private Rectangle line,line1,line2,line3,recs,recs1,recs2,recs3;
   @Override 
   public void addObstacle(AnchorPane ap,Timeline tls) { 
      
      line = new Rectangle(120,160,110,15);
      line.setFill(Color.BLUE);
      line1 = new Rectangle(245,160,110,15);
      line1.setFill(Color.RED);
      line2 = new Rectangle(230,175,15,110);
      line2.setFill(Color.YELLOW);
     line3 = new Rectangle(230,50,15,110);
      line3.setFill(Color.GREEN);
      recs = new Rectangle(345,160,110,15);
      recs.setFill(Color.RED);
      recs1 = new Rectangle(470,160,110,15);
      recs1.setFill(Color.BLUE);
     recs2 = new Rectangle(455,175,15,110);
      recs2.setFill(Color.YELLOW);
      recs3 = new Rectangle(455,50,15,110);
      recs3.setFill(Color.GREEN);
      Group tl = new Group();
      tl.getChildren().addAll(recs,recs1,recs2,recs3);
      
      
      
       
      
      
      
         
      //Creating a Group object  
      Group root = new Group(line,line1,line2,line3);ap.getChildren().addAll(root,tl); 
//      RotateTransition uu = new RotateTransition(Duration.seconds(3),root);uu.setCycleCount(RotateTransition.INDEFINITE);
//      uu.setFromAngle(0);uu.setToAngle(360);uu.play();
      tls.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(root.rotateProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(3), new KeyValue(root.rotateProperty(), 360, Interpolator.LINEAR)),
            new KeyFrame(Duration.ZERO, new KeyValue(tl.rotateProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(3), new KeyValue(tl.rotateProperty(), -360, Interpolator.LINEAR))
//            new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
            
    );
    
      
         
      //Creating a scene object 
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
}
