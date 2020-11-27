package p4_group_8_repo.SceneClasses.info_pageSceneClasses;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.*;
import p4_group_8_repo.Object_Controlers.ButtonClass;
import p4_group_8_repo.Object_Controlers.InteractiveObjects.Log;
import p4_group_8_repo.Object_Controlers.InteractiveObjects.Turtle;
import p4_group_8_repo.Object_Controlers.InteractiveObjects.WetTurtle;

/***
 * This is to set the page of info page 2
 */
public class infopage2 {
    /***
     * This is to hold the elements of the page of info page 2
     */
    private MyStage infoStage;
    /***
     * This is to hold the Scene of the page of info page 2
     */
    private Scene infoScene;
    /***
     * To start arranging the elements and set the Scene
     */
    public infopage2(){
        infoStage = new MyStage();
        BackgroundImage infoPageBackGround = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/infoPage2BackGround.png");
        infoStage.add(infoPageBackGround);
        Button BackButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);

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
        BackButton.setOnAction(e->Main.sceneController.startPageScene(Main.InfoPage1));
    }
    /***
     * To get the Scene of the page of info page 2
     * @return Scene of the page of info page 2
     */
    public Scene getInfo2Scene(){
        return infoScene;
    }
}
