package sample;

import javafx.animation.Timeline;
import javafx.scene.shape.Circle;

public abstract class  Obstacle {
    public abstract void addObstacle(Timeline t1);
    public abstract int checkCollision(Circle ball);
}
