package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneControler {
    private HashMap<String, Scene> scenePageFinder = new HashMap<>();
    private HashMap<String, GameScene> sceneGameFinder = new HashMap<>();
    private HashMap<String, GetHighScoreScene> sceneHighScoreFinder = new HashMap<>();
    private Stage primaryStage;

    public SceneControler(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void startPageScene(String whichScene){
        primaryStage.setScene(this.scenePageFinder.get(whichScene));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public void startGameScene(String whichScene){
        this.sceneGameFinder.get(whichScene).start();
        primaryStage.setScene(this.sceneGameFinder.get(whichScene).getScene());
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public void startHighScoreScene(String whichScene){
        primaryStage.setScene(this.sceneHighScoreFinder.get(whichScene).getScene());
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public void startHighScoreScene(String whichScene,int Points){
        primaryStage.setScene(this.sceneHighScoreFinder.get(whichScene).getScene(Points));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void setPageMap(String inputKey, Scene scene) {
        this.scenePageFinder.put(inputKey, scene);
    }
    public void setGameMap(String inputKey, GameScene gameScene){this.sceneGameFinder.put(inputKey,gameScene);}
    public void setHighScoreMap(String inputKey, GetHighScoreScene getHighScoreScene){this.sceneHighScoreFinder.put(inputKey,getHighScoreScene);}
}
