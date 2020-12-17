package sample;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
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
    @FXML
    private Button button2;
    @FXML
    private Button button1;
    @FXML
    private Button button3;

    @FXML
    private StackPane rootPane;
    private Scene myScene;
    public void setScene(Scene myScene){
        this.myScene = myScene;
    }
    public Scene getScene(){
        return myScene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String path = "C:\\Users\\HP\\IdeaProjects\\AP-Project\\src\\sample\\song.mp3";

        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //by setting this property to true, the audio will be played
        mediaPlayer.setAutoPlay(true);
        RotateTransition transition  = new RotateTransition(Duration.seconds(4),circle1);
        transition.setByAngle(360);
        RotateTransition transition1 = new RotateTransition(Duration.seconds(4),circle2);
        transition1.setByAngle(-360);
        RotateTransition transition2 = new RotateTransition(Duration.seconds(4),circle3);
        transition2.setByAngle(360);

      ParallelTransition transition3 = new ParallelTransition(transition,transition1,transition2);
        transition3.setCycleCount(ParallelTransition.INDEFINITE);
        transition3.play();
        button2.setOnAction(event -> {
            try {
                load_New_Game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        button1.setOnAction(event -> {
            try {
                resume_Game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        button3.setOnAction(event -> {
            try {
                exit_Game();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void load_New_Game() throws IOException {
//        Parent secondView;
//        secondView = (StackPane) FXMLLoader.load(getClass().getResource("New_Game.fxml"));
//
//
//        Scene newScene = new Scene(secondView,600,800);
//        Stage curStage = (Stage) rootPane.getScene().getWindow();
//        //curStage.close();
//        curStage.setScene(newScene);
//        curStage.show();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("New_Game.fxml"));
        Scene newScene  = new Scene(loader.load());
        Stage curStage = (Stage) rootPane.getScene().getWindow();
        Controller_New_Game cg = loader.getController();
        System.out.println("controllerloader"+loader);
        cg.setScene(newScene);
        cg.setLoader(loader);
        cg.setParentScene(this.myScene);
        System.out.println(" Controller"+curStage);
        curStage.setScene(newScene);
        curStage.show();


//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

    }
    public void resume_Game() throws IOException{


    }
    public void exit_Game() throws IOException{

    }
}
