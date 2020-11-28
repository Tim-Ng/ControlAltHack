package p4_group_8_repo.SceneClasses.HighScore;

import javafx.scene.Scene;

/***
 * Interface for GameScene
 */
public interface GetHighScoreScene {
    /***
     * To get Scene of the high score Level
     * @return return Scene of the high score Level without new points
     */
    public Scene getScene();

    /***
     * To get Scene of the high score Level
     * @param Points Input the new point that is scored
     * @return return Scene of the high score Level with new points
     */
    public Scene getScene(int Points);
    /***
     * To get the highest score number
     * @return return highest score
     */
    public int getHighestScore();
}
