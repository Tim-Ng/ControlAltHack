package p4_group_8_repo.Object_Controllers.InteractiveObjects;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controllers.Actor;

/***
 * This class is to set and control the wet turtles
 */
public class WetTurtle extends Actor {
	/***
	 * Hold image of turtle1
	 */
	private Image turtle1;
	/***
	 * Hold image of turtle2
	 */
	private Image turtle2;
	/***
	 * Hold image of turtle3
	 */
	private Image turtle3;
	/***
	 * Hold image of turtle4
	 */
	private Image turtle4;
	/***
	 * Hold the speed of the WetTurtle
	 */
	private int speed;
	/***
	 * If the turtle has sunk = true else false
	 */
	private boolean sunk = false;

	/***
	 * Override the act in actor
	 * Will change the image of the turtle of the according to the time.
	 * Will move with the speed set.
	 * If the X axis is more than 600 then will set to -200.
	 * Else if X axis in lesser than -75 then will set to 600.
	 * @param now current time
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/***
	 * Set the position of the wetTurtle
	 * @param xpos set starting the X position
	 * @param ypos set starting the Y position
	 * @param s set the speed of the turtle
	 * @param w set the width of the turtle
	 * @param h set the height of the turtle
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/***
	 * To check if the turtle has sunk or not
	 * @return if the wet turtle has sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
}
