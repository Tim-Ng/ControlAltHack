package p4_group_8_repo.Scenes_controlers;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonClass {
    private Button doneButton;
    public ButtonClass(String imageLocation,double sizeX,double sizeY,double LayoutX,double LayoutY){
        Image ButtonImage = new Image(imageLocation,sizeX,sizeY,true,false);
        ImageView ButtonImageview = new ImageView(ButtonImage);
        Button button = new Button (null,ButtonImageview);
        button.setLayoutX(LayoutX);
        button.setLayoutY(LayoutY);
        button.setStyle("-fx-background-color: transparent; ");
        doneButton = button;
    }
    public Button getButton(){return doneButton;}
}
