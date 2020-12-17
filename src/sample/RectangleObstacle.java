package sample;


import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectangleObstacle extends Obstacle{
    public Rectangle r1,r2,r3,r4;

    Star s = new Star(300,370);;
    public AnchorPane anchorPane;
    //public boolean isVisible;
    Group g =new Group();


    Path pt = new Path();
    public Path myStar = pt;

    @Override
    public void initialpos() {
        g.setTranslateY(400);
    }

    @Override
    public void addObstacle(Timeline t1, AnchorPane a) {
        r1=new Rectangle();
        r2=new Rectangle();
        r3=new Rectangle();
        r4=new Rectangle();
        r1.setLayoutX(0);
        isVisible = true;
        this.anchorPane = a;

        r1.setWidth(100);r2.setWidth(100);r3.setWidth(100);r4.setWidth(100);
        r1.setHeight(17);r2.setHeight(17);r3.setHeight(17);r4.setHeight(17);
        r2.setLayoutX(120);r3.setLayoutX(240);r4.setLayoutX(360);
        r1.setLayoutY(170);r2.setLayoutY(170);r3.setLayoutY(170);r4.setLayoutY(170);
        r1.setFill(Color.RED);
        r2.setFill(Color.YELLOW);
        r3.setFill(Color.GREEN);
        r4.setFill(Color.BLUE);
        g.getChildren().addAll(r1,r2,r3,r4);
        g.setLayoutY(-160);
        a.getChildren().add(g);
        Mytimer t = new Mytimer();t.start();

    }

    @Override
    public void resetpos() {

    }

    @Override
    public int checkCollision(Circle ball) {
        return 0;
    }

    @Override
    public boolean checkStarCollision(Circle ball) {
        if (s.isVisible()) {
            Shape intersect = Shape.intersect(ball,myStar);
            if(intersect.getBoundsInLocal().getWidth()!=-1){
                return true;
            }

            else
            {
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public void moveDown() {
        g.setTranslateY(g.getLayoutY()+3);
        // tl.setTranslateY(tl.getLayoutY()+3);
        if(g.getLayoutY()>=500){
           // anchorPane.getChildren().remove(g);

            //anchorPane.getChildren().remove(tl);
            isVisible = false;
        }

    }
private class Mytimer extends AnimationTimer {
    private long time = 0;

    @Override
    public void handle(long arg0) {
//				System.out.println(arg0);
        long dt = arg0-time;
        if (dt>15e4) {

            time=arg0;
            r1.setLayoutX(r1.getLayoutX()+1);
            r2.setLayoutX(r2.getLayoutX()+1);
            r3.setLayoutX(r3.getLayoutX()+1);
            r4.setLayoutX(r4.getLayoutX()+1);
            System.out.println(r1.getLayoutX()+" "+r4.getLayoutX());
            if (r1.getLayoutX()==480) {

                r1.setLayoutX(0);
            }
            if (r2.getLayoutX()==480) {
                r2.setLayoutX(0);
            }
            if (r3.getLayoutX()==480) {
                r3.setLayoutX(0);
            }
            if (r4.getLayoutX()==480) {
                r4.setLayoutX(0);
            }
        }

    }}
}
