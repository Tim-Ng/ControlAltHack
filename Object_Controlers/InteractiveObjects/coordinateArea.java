package p4_group_8_repo.Object_Controlers;

/***
 * To hold the value of coordinates of a 4 corner area with is the coordinates of the top left corner X1,Y1 and bottom right corner X2,Y2
 */
public class coordinateArea {
    /***
     * to hold the coordinate of x1
     */
    private double x1;
    /***
     * to hold the coordinate of y1
     */
    private double y1;
    /***
     * to hold the coordinate of x2
     */
    private double x2;
    /***
     * to hold the coordinate of y2
     */
    private double y2;
    /***
     * This is to set the coordinate of the top left and bottom right corner
     * @param x1 the x coordinate of the top left corner
     * @param y1 the y coordinate of the top left corner
     * @param x2 the x coordinate of the bottom right corner
     * @param y2 the y coordinate of the bottom right corner
     */
    public coordinateArea (double x1,double y1, double x2 ,double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /***
     * To get the x coordinate of the top left corner
     * @return the x coordinate of the top left corner
     */
    public double getX1(){
        return x1;
    }
    /***
     * To get the y coordinate of the top left corner
     * @return the y coordinate of the top left corner
     */
    public double getX2(){
        return x2;
    }
    /***
     * To get the x coordinate of the bottom right corner
     * @return the x coordinate of the bottom right corner
     */
    public double getY1(){
        return y1;
    }
    /***
     * To get the y coordinate of the bottom right corner
     * @return the y coordinate of the bottom right corner
     */
    public double getY2(){
        return y2;
    }
}
