package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.MyStage;

public class ChooseLevel {
    private MyStage chooseLevelStage;
    private Scene chooseLevelScene;
    public ChooseLevel(){
        chooseLevelStage = new MyStage();
        BackgroundImage chooseLevelBackground = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/SelectLvBackground.png");
        chooseLevelStage.add(chooseLevelBackground);
        GridPane gridForButtons = new GridPane();
        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();
        ButtonClass firstLvButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/WhichLevelButton/Level1Button.png",100,100);
        Button firstLvButton = firstLvButtonClass.getButton();

        ButtonClass secondLvButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/WhichLevelButton/Level2Button.png",100,100);
        Button secondLvButton = secondLvButtonClass.getButton();

        ButtonClass thirdLvButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/WhichLevelButton/Level3Button.png",100,100);
        Button thirdLvButton = thirdLvButtonClass.getButton();

        gridForButtons.add(firstLvButton,0,0,1,1);
        gridForButtons.add(secondLvButton,1, 0, 1, 1);
        gridForButtons.add(thirdLvButton,2, 0, 1, 1);
        gridForButtons.setLayoutY(225);
        chooseLevelStage.getChildren().addAll(BackButton,gridForButtons);
        chooseLevelScene = new Scene(chooseLevelStage,600,800);

        firstLvButton.setOnAction(e->Main.sceneControler.startGameScene(Main.Game1));
        secondLvButton.setOnAction(e->Main.sceneControler.startGameScene(Main.Game2));
        thirdLvButton.setOnAction(e->Main.sceneControler.startGameScene(Main.Game3));
        BackButton.setOnAction(e->Main.sceneControler.startPageScene(Main.MainPage));
    }

    public Scene getChooseLevelScene() {
        return chooseLevelScene;
    }
}
