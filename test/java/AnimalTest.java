import javafx.embed.swing.JFXPanel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.Animal;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.coordinateArea;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.waterArea;
/***
 * This is the class to test the class For test.java.AnimalTest
 */
public class AnimalTest {
    /***
     * The Animal object for the test
     */
    private Animal animal;
    /***
     * This class needs javafx so this is used
     */
    private JFXPanel panel = new JFXPanel();
    /***
     * To set up the animal class copied from gameLv1
     * @throws Exception IF there is error
     */
    @Before
    public void setUp() throws Exception {
        coordinateArea Area1 = new coordinateArea(0,150,600,413);
        waterArea waterDeath = new waterArea(Area1);
        coordinateArea Border = new coordinateArea(0,100,600,734);
        animal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",waterDeath,300,679.8,Border);
    }
    /***
     * To test if the game have ended.
     * Which is the function getStop().
     * Will be false as all the end is not done and animal is new.
     */
    @Test
    public void getStopTest() {
        boolean expectedValue = animal.getStop();
        Assert.assertEquals(expectedValue,false);
    }
    /***
     * To test the function to get amount of points
     * Which is the function getPoints().
     * Will be zero as animal is newly generated and not played therefore the point is 0.
     */
    @Test
    public void getPointsTest() {
        int expextedValue = animal.getPoints();
        Assert.assertEquals(expextedValue,0);
    }
    /***
     * To test the function to check is the points has been changed.
     * Which is the function changeScore().
     * Will be false as there won't be any change in score
     */
    @Test
    public void changeScoreTest() {
        //will be false as animal is not moving
        boolean expectedValue = animal.changeScore();
        Assert.assertEquals(expectedValue,false);
    }
}