package p4_group_8_repo.Object_Controlers.InteractiveObjects;

import java.util.ArrayList;

/***
 * This class is to set the areas for where the water would be
 */
public class waterArea {
    /***
     * Hold a list of array for the coordinate area for the water area
     */
    private ArrayList<coordinateArea> areaList = new ArrayList<>();

    /***
     * empty list
     */
    public waterArea (){ }

    /***
     * Input multiple coordinatesArea
     * @param Coordinates the coordinates of the water area
     */
    public waterArea (coordinateArea...Coordinates){
        for (int i = 0; i < Coordinates.length;i++){
            areaList.add(Coordinates[i]);
        }
    }

    /***
     * To check if the coordinates key are in the water area
     * @param x1 coordinate X to check
     * @param y1 coordinate Y to check
     * @return if it is in the area then = true else false
     */
    public boolean checkCoordinate(double x1,double y1){
        for (int i = 0 ; i< areaList.size() ;i++){
            if (x1 >areaList.get(i).getX1()  && x1 < areaList.get(i).getX2() && y1>areaList.get(i).getY1() && y1<areaList.get(i).getY2()){
                return true;
            }
        }
        return false;
    }
}
