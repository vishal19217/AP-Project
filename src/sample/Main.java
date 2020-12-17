package sample;
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

import java.io.IOException;

public class Main extends Application { 
   @Override 
   public void start(Stage primaryStage) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
       Scene newScene  = new Scene(loader.load(),600,800);

       Controller  cg = loader.getController();
       cg.setScene(newScene);
       System.out.println("Frontpage"+newScene);
       primaryStage.setTitle("Color Switch");
       System.out.println("main"+primaryStage);
       primaryStage.setScene(newScene);
       primaryStage.show();


//       Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//       primaryStage.setTitle("Hello World");
//       primaryStage.setScene(new Scene(root, 600, 800));
//       primaryStage.show();
   }
   
   
   public static void main(String args[]){ 
      launch(args); 
   } 
}
