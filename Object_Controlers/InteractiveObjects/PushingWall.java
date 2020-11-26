package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controlers.Actor;

/***
 * This class is to set and control the pushing walls
 */
public class PushingWall extends Actor {
    /***
     * hold the speed of the pushing walls
     */
    private int speed;

    /***
     * Override the act in Actor.
     * Will change the image of the pushing wall of the according to the time.
     * Will move with the speed set.
     * If the X axis is more than 600 then will set to -200.
     * Else if X axis in lesser than -75 then will set to 600.
     * @param now current time
     */
    @Override
    public void act(long now) {
        move(speed , 0);
        if (getX() > 600 && speed>0)
            setX(-200);
        if (getX() < -75 && speed<0)
            setX(600);
    }
    /***
     * Set the position of the pushing walls
     * @param xpos set starting the X position
     * @param ypos set starting the Y position
     * @param s set the speed of the pushing walls
     * @param w set the width of the pushing walls
     * @param h set the height of the pushing walls
     */
    public PushingWall(int xpos, int ypos, int s, int w, int h) {
        setX(xpos);
        setY(ypos);
        speed = s;
        setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/wall.png", w,h, false, true));
    }

    /***
     * To get the speed of the wall
     * @return speed of the wall
     */
    public int getSpeed(){
        return speed;
    }
}
