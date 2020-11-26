package p4_group_8_repo.Scenes_controlers;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.*;

/***
 * This is to set the page of the game level 2
 */
public class gameLv2 implements GameScene{
    /***
     * Hold the class Animal for the avatar
     */
    private Animal animal;
    /***
     * This is to hold the elements of the page of the game level 2
     */
    private MyStage Stage2;
    /***
     * This is to hold the Scene of the page of the game level 2
     */
    private Scene gameScene2;
    /***
     * Hold Animation timer
     */
    private AnimationTimer timer;
    /***
     * Call the function inputToStage() to start arranging the elements and set the Scene
     */
    public gameLv2()
    {
        inputToStage();
    }
    /***
     * To start arranging the elements and set the Scene
     */
    public void inputToStage(){
        Stage2 = new MyStage();
        BackgroundImage Stage2back = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/stage2BackGround.png");
        Stage2.add(Stage2back);

        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 0, 166, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 220, 166, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 440, 166, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 0, 276, -2));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 400, 276, -2));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 50, 329, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 270, 329, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 490, 329, 0.75));

        Stage2.add(new Turtle(500, 376, -1, 130, 130));
        Stage2.add(new Turtle(300, 376, -1, 130, 130));
        Stage2.add(new WetTurtle(700, 376, -1, 130, 130));
        Stage2.add(new WetTurtle(600, 217, -1, 130, 130));
        Stage2.add(new WetTurtle(400, 217, -1, 130, 130));
        Stage2.add(new WetTurtle(200, 217, -1, 130, 130));

        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 0, 490, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 220, 490, 0.75));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 440, 490, 0.75));

        Stage2.add(new WetTurtle(600, 540, -1, 130, 130));
        Stage2.add(new WetTurtle(400, 540, -1, 130, 130));
        Stage2.add(new WetTurtle(200, 540, -1, 130, 130));

        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 0, 600, -2));
        Stage2.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 400, 600, -2));

        Stage2.add(new Turtle(500, 643, -1, 130, 130));
        Stage2.add(new Turtle(300, 643, -1, 130, 130));
        Stage2.add(new WetTurtle(700, 643, -1, 130, 130));
        Stage2.add(new WetTurtle(600, 217, -1, 130, 130));
        Stage2.add(new WetTurtle(400, 217, -1, 130, 130));
        Stage2.add(new WetTurtle(200, 217, -1, 130, 130));

        Stage2.add(new End(13,96));
        Stage2.add(new End(141,96));
        Stage2.add(new End(141 + 141-13,96));
        Stage2.add(new End(141 + 141-13+141-13+1,96));
        Stage2.add(new End(141 + 141-13+141-13+141-13+3,96));
        coordinateArea WaterArea1 = new coordinateArea(0,150,600,413);
        coordinateArea WaterArea2 = new coordinateArea(0,490,600,690);
        waterArea waterDeath = new waterArea(WaterArea1,WaterArea2);
        coordinateArea Border = new coordinateArea(0,100,600,734);
        animal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",waterDeath,300,679.8,Border);
        Stage2.add(animal);
        Stage2.start();
        gameScene2 =new Scene(Stage2,600,800);
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
            Stage2.add(new Digit(k, 30, 570 - shift, 25));
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
                    Stage2.stopMusic();
                    stop();
                    Stage2.stop();
                    Main.sceneControler.startHighScoreScene(Main.HighScore2,animal.getPoints());
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
        //Stage1.playMusic();
        createTimer();
        timer.start();
    }
    /***
     * To rest the game so that the game is ready to play again
     */
    public void ResetStage(){
        Stage2.getChildren().clear();
        inputToStage();
    }
    /***
     * To get the Scene of the page of the game level 2
     * @return Scene of the page of the game level 2
     */
    public Scene getScene(){
        return gameScene2;
    }
}
