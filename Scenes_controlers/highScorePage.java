package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.MyStage;

public class highScorePage {
    private Main main;
    private MyStage highScorePageStage;
    private Scene highScoreScene;
    public highScorePage(Main main,int getPoints){
        this.main = main;
        highScorePageStage = new MyStage();
        Button BackButton = new Button("Back");
        BackButton.setLayoutY(0);
        BackButton.setLayoutX(0);
        BackButton.setMinSize(100,50);

        //Text
        highScoreScene = new Scene(highScorePageStage,600,800);
        Label YoureScore = new Label(Integer.toString(getPoints));
        YoureScore.setLayoutX(300);
        YoureScore.setLayoutY(400);


        highScorePageStage.getChildren().addAll(BackButton,YoureScore);
        highScorePageStage.start();
        BackButton.setOnAction(e->main.setScene("Main_Scene"));

        main.setMap("HighScore",highScoreScene);
    }
    public void inputScoreIntoList(int getPoints){

    }
}
