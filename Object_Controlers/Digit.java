package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;

/***
 * This class is to convert numbers to presented images
 */
public class Digit extends Actor {
	/***
	 * image size
	 */
	private int dim;
	/***
	 * To set the current Digit image
	 */
	private Image im1;

	/***
	 * Override act in Actor
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub

	}

	/***
	 * set Digit for the current score
	 * @param n what is the digit
	 * @param dim set image size
	 * @param x set postion X of the image
	 * @param y set position Y of the image
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/Assets/ScoreNumberImages/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

	/***
	 * set Digit for the current score with different fonts as in which digit image
	 * @param n what is the digit
	 * @param dim set image size
	 * @param x set postion X of the image
	 * @param y set position Y of the image
	 * @param which which digit image is it
	 */
	public Digit(int n, int dim, int x, int y,String which) {
		im1 = new Image("file:src/p4_group_8_repo/Assets/ScoreNumberImages/"+n+which+".png", dim, dim, true, true);
		setImage(im1);
		setFitHeight(55);
		setFitWidth(55);
		setX(x);
		setY(y);
	}
	
}
