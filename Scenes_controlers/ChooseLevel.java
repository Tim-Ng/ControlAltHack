package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.MyStage;

public class ChooseLevel {
    private Main main;
    private MyStage chooseLevelStage;
    private Scene chooseLevelScene;
    public ChooseLevel(Main main){
        this.main = main;
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

        gridForButtons.add(firstLvButton,0,0,1,1);
        gridForButtons.add(secondLvButton,1, 0, 1, 1);
        gridForButtons.setLayoutY(225);
        chooseLevelStage.getChildren().addAll(BackButton,gridForButtons);
        chooseLevelScene = new Scene(chooseLevelStage,600,800);

        firstLvButton.setOnAction(e->main.setScene("Stage1Game"));
        secondLvButton.setOnAction(e->main.setScene("Stage2Game"));
        BackButton.setOnAction(e->main.setScene("Main_Scene"));
        main.setMap("Choose_Level",chooseLevelScene);
    }
}
