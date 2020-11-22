package p4_group_8_repo.Scenes_controlers;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controlers.Actor;

public class PushingWall extends Actor {
    private int speed;
    boolean bool = true;
    @Override
    public void act(long now) {
        move(speed , 0);
        if (getX() > 600 && speed>0)
            setX(-200);
        if (getX() < -75 && speed<0)
            setX(600);
    }
    public PushingWall(int xpos, int ypos, int s, int w, int h) {
        setX(xpos);
        setY(ypos);
        speed = s;
        setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/wall.png", w,h, false, true));
    }
    public int getSpeed(){
        return speed;
    }
}
