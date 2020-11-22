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

public class highScorePage {
    private Main main;
    private MyStage highScorePageStage;
    private Scene highScoreScene;
    public highScorePage(Main main,String whichHighScore_file,String codeKey,String BackGround){
        this.main = main;
        highScorePageStage = new MyStage();
        BackgroundImage highScoreWithOutScore = new BackgroundImage(BackGround);
        highScorePageStage.add(highScoreWithOutScore);
        HighscoreManager highScoreManager = new HighscoreManager(whichHighScore_file);
        setScene(highScoreManager,false,0,codeKey,highScorePageStage,false);
    }

    public highScorePage(Main main,int getPoints,String whichHighScore_file,String codeKey,String ImageBackGround){
        this.main = main;
        highScorePageStage = new MyStage();
        BackgroundImage highScoreWithScore = new BackgroundImage(ImageBackGround);
        highScorePageStage.add(highScoreWithScore);
        HighscoreManager highScoreManager = new HighscoreManager(whichHighScore_file);
        highScoreManager.addScore(getPoints);
        int holdpoints = getPoints;
        int shift = 0;
        while (holdpoints > 0) {
            int d = holdpoints / 10;
            int k = holdpoints - d * 10;
            holdpoints = d;
            highScorePageStage.add(new Digit(k, 30, 460 - shift, 200, "frog"));
            shift += 40;
        }
        setScene(highScoreManager,true,getPoints,codeKey,highScorePageStage,true);
    }
    private void setScene(HighscoreManager highscoreManager,boolean viewing,int getPoints,String codeKey,MyStage highScorePageStage,Boolean ifScore){
        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();
        Boolean tempBool = ifScore;
        VBox list_high_scoreBox = new VBox();
        ArrayList<Score> scores = highscoreManager.getHighscoreList();
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
        BackButton.setOnAction(e->{main.setScene("Main_Scene");
            main.resetHighScore();});

        highScorePageStage.start();
        highScoreScene = new Scene(highScorePageStage,600,800);
        main.setMap(codeKey,highScoreScene);
    }
}
