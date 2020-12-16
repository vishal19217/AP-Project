package sample;  
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;  
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;  
import javafx.scene.shape.Path;  
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;  
import javafx.util.Duration;  
public class Star  {
    int k,p;
    Star(int k,int p){
        this.k= k;
        this.p = p;
    }

    public Group draw()  {
//        StackPane sp = new StackPane();
//        AnchorPane ap = new AnchorPane();
//        sp.getChildren().add(ap);
        Path pt = new Path();double s = 1;int k=1,p=1;
        MoveTo moveto = new MoveTo(k+0,p-30);
        LineTo l1 = new LineTo(k-10,p-11);
//        LineTo l2 = new LineTo(-10,-11);
        LineTo l3 = new LineTo(k-30,p-7);
        LineTo l4 = new LineTo(k-16,p+9);
        LineTo l5 = new LineTo(k-19,p+30);
        LineTo l6 = new LineTo(k+0,p+21);
        LineTo l7 = new LineTo(k+19,p+30);
        LineTo l8 = new LineTo(k+16,p+9);
        LineTo l9 = new LineTo(k+30,p-7);
        LineTo l10 = new LineTo(k+10,p-11);
        LineTo l2 = new LineTo(k+0,p-30);
//        pt.addEventFilter(arg0, arg1);
        pt.getElements().add(moveto);
        pt.getElements().addAll(l1,l3,l4,l5,l6,l7,l8,l9,l10,l2);pt.setFill(Color.GOLD);
        Group gg = new Group();
        gg.getChildren().add(pt);
        return gg;

//                new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
                


    }


}
