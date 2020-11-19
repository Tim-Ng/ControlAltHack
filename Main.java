package p4_group_8_repo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p4_group_8_repo.Scenes_controlers.main_page;
import p4_group_8_repo.Scenes_controlers.stage1;

import java.util.HashMap;

public class Main extends Application {
	private HashMap <String,Scene> sceneFinder = new HashMap<>();
	private Stage primaryStage;
	public static void main(String[] args) { launch(args); }

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		main_page MainPageScene = new main_page(this);
		stage1 Stage1 = new stage1(this);
		this.sceneFinder.put("Main_Scene",MainPageScene.getScene());
		this.sceneFinder.put("Stage1Game",Stage1.getGameScene1());
		setScene("Main_Scene");
	}
	public void setScene(String whichScene){
		primaryStage.setScene(this.sceneFinder.get(whichScene));
		primaryStage.show();
	}
}
