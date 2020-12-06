package sample;

import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public abstract class  Obstacle {
    public abstract void addObstacle(Timeline t1, AnchorPane a);
    public abstract int checkCollision(Circle ball);
    public abstract void moveDown();
}
