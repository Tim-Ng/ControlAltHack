package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;

/***
 * This class is to set the background
  */
public class BackgroundImage extends Actor{

	/***
	 * Overriding act for actor
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		
		
	}

	/***
	 * To set image background
	 * @param imageLink the file link to the image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, false, true));
		
	}

}
