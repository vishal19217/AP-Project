package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_ObstacleHit implements Initializable {
    @FXML
    StackPane stackPane;
    @FXML
    Label scorepanel;
    Scene myScene,parentScene,frontScene;
    Stage stage;
    int score;

    FXMLLoader loader;
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

    public void setScore(int score) {
        this.score = score;
        scorepanel.setText(Integer.toString(score));
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
    public void setNewGameLoader(FXMLLoader loader) {
        this.loader = loader;
    }
    public void newGame()throws IOException{

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("New_Game.fxml"));
//        Scene newScene  = new Scene(loader.load());
//        Stage curStage = (Stage) rootPane.getScene().getWindow();
//        Controller_New_Game cg = loader.getController();
//        cg.setScene(newScene);
//        cg.setParentScene(this.myScene);

       FXMLLoader loader  = new FXMLLoader(getClass().getResource("New_Game.fxml"));
        System.out.println("obstaclehit" +loader);

        Scene scene = new Scene(loader.load(),600,800);
                //  System.out.println("frontScene:-"+frontScene);
        //System.out.println(curStage);
        Stage curStage  = stage;
        curStage.setScene(scene);

        curStage.show();
    }


}
