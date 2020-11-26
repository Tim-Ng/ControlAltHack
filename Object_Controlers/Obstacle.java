package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controlers.Actor;

/***
 * This class is to set and control the Obstacles
 */
public class Obstacle extends Actor {
	/***
	 * the speed of the obstacle
	 */
	private int speed;

	/***
	 * Set the movement of the obstacle as time goes on.
	 * If the X axis is more than 600 then will set to -200.
	 * Else if X axis in lesser than -50 then will set to 600.
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}

	/***
	 * Set log position and speed
	 * @param imageLink the path of the image of the log
	 * @param xpos the start X position of the log
	 * @param ypos the start Y position of the log
	 * @param s the speed of the log
	 * @param w set the width of the Obstacle
	 * @param h set the height of the Obstacle
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
