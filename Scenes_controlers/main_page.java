package p4_group_8_repo.Scenes_controlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.Actor;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.MyStage;
import p4_group_8_repo.Object_Controlers.Obstacle;

public class main_page{
    private MyStage mainStage;
    private Scene mainScene;
    public main_page()
    {
        mainStage = new MyStage();
        BackgroundImage mainPageBackGround = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/mainPageBackground.png");
        mainStage.add(mainPageBackGround);

        ButtonClass startButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/startGameButton.png",180,45,200,350);
        Button startButton = startButtonClass.getButton();

        ButtonClass InfoPageButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/InfoGameButton.png",180,45,200,400);
        Button InfoPageButton = InfoPageButtonClass.getButton();

        ButtonClass HighScorePageButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/HighScoreButton.png",180,45,200,450);
        Button HighScorePageButton = HighScorePageButtonClass.getButton();

        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 250, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 400, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 550, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 0, 673, 1, 200, 200));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 500, 673, 1, 200, 200));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 500, 623, -5, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 730, -1, 50, 50));
        mainStage.getChildren().addAll(startButton,InfoPageButton,HighScorePageButton);
        mainStage.start();
        mainScene = new Scene(mainStage,600,800);
        startButton.setOnAction(e->Main.sceneControler.startPageScene(Main.ChooseGameLv));
        InfoPageButton.setOnAction(e->Main.sceneControler.startPageScene(Main.InfoPage1));
        HighScorePageButton.setOnAction(e->Main.sceneControler.startPageScene(Main.ChooseHighScoreLv));
    }
    public Scene getScene(){ return mainScene;}
}
