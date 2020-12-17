import javafx.embed.swing.JFXPanel;
import org.junit.*;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.*;

/***
 * This is the class to test the class For End
 */
public class EndTest {
    /***
     * The End object for the test
     */
    private End endtest;
    /***
     * This class needs javafx so this is used
     */
    private JFXPanel panel = new JFXPanel();

    /***
     * To set up the endtest variable with position (50,50)
     * @throws Exception IF there is error
     */
    @Before
    public void SetUp() throws Exception{
        //example position
        int x=50 , y=50;
        endtest = new End(x,y);
    }
    /***
     * To test the function is Activated in end class.
     * when it is not activated.
     * @throws Exception IF there is error
     */
    @Test
    public void testWhenNotActivatedEnd() throws Exception{
        boolean isActivated =endtest.isActivated();
        Assert.assertEquals(isActivated,false);
    }
    /***
     * To test the function is Activated in end class.
     * when it is activated.
     * @throws Exception IF there is error
     */
    @Test
    public void testWhenIsActivatedEnd() throws Exception{
        endtest.setEnd();
        boolean isActivated =endtest.isActivated();
        Assert.assertEquals(isActivated,true);
    }
}