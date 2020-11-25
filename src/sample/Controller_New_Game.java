package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Arc;

import java.net.URL;

import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import javax.xml.transform.sax.SAXResult;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Timeline animation = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc1.startAngleProperty(), arc1.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc2.startAngleProperty(), arc2.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc3.startAngleProperty(), arc3.getStartAngle() - 360, Interpolator.LINEAR)),
                new KeyFrame(Duration.ZERO, new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle(), Interpolator.LINEAR)),
                new KeyFrame(Duration.seconds(4), new KeyValue(arc4.startAngleProperty(), arc4.getStartAngle() - 360, Interpolator.LINEAR))
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();


    }
}
