package p4_group_8_repo;

import javafx.application.Application;
import javafx.stage.Stage;
import p4_group_8_repo.SceneClasses.HighScore.ChooseWhichHighScorePage;
import p4_group_8_repo.SceneClasses.HighScore.highScorePage;
import p4_group_8_repo.SceneClasses.gameSceneClasses.*;
import p4_group_8_repo.SceneClasses.SceneController.SceneController;
import p4_group_8_repo.SceneClasses.*;
import p4_group_8_repo.SceneClasses.HighScore.GetHighScoreScene;
import p4_group_8_repo.SceneClasses.info_pageSceneClasses.infopage1;
import p4_group_8_repo.SceneClasses.info_pageSceneClasses.infopage2;

/***
 * The main class when we start
 */
public class Main extends Application {
	/***
	 * Holds a Universal scene controller
	 */
	public static SceneController sceneController;
	/***
	 * Holds a Universal key for the main page
	 */
	public static final String MainPage = "MainPage";
	/***
	 * Holds a Universal key for the Info Page 1
	 */
	public static final String InfoPage1 = "InfoPage1";
	/***
	 * Holds a Universal key for the Info Page 2
	 */
	public static final String InfoPage2 = "InfoPage2";
	/***
	 * Holds a Universal key for the choose game level scene
	 */
	public static final String ChooseGameLv = "ChooseGameLv";
	/***
	 * Holds a Universal key for the choose high score level scene
	 */
	public static final String ChooseHighScoreLv = "ChooseHighScoreLv";
	/***
	 * Holds a Universal key for the game level 1
	 */
	public static final String Game1 = "ChooseGameLv1";
	/***
	 * Holds a Universal key for the high score for game level 1
	 */
	public static final String HighScore1 = "HighScoreLv1";
	/***
	 * Holds a Universal key for the game level 2
	 */
	public static final String Game2 = "ChooseGameLv2";
	/***
	 * Holds a Universal key for the high score for game level 2
	 */
	public static final String HighScore2 = "HighScoreLv2";
	/***
	 * Holds a Universal key for the game level 3
	 */
	public static final String Game3 = "ChooseGameLv3";
	/***
	 * Holds a Universal key for the high score for game level 3
	 */
	public static final String HighScore3 = "HighScoreLv3";
	/***
	 * Hold variable for class main_page
	 */
	private  main_page MainPageScene = new main_page();
	/***
	 * Hold variable for class info_page1
	 */
	private infopage1 infopage1Scene = new infopage1();
	/***
	 * Hold variable for class infopage2
	 */
	private infopage2 infopage2Scene = new infopage2();
	/***
	 * Hold variable for class ChooseLevel
	 */
	private ChooseLevel chooseLevelPage = new ChooseLevel();
	/***
	 * Hold variable for class ChooseWhichHighScorePage
	 */
	private ChooseWhichHighScorePage chooseWhichHighScorePage = new ChooseWhichHighScorePage();
	/***
	 * Hold variable for class GameScene for level 1
	 */
	private GameScene Gamelv1 = new gameLv1();
	/***
	 * Hold variable for class GameScene for level 2
	 */
	private GameScene Gamelv2 = new gameLv2();
	/***
	 * Hold variable for class GameScene for level 3
	 */
	private GameScene Gamelv3 = new gameLv3();
	/***
	 * Hold variable for class GetHighScoreScene for level 1
	 */
	private GetHighScoreScene highScore1 = new highScorePage("src/p4_group_8_repo/SceneClasses/HighScore/HighScoreDatas/scoresStage1.dat","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore1.png","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreWithScoreBackground1.png");
	/***
	 * Hold variable for class GetHighScoreScene for level 2
	 */
	private GetHighScoreScene highScore2 = new highScorePage("src/p4_group_8_repo/SceneClasses/HighScore/HighScoreDatas/scoresStage2.dat","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore2.png","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreWithScoreBackground2.png");
	/***
	 * Hold variable for class GetHighScoreScene for level 3
	 */
	private GetHighScoreScene highScore3 = new highScorePage("src/p4_group_8_repo/SceneClasses/HighScore/HighScoreDatas/scoresStage3.dat","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreBackgroundWithoutScore3.png","file:src/p4_group_8_repo/Assets/BackGrounds/HighScoreWithScoreBackground3.png");

	/**
	 * The application's entry point
	 * Then launch a standalone application that takes in the array of command-lines
	 * @param args an array of command-line arguments for the application
	 */
	public static void main(String[] args) { launch(args); }

	/***
	 * The main entry point for all JavaFX applications.
	 * @param primaryStage The Stage for the window
	 * @throws Exception if there is now stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneController = new SceneController(primaryStage);
		sceneController.setPageMap(MainPage,MainPageScene.getScene());
		sceneController.setPageMap(InfoPage1,infopage1Scene.getInfo1Scene());
		sceneController.setPageMap(InfoPage2,infopage2Scene.getInfo2Scene());
		sceneController.setPageMap(ChooseGameLv,chooseLevelPage.getChooseLevelScene());
		sceneController.setPageMap(ChooseHighScoreLv,chooseWhichHighScorePage.getChooseHighScoreScene());
		sceneController.setGameMap(Game1,Gamelv1);
		sceneController.setGameMap(Game2,Gamelv2);
		sceneController.setGameMap(Game3,Gamelv3);
		sceneController.setHighScoreMap(HighScore1,highScore1);
		sceneController.setHighScoreMap(HighScore2,highScore2);
		sceneController.setHighScoreMap(HighScore3,highScore3);
		sceneController.startPageScene(MainPage);
	}

}
