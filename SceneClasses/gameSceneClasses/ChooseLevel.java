package p4_group_8_repo.SceneClasses.gameSceneClasses;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.BackgroundImage;
import p4_group_8_repo.Object_Controllers.MyStage;
import p4_group_8_repo.SceneClasses.ButtonClass;

/***
 * This is to set the select level to play page
 */
public class ChooseLevel {
    /***
     * This is to hold the elements of the select level to play page
     */
    private MyStage chooseLevelStage;
    /***
     * This is to hold the Scene of the select level to play page
     */
    private Scene chooseLevelScene;

    /***
     * This is to set the arrangement and elements of the Scene
     */
    public ChooseLevel(){
        chooseLevelStage = new MyStage();
        BackgroundImage chooseLevelBackground = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/SelectLvBackground.png");
        chooseLevelStage.add(chooseLevelBackground);
        GridPane gridForButtons = new GridPane();
        Button BackButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button firstLvButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/Level1Button.png",100,100);
        Button secondLvButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/Level2Button.png",100,100);
        Button thirdLvButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/Level3Button.png",100,100);
        gridForButtons.add(firstLvButton,0,0,1,1);
        gridForButtons.add(secondLvButton,1, 0, 1, 1);
        gridForButtons.add(thirdLvButton,2, 0, 1, 1);
        gridForButtons.setLayoutY(225);
        chooseLevelStage.getChildren().addAll(BackButton,gridForButtons);
        chooseLevelScene = new Scene(chooseLevelStage,600,800);

        firstLvButton.setOnAction(e->Main.sceneController.startGameScene(Main.Game1));
        secondLvButton.setOnAction(e->Main.sceneController.startGameScene(Main.Game2));
        thirdLvButton.setOnAction(e->Main.sceneController.startGameScene(Main.Game3));
        BackButton.setOnAction(e->Main.sceneController.startPageScene(Main.MainPage));
    }

    /***
     * This is to return the Scene of this select level to play page
     * @return Scene of select level to play page
     */
    public Scene getChooseLevelScene() {
        return chooseLevelScene;
    }
}
