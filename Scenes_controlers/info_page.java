package p4_group_8_repo.Scenes_controlers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.Animal;
import p4_group_8_repo.Object_Controlers.MyStage;

import javax.swing.*;
import javafx.scene.control.Button;
import java.awt.*;

public class info_page{
    private Main main;
    private MyStage infoStage;
    private Scene infoScene;
    private Animal infoAnimal;
    public info_page(Main main){
        this.main = main;
        infoStage = new MyStage();
        ScrollPane pageScroll = new ScrollPane();
        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();

        GridPane gridKeys = new GridPane();
        Image Wwhite = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Wwhite.png", 50, 50, true, true);
        Image Wgreen = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Wgreen.png", 50, 50, true, true);
        Image Awhite = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Awhite.png", 50, 50, true, true);
        Image Agreen = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Agreen.png", 50, 50, true, true);
        Image Swhite = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Swhite.png", 50, 50, true, true);
        Image Sgreen = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Sgreen.png", 50, 50, true, true);
        Image Dwhite = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Dwhite.png", 50, 50, true, true);
        Image Dgreen = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Dgreen.png", 50, 50, true, true);
        ImageView Wkey = new ImageView(Wwhite);
        ImageView Akey = new ImageView(Awhite);
        ImageView Skey = new ImageView(Swhite);
        ImageView Dkey = new ImageView(Dwhite);
        gridKeys.add(Wkey,1,0);
        gridKeys.add(Akey,0,1);
        gridKeys.add(Skey,1,1);
        gridKeys.add(Dkey,2,1);
        infoStage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W: Wkey.setImage(Wgreen); break;
                    case A: Akey.setImage(Agreen); break;
                    case S: Skey.setImage(Sgreen); break;
                    case D: Dkey.setImage(Dgreen); break;
                }
            }
        });
        infoStage.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W: Wkey.setImage(Wwhite); break;
                    case A: Akey.setImage(Awhite); break;
                    case S: Skey.setImage(Swhite); break;
                    case D: Dkey.setImage(Dwhite); break;
                }
            }
        });
        gridKeys.setLayoutY(150);
        gridKeys.setLayoutX(50);
        //coordinateArea Border = new coordinateArea(200,50,400,250);
        coordinateArea Border = new coordinateArea(0,0,600,800);
        infoAnimal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",new waterArea(),(300),(150),Border);
        Image FrogArea = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Wwhite.png", 100, 100, true, true);
        ImageView FrogBack = new ImageView(FrogArea);
        FrogBack.setLayoutX(250);
        FrogBack.setLayoutY(100);

        infoStage.add(new PushingWall(100,360,-4,200,50));
        infoStage.getChildren().addAll(BackButton,gridKeys);
        infoStage.add(infoAnimal);
        infoStage.start();
        infoScene =new Scene (infoStage,600,800);
        BackButton.setOnAction(e->main.setScene("Main_Scene"));
        main.setMap("InfoStage",infoScene);

    }
}
