package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;

import java.io.IOException;
import java.net.URL;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.util.ResourceBundle;

public class Controller_New_Game implements Initializable {
    @FXML
    Arc arc1;
    @FXML
    Arc arc2;
    @FXML
    Arc arc3;
    @FXML
    Arc arc4;
    @FXML
    Circle ball;
    @FXML
    Button playButton;
    @FXML
    ImageView imageView;
    @FXML
    StackPane stackPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        button2.setOnAction(event -> {
//            try {
//                load_New_Game();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        Timeline animation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle() - 360, Interpolator.LINEAR)));
                //new KeyFrame(Duration.seconds(3), new KeyValue(ball.centerYProperty(), 250))

        Ball myBall = new Ball(ball);
        myBall.moveBall(playButton);
        playButton.setOnAction(event -> {
            boolean isPressed = bounceBall();
            myBall.bounceBall();
        });
        if(ball.getLayoutY()>=playButton.getLayoutY()){
            ball.setLayoutY(playButton.getLayoutY());
        }
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();


    }
    public boolean bounceBall(){
       return true;
    }
    }



