package sample;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Circle circle1;
    @FXML
    private Circle circle2;
    @FXML
    private Circle circle3;
    @FXML
    private Label label1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RotateTransition transition  = new RotateTransition(Duration.seconds(4),circle1);
        transition.setByAngle(360);
        RotateTransition transition1 = new RotateTransition(Duration.seconds(4),circle2);
        transition1.setByAngle(-360);
        RotateTransition transition2 = new RotateTransition(Duration.seconds(4),circle3);
        transition2.setByAngle(360);

      ParallelTransition transition3 = new ParallelTransition(transition,transition1,transition2);
        transition3.setCycleCount(ParallelTransition.INDEFINITE);
        transition3.play();
    }
}
