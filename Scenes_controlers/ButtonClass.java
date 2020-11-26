package p4_group_8_repo.Scenes_controlers;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/***
 * This class is to set the image and style for buttons
 */
public class ButtonClass extends Button{
    /***
     * Set the button with image and invisible background without location
     * @param imageLocation the path of the image for the button
     * @param sizeX the size of the button which is the width
     * @param sizeY the szie of the button which is the height
     */
    public ButtonClass(String imageLocation,double sizeX,double sizeY){
        super();
        Image ButtonImage = new Image(imageLocation,sizeX,sizeY,true,false);
        ImageView ButtonImageview = new ImageView(ButtonImage);
        setGraphic(ButtonImageview);
        setStyle("-fx-background-color: transparent; ");
    }

    /***
     * Set the button with image and invisible background with location
     * @param imageLocation the path of the image for the button
     * @param sizeX the size of the button which is the width
     * @param sizeY the szie of the button which is the height
     * @param LayoutX to set the location of the button on the X axis
     * @param LayoutY to set the location of the button on the Y axis
     */
    public ButtonClass(String imageLocation,double sizeX,double sizeY,double LayoutX,double LayoutY){
        super();
        Image ButtonImage = new Image(imageLocation,sizeX,sizeY,true,false);
        ImageView ButtonImageview = new ImageView(ButtonImage);
        setGraphic(ButtonImageview);
        setLayoutX(LayoutX);
        setLayoutY(LayoutY);
        setStyle("-fx-background-color: transparent; ");
    }

}
