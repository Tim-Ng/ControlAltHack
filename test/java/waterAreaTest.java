import org.junit.*;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.*;
/***
 * This is the class to test the class For test.java.waterAreaTest
 */
public class waterAreaTest {
    /***
     * To hold the waterArea class for the test
     */
    private waterArea waterClassTest;
    /***
     * To set up the waterArea class with the coordinates being (2,2) and (8,8)
     * @throws Exception IF there is error
     */
    @Before
    public void SetUp() throws Exception{
        coordinateArea coordinateFortest = new coordinateArea(2,2,8,8);
        waterClassTest = new waterArea(coordinateFortest);
    }
    /***
     * To test the function of checkCoordinate with the value if x=4 and y=4.
     * Will return true as it is in the coordinates set.
     * @throws Exception IF there is error
     */
    @Test
    public void testIfInWaterArea() throws Throwable{
        //Coordinate that is in box
        int X1= 4,Y1 =4;
        boolean outPut =waterClassTest.checkCoordinate(X1,Y1);
        Assert.assertEquals(outPut,true);
    }
    /***
     * To test the function of checkCoordinate with the value if x=10 and y=10.
     * Will return false as it is not in the coordinates set.
     * @throws Exception IF there is error
     */
    @Test
    public void testIfNotInWaterArea() throws Throwable{

        //Coordinate that is not in box
        int X2= 10,Y2 =10;
        boolean outPut = waterClassTest.checkCoordinate(X2,Y2);
        Assert.assertEquals(outPut,false);
    }

}