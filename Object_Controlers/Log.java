package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;

/***
 * This class is to set and control the logs
 */
public class Log extends Actor {
	/***
	 * The speed of the moving log
	 */
	private double speed;

	/***
	 * Set the movement of the log as time goes on.
	 * If the X axis is more than 600 then will set to -180.
	 * Else if X axis in lesser than -300 then will set to 700.
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/***
	 * Set log position and speed
	 * @param imageLink the path of the image of the log
	 * @param size the size of the log
	 * @param xpos the start X position of the log
	 * @param ypos the start Y position of the log
	 * @param s the speed of the log
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}

	/***
	 * To check if the log is moving to the left or not
	 * @return if speed is lesser than 0 than returns true else false
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
