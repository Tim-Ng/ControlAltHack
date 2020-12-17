import org.junit.*;
import p4_group_8_repo.SceneClasses.HighScore.HighScoreControllers.*;
/***
 * This is the class to test the class For test.java.ScoreTest
 */
public class ScoreTest {
    /***
     * To hold the class for Score for the test
     */
    private Score scoreTest;
    /***
     * To set up the Score class
     * @throws Exception IF there is error
     */
    @Before
    public void SetUp() throws Exception{
        int x = 500;
        //create score with the score of 500
        scoreTest = new Score(x);
    }
    /***
     * To test the function of getting score.
     * @throws Exception IF there is error
     */
    @Test
    public void testScore() throws Exception{
        int score_value =scoreTest.getScore();
        Assert.assertEquals(score_value,500);
    }
}