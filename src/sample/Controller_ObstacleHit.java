package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_ObstacleHit implements Initializable {
    @FXML
    StackPane stackPane;
    Scene myScene,parentScene,frontScene;
    Stage stage;
    public void setMyScene(Scene scene){
        this.myScene = scene;
    }
    public void setStage(Stage stage){
        this.stage  = stage;
    }
    public void setParentScene(Scene scene){
        this.parentScene = scene;
    }
    public void setFrontScene(Scene scene){
        this.frontScene = scene;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void exitGame() throws IOException {
        Parent secondView;;

        secondView = (StackPane) FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene newScene = frontScene;
        Stage curStage = stage;
        System.out.println("frontScene:-"+frontScene);
        System.out.println(curStage);
        curStage.setScene(frontScene);
        curStage.show();

    }
}
