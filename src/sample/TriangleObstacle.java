package sample;
import java.util.ArrayList;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.shape.*; 
import javafx.scene.layout.*;
         
public class TriangleObstacle extends Obstacle {
	private Line line,linee1,linee2;
	Group root = new Group();
	public AnchorPane anchorPane;
	public Path myStar=null;
    Timeline ta1 = new Timeline();

   @Override
   public void addObstacle(Timeline ta,AnchorPane anchorPane) {
      //Creating a Path
       s = new Star(260,170);
       Path pt = s.draw();
       myStar = pt;
     //  anchorPane.getChildren().add(pt);
       this.anchorPane = anchorPane;
       isVisible = true;

       
      //Moving to the starting point 
//      MoveTo moveTo = new MoveTo(150, 150); 
       int dx =-15;
      //Creating 1st line 
//      LineTo line1 = new LineTo(250, 150);
       line = new Line(150-dx,250,350-dx,250);
       line.setStroke(Color.BLUE);line.setStrokeWidth(15);
       linee1 = new Line(350-dx,250,250-dx,250-100*1.732);
       linee1.setStroke(Color.CRIMSON);linee1.setStrokeWidth(10);
       linee2 = new Line(250-dx,250-100*1.732,150-dx,250);
       linee2.setStroke(Color.YELLOW);linee2.setStrokeWidth(10);


      
         
      //Creating a Group object  
       root.getChildren().addAll(line,linee1,linee2,pt);


       ta.getKeyFrames().addAll(
            new KeyFrame(Duration.ZERO, new KeyValue(root.rotateProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(4), new KeyValue(root.rotateProperty(), 360, Interpolator.LINEAR)));

   }

    @Override
    public void initialpos() {
        root.setLayoutY(-160);
    }

    @Override
   public int checkCollision(Circle ball){
       ArrayList<Line>components = new ArrayList<Line>();
       components.add(line);components.add(linee1);
       components.add(linee2);
       for(Line ls:components){
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
    public void resetpos(){
        root.setLayoutY(-160);
        root.setVisible(true);
        isVisible = true;
        myStar.setVisible(true);
        s.setVisibility(true);
        anchorPane.getChildren().add(root);

    }

   public boolean checkCorrectCollision(Line ls,Circle ball) {
       //System.out.println(ball.getFill()+"   "+arc.getStroke());
       if(ls.getStroke()==ball.getFill()){

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
    public void moveDown() {

        // tl.setTranslateY(tl.getLayoutY()+3);
        if(root.getBoundsInParent().getMinY()>=650){
//            ta1.stop();
            isVisible = false;
            anchorPane.getChildren().remove(root);
            root.setVisible(false);
            System.out.println("Traingle removed");
        }
        if(s.isVisible())
            root.setLayoutY(root.getLayoutY()+20);
        else
            root.setLayoutY((root.getLayoutY()+35));

    }
}
