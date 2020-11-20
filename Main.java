package p4_group_8_repo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p4_group_8_repo.Scenes_controlers.highScorePage;
import p4_group_8_repo.Scenes_controlers.info_page;
import p4_group_8_repo.Scenes_controlers.main_page;
import p4_group_8_repo.Scenes_controlers.stage1;

import java.util.HashMap;

public class Main extends Application {
	private HashMap <String,Scene> sceneFinder = new HashMap<>();
	private Stage primaryStage;
	public static void main(String[] args) { launch(args); }
	main_page MainPageScene = new main_page(this);
	stage1 Stage1 = new stage1(this);
	info_page infopageScene = new info_page(this);

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		setScene("Main_Scene");
	}
	public void setScene(String whichScene){
		if (whichScene == "Stage1Game"){
			Stage1.start();
		}
		primaryStage.setScene(this.sceneFinder.get(whichScene));
		primaryStage.show();
	}
	public void setHighScore(int myScore){
		highScorePage highScorepg = new highScorePage(this,myScore);
	}
	public void setMap(String inputKey,Scene scene){
		this.sceneFinder.put(inputKey,scene);
	}
}
