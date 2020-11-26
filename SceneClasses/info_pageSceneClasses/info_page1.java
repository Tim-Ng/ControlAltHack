package p4_group_8_repo.SceneClasses;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.*;

import javafx.scene.control.Button;
import p4_group_8_repo.Scenes_controlers.ButtonClass;
import p4_group_8_repo.Scenes_controlers.PushingWall;
import p4_group_8_repo.Scenes_controlers.coordinateArea;
import p4_group_8_repo.Scenes_controlers.waterArea;

/***
 * This is to set the page of info page 1
 */
public class info_page1 {
    /***
     * This is to hold the elements of the page of info page 1
     */
    private MyStage infoStage;
    /***
     * This is to hold the Scene of the page of info page 1
     */
    private Scene infoScene;
    /***
     * Hold the class Animal for the avatar
     */
    private Animal infoAnimal;
    /***
     * To start arranging the elements and set the Scene
     */
    public info_page1(){
        infoStage = new MyStage();
        BackgroundImage infoPageBackGround = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/infoPage1BackGround.png");
        infoStage.add(infoPageBackGround);
        Button BackButton= new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);

        Button nextButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/nextInfoPage.png",120,30,460,0);

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
        gridKeys.setLayoutX(100);
        coordinateArea Border = new coordinateArea(350,125,550,305);
        infoAnimal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",new waterArea(),(450),(215),Border);
        Image FrogArea = new Image("file:src/p4_group_8_repo/Assets/InfoPage/Wwhite.png", 100, 100, true, true);
        ImageView FrogBack = new ImageView(FrogArea);
        FrogBack.setLayoutX(250);
        FrogBack.setLayoutY(100);
        infoStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 600, 535, 2, 120, 120));
        infoStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 580, -2, 50, 50));
        infoStage.add(new wall(100,660,100,50));
        infoStage.add(new wall(300,660,100,50));
        infoStage.add(new PushingWall(200,730,2,100,50));
        infoStage.add(new PushingWall(500,730,2,100,50));
        infoStage.add(new PushingWall(0,730,2,100,50));
        infoStage.getChildren().addAll(BackButton,nextButton,gridKeys);
        infoStage.add(infoAnimal);
        infoStage.start();
        infoScene =new Scene (infoStage,600,800);
        BackButton.setOnAction(e->Main.sceneControler.startPageScene(Main.MainPage));
        nextButton.setOnAction(e->Main.sceneControler.startPageScene(Main.InfoPage2));
    }
    /***
     * To get the Scene of the page of info page 1
     * @return Scene of the page of info page 1
     */
    public Scene getInfo1Scene(){
        return infoScene;
    }
}
