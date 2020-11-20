package p4_group_8_repo.Scenes_controlers.HighScoreControlers;

import java.io.Serializable;
import java.util.ArrayList;

public class Score  implements Serializable {
    private int score;

    public int getScore() {
        return score;
    }

    public Score(int score) {
        this.score = score;
    }
}
