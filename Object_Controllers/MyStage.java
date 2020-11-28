package p4_group_8_repo.Object_Controllers;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/***
 * This class is to set and control the stage in the of the world
 */
public class MyStage extends World {
	/***
	 * The file path of the music
	 */
	private MediaPlayer mediaPlayer;

	/***
	 * Override the act of the world
	 * @param now current time
	 */
	@Override
	public void act(long now) {
		
	}

	/***
	 *
	 */
	public MyStage() {
		
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
	}

	/***
	 * this will call to play the music
	 */
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/Assets/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/***
	 * this will call to stop the music
	 */
	public void stopMusic() {
		if (mediaPlayer != null){
			mediaPlayer.stop();
		}
	}

}
