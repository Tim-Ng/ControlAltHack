package p4_group_8_repo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p4_group_8_repo.Scenes_controlers.*;

import java.util.HashMap;

public class Main extends Application {
	private HashMap <String,Scene> sceneFinder = new HashMap<>();
	private Stage primaryStage;
	public static void main(String[] args) { launch(args); }
	main_page MainPageScene = new main_page(this);
	stage1 Stage1 = new stage1(this);
	info_page infopageScene = new info_page(this);
	ChooseLevel chooseLevelPage = new ChooseLevel(this);
	ChooseWhichHighScorePage chooseWhichHighScorePage = new ChooseWhichHighScorePage(this);
	stage2 Stage2 = new stage2(this);
	highScorePage HighSchool;
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		resetHighScore();
		setScene("Main_Scene");
	}
	public void resetHighScore(){
		highScorePage HighScoreStage1 = new highScorePage(this,"scoresStage1.dat","HighScoreStage1","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore1.png");
		highScorePage HighScoreStage2 = new highScorePage(this,"scoresStage2.dat","HighScoreStage2","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore2.png");
	}
	public void setScene(String whichScene){
		if (whichScene == "Stage1Game"){
			Stage1.start();
		}
		else if (whichScene == "Stage2Game"){
			Stage2.start();
		}
		primaryStage.setScene(this.sceneFinder.get(whichScene));
		primaryStage.show();
	}
	public void setHighScoreStage1(int myScore,String WhichDatatype,String whichLvKeyCode,String WhichBackgroundImage){
		highScorePage HighScoreStage = new highScorePage(this,myScore,WhichDatatype,whichLvKeyCode,WhichBackgroundImage);
	}
	public void setMap(String inputKey,Scene scene){
		this.sceneFinder.put(inputKey,scene);
	}
}
