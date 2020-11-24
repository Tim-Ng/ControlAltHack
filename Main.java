package p4_group_8_repo;

import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.Scenes_controlers.*;

public class Main extends Application {
	public static SceneControler sceneControler;
	public static final String MainPage = "MainPage";
	public static final String InfoPage1 = "InfoPage1";
	public static final String InfoPage2 = "InfoPage2";
	public static final String ChooseGameLv = "ChooseGameLv";
	public static final String ChooseHighScoreLv = "ChooseHighScoreLv";
	public static final String Game1 = "ChooseGameLv1";
	public static final String HighScore1 = "HighScoreLv1";
	public static final String Game2 = "ChooseGameLv2";
	public static final String HighScore2 = "HighScoreLv2";
	public static final String Game3 = "ChooseGameLv3";
	public static final String HighScore3 = "HighScoreLv3";


	private  main_page MainPageScene = new main_page();
	private info_page1 infopage1Scene = new info_page1();
	private infopage2 infopage2Scene = new infopage2();
	private ChooseLevel chooseLevelPage = new ChooseLevel();
	private ChooseWhichHighScorePage chooseWhichHighScorePage = new ChooseWhichHighScorePage();
	private GameScene Gamelv1 = new gameLv1();
	private GameScene Gamelv2 = new gameLv2();
	private GameScene Gamelv3 = new gameLv3();
	private GetHighScoreScene highScore1 = new highScorePage("scoresStage1.dat","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore1.png","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreWithScoreBackground1.png");
	private GetHighScoreScene highScore2 = new highScorePage("scoresStage2.dat","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore2.png","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreWithScoreBackground2.png");
	private GetHighScoreScene highScore3 = new highScorePage("scoresStage3.dat","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore3.png","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreWithScoreBackground3.png");
	public static void main(String[] args) { launch(args); }

	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneControler = new SceneControler(primaryStage);
		sceneControler.setPageMap(MainPage,MainPageScene.getScene());
		sceneControler.setPageMap(InfoPage1,infopage1Scene.getInfo1Scene());
		sceneControler.setPageMap(InfoPage2,infopage2Scene.getInfo2Scene());
		sceneControler.setPageMap(ChooseGameLv,chooseLevelPage.getChooseLevelScene());
		sceneControler.setPageMap(ChooseHighScoreLv,chooseWhichHighScorePage.getChooseHighScoreScene());
		sceneControler.setGameMap(Game1,Gamelv1);
		sceneControler.setGameMap(Game2,Gamelv2);
		sceneControler.setGameMap(Game3,Gamelv3);
		sceneControler.setHighScoreMap(HighScore1,highScore1);
		sceneControler.setHighScoreMap(HighScore2,highScore2);
		sceneControler.setHighScoreMap(HighScore3,highScore3);
		sceneControler.startPageScene(MainPage);
	}

}
