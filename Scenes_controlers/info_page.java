package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.Animal;
import p4_group_8_repo.Object_Controlers.MyStage;

import javax.swing.*;
import javafx.scene.control.Button;
import java.awt.*;

public class info_page {
    private Main main;
    private MyStage infoStage;
    private Scene infoScene;
    private Animal infoAnimal;
    public info_page(Main main){
        this.main = main;
        infoStage = new MyStage();
        infoAnimal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",300.0,0.0,600.0,300.0);
        ScrollPane pageScroll = new ScrollPane();
        Button BackButton = new Button("Back");
        BackButton.setLayoutY(0);
        BackButton.setLayoutX(0);
        BackButton.setMinSize(100,50);
        infoStage.add(infoAnimal);
        infoStage.getChildren().addAll(BackButton);
        infoStage.start();
        infoScene =new Scene (infoStage,600,800);
        BackButton.setOnAction(e->main.setScene("Main_Scene"));
        main.setMap("InfoStage",infoScene);
    }
    public Scene info_pageGetScene(){
        return infoScene;
    }
}
