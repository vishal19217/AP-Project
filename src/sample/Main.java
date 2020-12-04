package application;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
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
         
public class Main extends Application { 
   @Override 
   public void start(Stage stage) { 
	   StackPane ss = new StackPane();
	   AnchorPane uu = new AnchorPane();
	   ss.getChildren().add(uu);
      
      Rectangle line = new Rectangle(165,173,150,17);
      line.setFill(Color.RED);
      Rectangle line1 = new Rectangle(332,173,150,17);
      line1.setFill(Color.BLUE);
      Rectangle line2 = new Rectangle(315,190,17,150);
      line2.setFill(Color.YELLOW);
      Rectangle line3 = new Rectangle(318,23,17,150);
      line3.setFill(Color.GREEN);
      
      
       
      
      
      
         
      //Creating a Group object  
      Group root = new Group(line,line1,line2,line3); uu.getChildren().add(root);
//      RotateTransition uu = new RotateTransition(Duration.seconds(3),root);uu.setCycleCount(RotateTransition.INDEFINITE);
//      uu.setFromAngle(0);uu.setToAngle(360);uu.play();
      Timeline animation = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(root.rotateProperty(), 0, Interpolator.LINEAR)),
            new KeyFrame(Duration.seconds(3), new KeyValue(root.rotateProperty(), 360, Interpolator.LINEAR))
//            new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
            
    );
      
    animation.setCycleCount(Animation.INDEFINITE);
    animation.play();
    Circle up = new Circle(100);uu.getChildren().add(up);
    System.out.println(up.getCenterX()+" "+up.getCenterY()+" "+up.getLayoutX()+" "+up.getLayoutY());
    up.setCenterX(190);up.setCenterY(575);
    Mytimer t = new Mytimer(up);
    t.start();
    
      
         
      //Creating a scene object 
      Scene scene = new Scene(ss, 600, 300); 
      
      
      
      //Setting title to the Stage 
      stage.setTitle("Drawing an arc");
      
      //Adding scene to the stage 
      stage.setScene(scene);
      
      //Displaying the contents of the stage 
      stage.show();
   }
   
   
   public static void main(String args[]){ 
      launch(args); 
   } 
}
 class Mytimer extends AnimationTimer{
	   	private long time = 0;
	   	private Circle pp;
	   	public Mytimer(Circle qq) {
	   		pp=qq;
	   	}

			@Override
			public void handle(long arg0) {
				
				long dt = arg0-time;
				if (dt>15e4) {
					System.out.println(arg0);
					time=arg0;
					pp.setCenterY(pp.getCenterY()+1.4);
					if (pp.getCenterY()>=800) {
						pp.setCenterY(100);
					}
					
					
				}
				
}
			}