package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;

/***
 * Interface for GameScene
 */
public interface GameScene {
    /***
     * to start the game timer and music
     */
    public void start();

    /***
     * To reset the game to be played again
     */
    public void ResetStage();

    /***
     * To get Scene of the Game Level
     * @return return Scene of the Game Level
     */
    public Scene getScene();
}
