package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.Digit;
import p4_group_8_repo.Object_Controlers.MyStage;
import p4_group_8_repo.Scenes_controlers.HighScoreControlers.HighscoreManager;
import p4_group_8_repo.Scenes_controlers.HighScoreControlers.Score;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;

public class highScorePage implements GetHighScoreScene{
    private MyStage highScorePageStage;
    private Scene highScoreScene;
    private String File;
    private String BackGroundNoNewPoints;
    private String BackGroundWithNewPoints;
    public highScorePage(String File,String BackGroundNoNewPoints,String BackGroundWithNewPoints){
        this.File =File;
        this.BackGroundNoNewPoints =BackGroundNoNewPoints;
        this.BackGroundWithNewPoints = BackGroundWithNewPoints;
    }
    private void setScene(int getPoints,Boolean ifScore,String whichBackGround){
        highScorePageStage = new MyStage();
        BackgroundImage background = new BackgroundImage(whichBackGround);
        highScorePageStage.add(background);
        HighscoreManager highScoreManager = new HighscoreManager(File);
        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();
        Boolean tempBool = ifScore;
        VBox list_high_scoreBox = new VBox();
        ArrayList<Score> scores = highScoreManager.getHighscoreList();
        int max = 10;
        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            Text new_text = new Text ((i+1)+"]\t"+scores.get(i).getScore());
            new_text.setFont(new Font(40));
            if (tempBool && scores.get(i).getScore() == getPoints){
                new_text.setFill(Color.RED);
                tempBool = false;
            }
            else{
                new_text.setFill(Color.GREENYELLOW);
            }
            list_high_scoreBox.getChildren().add(new_text);
            i++;
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(list_high_scoreBox);
        if (ifScore){
            scrollPane.setPrefSize(200,430);
            scrollPane.setLayoutX(200);
            scrollPane.setLayoutY(350);
        }
        else{

            scrollPane.setPrefSize(200,600);
            scrollPane.setLayoutX(200);
            scrollPane.setLayoutY(240);
        }
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; -fx-padding: 0; -fx-background-insets: 0;");


        highScorePageStage.getChildren().addAll(BackButton,scrollPane);
        highScorePageStage.start();
        BackButton.setOnAction(e->{Main.sceneControler.startPageScene(Main.MainPage);});
        highScorePageStage.start();
        highScoreScene = new Scene(highScorePageStage,600,800);
    }
    public Scene getScene(){
        setScene(0,false,BackGroundNoNewPoints);
        return highScoreScene;
    }
    public Scene getScene(int points){
        setScene(points,true,BackGroundWithNewPoints);
        return highScoreScene;
    }
}
