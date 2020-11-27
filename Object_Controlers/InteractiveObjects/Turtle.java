package p4_group_8_repo.Object_Controlers.InteractiveObjects;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controlers.Actor;

/***
 * This class is to set and control the Turtles
 */
public class Turtle extends Actor {
	/***
	 * hold the image of the TurtleAnimation1
	 */
	private Image turtle1;
	/***
	 * hold the image of the TurtleAnimation2
	 */
	private Image turtle2;
	/***
	 * hold the image of the TurtleAnimation3
	 */
	private Image turtle3;
	/***
	 * hold the speed of the turtle
	 */
	private int speed;

	/***
	 * Override the act in Actor.
	 * Will change the image of the turtle of the according to the time.
	 * Will move with the speed set.
	 * If the X axis is more than 600 then will set to -200.
	 * Else if X axis in lesser than -75 then will set to 600.
	 * @param now current time
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/***
	 * Set the position of the turtle
	 * @param xpos set starting the X position
	 * @param ypos set starting the Y position
	 * @param s set the speed of the turtle
	 * @param w set the width of the turtle
	 * @param h set the height of the turtle
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/Assets/GameObjects/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
