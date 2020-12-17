package p4_group_8_repo.SceneClasses.HighScore;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.BackgroundImage;
import p4_group_8_repo.Object_Controllers.MyStage;
import p4_group_8_repo.SceneClasses.ButtonClass;

public class ChooseWhichHighScorePage {
    private MyStage chooseHighScoreStage;
    private Scene chooseHighScoreScene;
    public ChooseWhichHighScorePage(){
        chooseHighScoreStage = new MyStage();
        BackgroundImage chooseLevelBackground = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreLevelsSelect.png");
        chooseHighScoreStage.add(chooseLevelBackground);
        GridPane gridForButtons = new GridPane();
        Button BackButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button firstLvButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/Level1Button.png",100,100);

        Button secondLvButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/Level2Button.png",100,100);


        Button thirdLvButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/Level3Button.png",100,100);

        gridForButtons.add(firstLvButton,0,0,1,1);
        gridForButtons.add(secondLvButton,1, 0, 1, 1);
        gridForButtons.add(thirdLvButton,2, 0, 1, 1);
        gridForButtons.setLayoutY(225);
        chooseHighScoreStage.getChildren().addAll(BackButton,gridForButtons);
        chooseHighScoreScene = new Scene(chooseHighScoreStage,600,800);

        firstLvButton.setOnAction(e->Main.sceneController.startHighScoreScene(Main.HighScore1));
        secondLvButton.setOnAction(e->Main.sceneController.startHighScoreScene(Main.HighScore2));
        thirdLvButton.setOnAction(e->Main.sceneController.startHighScoreScene(Main.HighScore3));
        BackButton.setOnAction(e->Main.sceneController.startPageScene(Main.MainPage));
    }

    public Scene getChooseHighScoreScene() {
        return chooseHighScoreScene;
    }
}
