package p4_group_8_repo.SceneClasses;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.*;
import p4_group_8_repo.Scenes_controlers.GameScene;
import p4_group_8_repo.Scenes_controlers.PushingWall;
import p4_group_8_repo.Scenes_controlers.coordinateArea;
import p4_group_8_repo.Scenes_controlers.waterArea;

/***
 * This is to set the page of the game level 3
 */
public class gameLv3 implements GameScene {
    /***
     * Hold the class Animal for the avatar
     */
    private Animal animal;
    /***
     * This is to hold the elements of the page of the game level 3
     */
    private MyStage Stage3;
    /***
     * This is to hold the Scene of the page of the game level 3
     */
    private Scene gameScene3;
    /***
     * Hold Animation timer
     */
    private AnimationTimer timer;
    /***
     * Call the function inputToStage() to start arranging the elements and set the Scene
     */
    public gameLv3()
    {
        inputToStage();
    }
    /***
     * To start arranging the elements and set the Scene
     */
    public void inputToStage(){
        Stage3 = new MyStage();
        BackgroundImage Stage3back = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/stage3BackGround.png");
        Stage3.add(Stage3back);
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 300, 180, 2, 120, 120));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 600, 180, 2, 120, 120));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 220, -2, 50, 50));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 250, 220, -2, 50, 50));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 550, 220, -2, 50, 50));
        Stage3.add(new wall(0,280,250,40));
        Stage3.add(new wall(355,280,250,40));

        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 300, 330, 1, 120, 120));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 500, 380, -3, 50, 50));

        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 0, 597, 1, 120, 120));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 649, -2, 50, 50));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 250, 649, -2, 50, 50));
        Stage3.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 550, 649, -2, 50, 50));
        Stage3.add(new End(13,96));
        Stage3.add(new End(141,96));
        Stage3.add(new End(141 + 141-13,96));
        Stage3.add(new End(141 + 141-13+141-13+1,96));
        Stage3.add(new End(141 + 141-13+141-13+141-13+3,96));

        Stage3.add(new PushingWall(200,440,-1,100,50));
        Stage3.add(new PushingWall(500,440,-1,100,50));
        Stage3.add(new PushingWall(0,440,-1,100,50));

        Stage3.add(new PushingWall(250,500,1,100,50));
        Stage3.add(new PushingWall(550,500,1,100,50));
        Stage3.add(new PushingWall(0,500,1,100,50));

        coordinateArea WaterArea1 = new coordinateArea(0,400,100,550);
        coordinateArea WaterArea2 = new coordinateArea(230,400,350,550);
        coordinateArea WaterArea3 = new coordinateArea(460,400,600,550);
        waterArea waterDeath = new waterArea(WaterArea1,WaterArea2,WaterArea3);
        coordinateArea Border = new coordinateArea(0,100,600,734);
        animal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",waterDeath,300,679.8,Border);
        Stage3.add(animal);
        Stage3.start();
        gameScene3 =new Scene(Stage3,600,800);
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
            Stage3.add(new Digit(k, 30, 570 - shift, 25));
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
                    Stage3.stop();
                    System.out.print("STOPP:");
                    Stage3.stopMusic();
                    stop();
                    Main.sceneControler.startHighScoreScene(Main.HighScore3,animal.getPoints());
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
        Stage3.getChildren().clear();
        inputToStage();
    }
    /***
     * To get the Scene of the page of the game level 3
     * @return Scene of the page of the game level 3
     */
    public Scene getScene(){
        return gameScene3;
    }
}
