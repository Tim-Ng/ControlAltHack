package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.MyStage;

public class ChooseWhichHighScorePage {
    private Main main;
    private MyStage chooseHighScoreStage;
    private Scene chooseHighScoreScene;
    public ChooseWhichHighScorePage(Main main){
        this.main = main;
        chooseHighScoreStage = new MyStage();
        BackgroundImage chooseLevelBackground = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreLevelsSelect.png");
        chooseHighScoreStage.add(chooseLevelBackground);
        GridPane gridForButtons = new GridPane();
        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();
        ButtonClass firstLvButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/WhichLevelButton/Level1Button.png",100,100);
        Button firstLvButton = firstLvButtonClass.getButton();

        ButtonClass secondLvButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/WhichLevelButton/Level1Button.png",100,100);
        Button secondLvButton = secondLvButtonClass.getButton();

        gridForButtons.add(firstLvButton,0,0,1,1);
        gridForButtons.add(secondLvButton,1, 0, 1, 1);
        gridForButtons.setLayoutY(225);
        chooseHighScoreStage.getChildren().addAll(BackButton,gridForButtons);
        chooseHighScoreScene = new Scene(chooseHighScoreStage,600,800);

        firstLvButton.setOnAction(e->main.setScene("HighScoreStage1"));
        BackButton.setOnAction(e->main.setScene("Main_Scene"));
        main.setMap("Choose_HighScore",chooseHighScoreScene);
    }
}
