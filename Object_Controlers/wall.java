package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import p4_group_8_repo.Object_Controlers.Actor;


public class wall extends Actor {
    @Override
    public void act(long now) {
        // TODO Auto-generated method st
    }
    public wall(int xpos, int ypos,int w, int h) {
        setX(xpos);
        setY(ypos);
        setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/wall.png", w,h, false, true));
    }
}
