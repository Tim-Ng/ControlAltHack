package p4_group_8_repo.Tamplates.GameLv;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controllers.*;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.*;
import p4_group_8_repo.SceneClasses.ButtonClass;
import p4_group_8_repo.SceneClasses.gameSceneClasses.GameScene;
import p4_group_8_repo.SceneClasses.main_page;

/***
 * This is a template of a game level.
 * To add this game level go to Main class and create an object of this class and a string key.
 * Example : public static final String GameWhich = "ChooseGameLvWhich";
 * Example : private GameScene GamelvWhich = new gameTemplate();
 *
 * Then add it into the scene manager
 * Example : sceneController.setGameMap(GamelvWhich,gameTemplate);
 *
 * Create a high score page for this level with background created using the photoshop files in Main class and its key.
 * Then add it to the scene manage.
 * Exmaple : public static final String HighScoreWhich = "HighScoreLvWhich";
 * Exmaple : private GetHighScoreScene highScoreWhich = new highScorePage("src/p4_group_8_repo/SceneClasses/HighScore/HighScoreDatas/scoresStageWhich.dat","file: [path to the background without score]","file: [path to the background with score]");
 * Exmaple : sceneController.setHighScoreMap(HighScoreWhich,highScoreWhich);
 * Remeber to edit the code in line 167 to call the correct scene when the game ends
 *
 * Then go to ChooseLevel class to create a new button for this level with graphic that can be made in the photoSopFiles.
 * Then go to ChooseWhichHighScorePage class to create a new button for this level with graphic that can be made in the photoSopFiles.
 */
public class gameTemplate implements GameScene {
    /***
     * Hold the class Animal for the avatar
     */
    private Animal animal;
    /***
     * This is to hold the elements of the page of the game level
     */
    private MyStage StageName;
    /***
     * This is to hold the Scene of the page of the game level
     */
    private Scene gameSceneName;
    /***
     * Hold Animation timer
     */
    private AnimationTimer timer;

    /***
     * Call the function inputToStage() to start arranging the elements and set the Scene
     */
    public gameTemplate()
    {
        inputToStage();
    }

    /***
     * To start arranging the elements and set the Scene
     */
    public void inputToStage(){
        //Creating the MyStage object
        StageName = new MyStage();

        //Creating the backgroud object and adding it into the stage
        BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/iKogsKW.png");
        StageName.add(froggerback);

        //This is to go back to the main page and quit the current level
        Button BackButton= new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        StageName.getChildren().add(BackButton);
        BackButton.setOnAction(e->quitGame());

        //Example of adding logs into the stage
        StageName.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 0, 166, 0.75));
        StageName.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 0, 276, -2));

        //Example of adding Turtle into the stage
        StageName.add(new Turtle(500, 376, -1, 130, 130));

        //Example of adding WetTurtle into the stage
        StageName.add(new WetTurtle(200, 217, -1, 130, 130));

        //Example of adding End into the stage (which are usally at the same place)
        StageName.add(new End(8,96));
        StageName.add(new End(141-5,96));
        StageName.add(new End(141 + 141-16,96));
        StageName.add(new End(141 + 141-16+141-16+1,96));
        StageName.add(new End(141 + 141-16+141-13+141-16+3,96));

        //Creating areas for the water areas
        coordinateArea Area1 = new coordinateArea(0,150,600,413);

        //Adding the area into a water area object
        waterArea waterDeath = new waterArea(Area1); //(can insert multiple)

        //This is for the border
        coordinateArea Border = new coordinateArea(0,100,600,734);

        //Adding an animal into the stage
        animal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",waterDeath,300,679.8,Border);
        StageName.add(animal);

        //Example of adding obstacles
        StageName.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 0, 649, 1, 120, 120));
        StageName.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 597, -1, 50, 50));
        StageName.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 0, 540, 1, 200, 200));
        StageName.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 500, 490, -5, 50, 50));
        StageName.add(new Digit(0, 40, 290, 40));

        //Example of adding a wall
        StageName.add(new wall(355,280,250,40));

        //Example of adding a pushing wall
        StageName.add(new PushingWall(250,500,1,100,50));

        //Starting all the objects in the stage
        StageName.start();

        //Creating
        gameSceneName =new Scene(StageName,600,800);
    }
    /***
     * To get the Scene of the page of the game level 1
     * @return Scene of the page of the game level 1
     */
    public Scene getScene(){
        return gameSceneName;
    }

    /***
     * To stop the timer of the game
     */
    public void stop() {
        timer.stop();
    }

    /***
     * To set the images and display the scores of the game
     * @param n The score to output
     */
    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            StageName.add(new Digit(k, 40, 290 - shift, 40));
            shift+=30;
        }
    }

    /***
     * To create and start the timer for the game
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    StageName.stopMusic();
                    stop();
                    StageName.stop();
                    //Main.sceneController.startHighScoreScene(Main.HighScoreWhich,animal.getPoints());
                    ResetStage();

                    //Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    //alert.setTitle("You Have Won The Game!");
                    //alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    //alert.setContentText("Highest Possible Score: 800");
                    //alert.show();
                }
            }
        };
    }

    /***
     * To start the game and music
     */
    public void start() {
        if (main_page.MusicOn){
            StageName.playMusic();
        }
        int holdpoint = Main.sceneController.getHighestScore(Main.HighScore1);
        int shift = 0;
        StageName.add(new Digit(0, 40, 570, 40));
        while (holdpoint > 0) {
            int d = holdpoint / 10;
            int k = holdpoint - d * 10;
            holdpoint = d;
            StageName.add(new Digit(k, 40, 570 - shift, 40));
            shift += 40;
        }
        createTimer();
        timer.start();
    }

    /***
     * To rest the game so that the game is ready to play again
     */
    public void ResetStage(){
        StageName.getChildren().clear();
        inputToStage();
    }

    /***
     * Quit game
     */
    public void quitGame(){
        StageName.stopMusic();
        stop();
        StageName.stop();
        Main.sceneController.startPageScene(Main.MainPage);
        ResetStage();
    }
}
