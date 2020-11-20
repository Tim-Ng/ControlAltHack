package p4_group_8_repo.Scenes_controlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.MyStage;

public class main_page{
    private Main main;
    private MyStage mainStage;
    private Scene mainScene;
    public main_page(Main main)
    {
        this.main = main;
        mainStage = new MyStage();
        BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Assets/iKogsKW.png");
        Button startButton = new Button ("Start Game");
        startButton.setLayoutY(250);
        startButton.setLayoutX(100);
        startButton.setMinSize(100,100);
        Button InfoPageButton = new Button ("Game Info");
        InfoPageButton.setLayoutY(150);
        InfoPageButton.setLayoutX(100);
        InfoPageButton.setMinSize(100,100);
        mainStage.getChildren().addAll(froggerback,startButton,InfoPageButton);
        mainScene = new Scene(mainStage,600,800);
        startButton.setOnAction(e->main.setScene("Stage1Game"));
        InfoPageButton.setOnAction(e->main.setScene("InfoStage"));
        main.setMap("Main_Scene",mainScene);
    }
}
