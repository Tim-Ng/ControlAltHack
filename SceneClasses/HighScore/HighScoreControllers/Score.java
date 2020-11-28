package p4_group_8_repo.SceneClasses.HighScore.HighScoreControllers;

import java.io.Serializable;

/***
 *    Title: Making a simple high-score system
 *    Author: Shaddix
 *    Date: Aug 27 2009
 *    Code version: 1.0
 *    Availability: http://forum.codecall.net/topic/50071-ystem/
 *    This class is to store the scores
 */
public class Score  implements Serializable {
    /***
     * Stores the score
     */
    private int score;

    /***
     * To get the score of this object
     * @return The score of this object
     */
    public int getScore() {
        return score;
    }

    /***
     * To set the score
     * @param score The score to set
     */
    public Score(int score) {
        this.score = score;
    }
}
