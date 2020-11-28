package p4_group_8_repo.Object_Controllers.InteractiveObjects;

import javafx.scene.image.Image;
import p4_group_8_repo.Object_Controllers.Actor;

/***
 * This class is to set and control the End object
 */
public class End extends Actor {
	/***
	 * If the area of End area is reached then true else false
	 */
	private boolean activated = false;

	/***
	 * Override actor act
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}

	/***
	 * To set the position of the end
	 * @param x Set location of X of the End
	 * @param y Set location of Y of the End
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/p4_group_8_repo/Assets/GameObjects/End.png", 60, 60, true, true));
	}

	/***
	 * When the end is set this function is called
	 */
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/Assets/GameObjects/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/***
	 * To check if this end is activated
	 * @return return if this end is activated
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
