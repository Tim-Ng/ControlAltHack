package p4_group_8_repo.Scenes_controlers;

import java.util.ArrayList;

public class waterArea {
    private ArrayList<coordinateArea> areaList = new ArrayList<>();
    waterArea (coordinateArea...Coordinates){
        for (int i = 0; i < Coordinates.length;i++){
            areaList.add(Coordinates[i]);
        }
    }
    public boolean checkCoordinate(double x1,double y1){
        for (int i = 0 ; i< areaList.size() ;i++){
            if (x1 >areaList.get(i).getX1()  && x1 < areaList.get(i).getX2() && y1>areaList.get(i).getY1() && y1<areaList.get(i).getY2()){
                return true;
            }
        }
        return false;
    }
}
