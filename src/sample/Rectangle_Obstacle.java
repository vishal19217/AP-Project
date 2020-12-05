package application;
import java.util.*;
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

         
public class Cross_Obstacle extends Obstacle {
	private Rectangle r1,r2,r3,r4;
   
	@Override 
   public void addObstacle(AnchorPane t1,Timeline tl) { 
	r1=new Rectangle(0,170,100,17);
	r2=new Rectangle(120,170,100,17);
	r3=new Rectangle(240,170,100,17);
	r4=new Rectangle(360,170,100,17);
	r1.setFill(Color.RED);
	r2.setFill(Color.YELLOW);
	r3.setFill(Color.GREEN);
	r4.setFill(Color.BLUE);
	Mytimer t = new Mytimer();t.start();
      
       
   }
	private class Mytimer extends AnimationTimer{
    	private long time = 0;

		@Override
		public void handle(long arg0) {
//			System.out.println(arg0);
			long dt = arg0-time;
			if (dt>15e4) {

				time=arg0;
				r1.setLayoutX(r1.getLayoutX()+1);
				r2.setLayoutX(r2.getLayoutX()+1);
				r3.setLayoutX(r3.getLayoutX()+1);
				r4.setLayoutX(r4.getLayoutX()+1);
				if (r1.getLayoutX()==500) {
					r1.setLayoutX(-40);
				}
				if (r2.getLayoutX()==500) {
					r2.setLayoutX(-40);
				}
				if (r3.getLayoutX()==500) {
					r3.setLayoutX(-40);
				}
				if (r4.getLayoutX()==500) {
					r4.setLayoutX(-40);
				}
			}
			
		}}
    	

@Override
public int checkCollision(Circle ball) {
	ArrayList<Rectangle> compo = new ArrayList<>();
    compo.add(r1);compo.add(r2);
    compo.add(r3);compo.add(r4);
    
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
