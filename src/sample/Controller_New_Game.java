package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
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
    @FXML
    ImageView image;
    Circle c;
    static FXMLLoader loader=null;
    Scene myScene;
    Scene parentScene;
    Label ll = new Label();
    int flag = 0;
    int i = 0;
    private Obstacle currentObstacle, nextObstacle;
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    public Timeline animation = new Timeline();

    public Ball myBall = null;
    public static  void setLoader(FXMLLoader loader1){
        if(loader==null)
        loader = loader1;
    }
    public  void setScene(Scene scene){
        this.myScene = scene;

    }
    public Scene getScene(){
        return myScene;
    }

    public void setParentScene(Scene scene){
        this.parentScene = scene;
    }
    public Scene getParentScene(){
        return parentScene;
    }


    public StackPane getStackPane() {
        return stackPane;
    }


    //final //
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Obstacle o1 = new CircleObstacle(arc1, arc2, arc3, arc4);
        Obstacle o2 = new TriangleObstacle();
        Obstacle o3 = new CrossObstacle();
        Obstacle o4 = new RectangleObstacle();

        // add all obstacles to list
        obstacles.add(o1);
        o1.addObstacle(animation, anchor);
        obstacles.add(o2);
        o2.addObstacle(animation, anchor);
        obstacles.add(o3);
        o3.addObstacle(animation, anchor);

        i = 0;
        currentObstacle = obstacles.get((i++));

        if (i == 3) {
            i = 0;
        }


        nextObstacle = obstacles.get((i++));
        nextObstacle.resetpos();

        if (i == 3) {
            i = 0;
        }
        myBall = new Ball(ball, scoreLabel);

        myBall.setMyObstacle(currentObstacle);
        // for moving ball and detecting ball bounce when playButton is pressed
        myBall.moveBall();


        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    public boolean bounceBall() {
        return true;
    }

    int t = 0;

    public void changeObstacle(Timeline t1, AnchorPane a, Ball myBall) {
        t++;
        c= new Circle(10,300,10,Color.WHITE);
        anchor.getChildren().add(c);
        currentObstacle = nextObstacle;
        //System.out.println(t);
        nextObstacle = obstacles.get(i++);
        nextObstacle.resetpos();
        myBall.setMyObstacle(currentObstacle);

        if (i == 3) {
            i = 0;
        }

    }

    public void playGameFun() throws IOException {
        boolean isPressed = bounceBall();
        myBall.bounceBall();
        currentObstacle.moveDown();

        nextObstacle.moveDown();
        // int f = 0;

        //System.out.println(currentObstacle.isVisible);
        if (!currentObstacle.isVisible) {
            //  System.out.println("i am moving");

            changeObstacle(animation, anchor, myBall);
        }
        if(myBall.isCollision()){
            animation.stop();
            myBall.callTimerStop();

            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("ObstacleHit.fxml"));
            Scene newScene  = new Scene(loader1.load(),600,800);
            Stage curStage = (Stage) myScene.getWindow();
            Controller_ObstacleHit cg = loader1.getController();
            cg.setMyScene(newScene);
            cg.setParentScene(this.myScene);
            cg.setStage(curStage);

            cg.setNewGameLoader(loader);
            cg.setFrontScene(this.parentScene);
            System.out.println("curStage"+curStage);
            System.out.println(" Controller_new_game:-"+curStage);
            System.out.println("controller_newgame"+loader);
            curStage.setScene(newScene);
            curStage.show();


        }



    }

    public void pausegame() throws FileNotFoundException {
        stackPane.getChildren().remove(anchor);
        AnchorPane ap = new AnchorPane();
        InputStream stream = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\AP-Project\\src\\sample\\pause_control_go_arrow.jpeg");
        Image image = new Image(stream);
        //Creating the image view
        ImageView Pau = new ImageView();
        //Setting image to the image view
        Pau.setImage(image);
        //Setting the image view parameters
        Pau.setX(100);
        Pau.setY(100);

        ll.setText("PAUSE");
        ll.setLayoutY(20);
        ll.setLayoutX(100);
        ll.setTextFill(Color.BLACK);

        Pau.fitHeightProperty();
        Pau.autosize();
        myBall.callTimerStop();
        animation.pause();
        ap.getChildren().addAll(Pau);
        stackPane.getChildren().add(ap);


        Pau.setOnMouseClicked(

                event -> {
                    stackPane.getChildren().remove(ap);
                    stackPane.getChildren().add(anchor);
                    myBall.moveBall();
                    animation.play();


                });


    }


    public void saveGame() {
        System.out.println("Save Game");
    }

}


