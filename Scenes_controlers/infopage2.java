package p4_group_8_repo.Scenes_controlers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.*;

public class infopage2 {
    private Main main;
    private MyStage infoStage;
    private Scene infoScene;
    private Animal infoAnimal;
    public infopage2(Main main){
        this.main = main;
        infoStage = new MyStage();
        BackgroundImage infoPageBackGround = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/infoPage2BackGround.png");
        infoStage.add(infoPageBackGround);
        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();

        infoStage.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 200, 250, -2));
        infoStage.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 600, 250, -2));

        infoStage.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 200, 320, 0.75));
        infoStage.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 400, 320, 0.75));
        infoStage.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 600, 320, 0.75));

        infoStage.add(new Turtle(200, 370, -1, 130, 130));
        infoStage.add(new Turtle(400, 370, -1, 130, 130));
        infoStage.add(new Turtle(600, 370, -1, 130, 130));

        infoStage.add(new WetTurtle(200, 420, -1, 130, 130));
        infoStage.add(new WetTurtle(400, 420, -1, 130, 130));
        infoStage.add(new WetTurtle(600, 420, -1, 130, 130));
        infoStage.start();
        infoStage.getChildren().addAll(BackButton);
        infoScene =new Scene (infoStage,600,800);
        BackButton.setOnAction(e->main.setScene("Info1Stage"));
        main.setMap("Info2Stage",infoScene);

    }
}
