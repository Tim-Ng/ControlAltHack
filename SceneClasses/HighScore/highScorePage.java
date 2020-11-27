package p4_group_8_repo.SceneClasses.HighScore;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.BackgroundImage;
import p4_group_8_repo.Object_Controlers.Digit;
import p4_group_8_repo.Object_Controlers.MyStage;
import p4_group_8_repo.Object_Controlers.ButtonClass;
import p4_group_8_repo.SceneClasses.HighScore.HighScoreControlers.GetHighScoreScene;
import p4_group_8_repo.SceneClasses.HighScore.HighScoreControlers.HighscoreManager;
import p4_group_8_repo.SceneClasses.HighScore.HighScoreControlers.Score;
import javafx.scene.control.ScrollPane;
import java.util.ArrayList;

/***
 * This is to set the page for all high score pages
 */
public class highScorePage implements GetHighScoreScene {
    /***
     * This is to hold the elements of the page of high scores
     */
    private MyStage highScorePageStage;
    /***
     * This is to hold the Scene of the page of high scores
     */
    private Scene highScoreScene;
    /***
     * This is to hold the file path of the stored scores
     */
    private String File;
    /***
     * This is to hold the file path for the background without new score
     */
    private String BackGroundNoNewPoints;
    /***
     * This is to hold the file path for the background with new score
     */
    private String BackGroundWithNewPoints;
    /***
     * To hold high score manager object
     */
    private HighscoreManager highScoreManager;
    /***
     * To set which level high score level
     * @param File to set the file path of the stored scores
     * @param BackGroundNoNewPoints to set the file path for the background without new score
     * @param BackGroundWithNewPoints to set the file path for the background with new score
     */
    public highScorePage(String File,String BackGroundNoNewPoints,String BackGroundWithNewPoints){
        this.File =File;
        this.BackGroundNoNewPoints =BackGroundNoNewPoints;
        this.BackGroundWithNewPoints = BackGroundWithNewPoints;
    }

    /***
     * To start arranging the elements and set the Scene
     * @param getPoints the input of new scores
     * @param ifScore if there is new scores then this is true else false
     * @param whichBackGround to choose with background to use either with new score or without new score
     */
    private void setScene(int getPoints,Boolean ifScore,String whichBackGround){
        highScorePageStage = new MyStage();
        BackgroundImage background = new BackgroundImage(whichBackGround);
        highScoreManager = new HighscoreManager(File);
        highScorePageStage.add(background);
        Button BackButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Boolean tempBool = ifScore;
        if (ifScore){
            highScoreManager.addScore(getPoints);
            int holdpoint = getPoints;
            int shift = 0;
            while (holdpoint > 0) {
                int d = holdpoint / 10;
                int k = holdpoint - d * 10;
                holdpoint = d;
                highScorePageStage.add(new Digit(k, 30, 540 - shift, 200, "frog"));
                shift += 40;
            }
        }
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
        BackButton.setOnAction(e->{Main.sceneController.startPageScene(Main.MainPage);});
        highScorePageStage.start();
        highScoreScene = new Scene(highScorePageStage,600,800);
    }

    /***
     * Get scene without new score
     * @return return scene without new score
     */
    public Scene getScene(){
        setScene(0,false,BackGroundNoNewPoints);
        return highScoreScene;
    }
    /***
     * Get scene with new score
     * @return return scene with new score
     */
    public Scene getScene(int points){
        setScene(points,true,BackGroundWithNewPoints);
        return highScoreScene;
    }

    /***
     * To get the highest score number
     * @return return highest score
     */
    public int getHighestScore(){
        highScoreManager = new HighscoreManager(File);
        highScoreManager.loadScoreFile();
        if (highScoreManager.getHighscoreList().size() == 0){
            return 0;
        }
        else{
            return highScoreManager.getHighscoreList().get(0).getScore();
        }
    }
}
