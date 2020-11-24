package p4_group_8_repo.Scenes_controlers;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.*;

import java.util.Objects;

public class gameLv1 implements GameScene{
    private Animal animal;
    private MyStage Stage1;
    private Scene gameScene1;
    private AnimationTimer timer;
    public gameLv1()
    {
        inputToStage();
    }
    public void inputToStage(){
        Stage1 = new MyStage();
        BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/iKogsKW.png");
        Stage1.add(froggerback);

        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 0, 166, 0.75));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 220, 166, 0.75));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 440, 166, 0.75));
        //background.add(new Log("file:src/p4_group_8_repo/Assets/log3.png", 150, 0, 166, 0.75));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 0, 276, -2));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/logs.png", 300, 400, 276, -2));
        //background.add(new Log("file:src/p4_group_8_repo/Assets/logs.png", 300, 800, 276, -2));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 50, 329, 0.75));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 270, 329, 0.75));
        Stage1.add(new Log("file:src/p4_group_8_repo/Assets/GameObjects/log3.png", 150, 490, 329, 0.75));
        //background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));

        Stage1.add(new Turtle(500, 376, -1, 130, 130));
        Stage1.add(new Turtle(300, 376, -1, 130, 130));
        Stage1.add(new WetTurtle(700, 376, -1, 130, 130));
        Stage1.add(new WetTurtle(600, 217, -1, 130, 130));
        Stage1.add(new WetTurtle(400, 217, -1, 130, 130));
        Stage1.add(new WetTurtle(200, 217, -1, 130, 130));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
        //End end2 = new End();
        //End end3 = new End();
        //End end4 = new End();
        //End end5 = new End();
        Stage1.add(new End(13,96));
        Stage1.add(new End(141,96));
        Stage1.add(new End(141 + 141-13,96));
        Stage1.add(new End(141 + 141-13+141-13+1,96));
        Stage1.add(new End(141 + 141-13+141-13+141-13+3,96));
        coordinateArea Area1 = new coordinateArea(0,150,600,413);
        waterArea waterDeath = new waterArea(Area1);
        coordinateArea Border = new coordinateArea(0,100,600,734);
        animal = new Animal("file:src/p4_group_8_repo/Assets/froggerUp.png",waterDeath,300,679.8,Border);
        Stage1.add(animal);
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 0, 649, 1, 120, 120));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 300, 649, 1, 120, 120));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck1"+"Right.png", 600, 649, 1, 120, 120));
        //background.add(new Obstacle("file:src/p4_group_8_repo/Assets/truck1"+"Right.png", 720, 649, 1, 120, 120));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 597, -1, 50, 50));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 250, 597, -1, 50, 50));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 400, 597, -1, 50, 50));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 550, 597, -1, 50, 50));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 0, 540, 1, 200, 200));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 500, 540, 1, 200, 200));
        Stage1.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 500, 490, -5, 50, 50));
        Stage1.add(new Digit(0, 30, 570, 25));
        //background.add(obstacle);
        //background.add(obstacle1);
        //background.add(obstacle2);
        Stage1.start();
        gameScene1 =new Scene(Stage1,600,800);
    }
    public Scene getScene(){
        return gameScene1;
    }
    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            Stage1.add(new Digit(k, 30, 570 - shift, 25));
            shift+=30;
        }
    }
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    Stage1.stopMusic();
                    stop();
                    Stage1.stop();
                    Main.sceneControler.startHighScoreScene(Main.HighScore1,animal.getPoints());
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
    public void start() {
        //Stage1.playMusic();
        createTimer();
        timer.start();
    }
    public void ResetStage(){
        Stage1.getChildren().clear();
        inputToStage();
    }
}
