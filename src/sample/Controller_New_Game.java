package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;

import java.io.IOException;
import java.net.URL;

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
    StackPane stackPane;
    @FXML
    AnchorPane anchor;
    @FXML
    Label scoreLabel;
    int flag=0;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Timeline animation = new Timeline();
        CircleObstacle c1 = new CircleObstacle(arc1,arc2,arc3,arc4);
        // add circle obstacle to timeline
        c1.addObstacle(animation);

        Ball myBall = new Ball(ball,scoreLabel);
        myBall.setMyObstacle(c1);
        // for moving ball and detecting ball bounce when playButton is pressed
        myBall.moveBall();
        playButton.setOnAction(event -> {
            boolean isPressed = bounceBall();
            myBall.bounceBall();
        });

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    public boolean bounceBall(){
       return true;
    }
    }



