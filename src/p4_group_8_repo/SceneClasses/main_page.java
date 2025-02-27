package p4_group_8_repo.SceneClasses;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.BackgroundImage;
import p4_group_8_repo.Object_Controllers.MyStage;
import p4_group_8_repo.Object_Controllers.InteractiveObjects.Obstacle;

/***
 * This is to set the page of main page
 */
public class main_page{
    /***
     * This is to hold the elements of the page of main page
     */
    private MyStage mainStage;
    /***
     * Is music on or off
     */
    public static Boolean MusicOn ;
    /***
     * This is to hold the Scene of the page of main page
     */
    private Scene mainScene;
    /***
     * To start arranging the elements and set the Scene
     */
    public main_page()
    {
        MusicOn = true;
        mainStage = new MyStage();
        BackgroundImage mainPageBackGround = new BackgroundImage("file:src/p4_group_8_repo/Assets/BackGrounds/mainPageBackground.png");
        mainStage.add(mainPageBackGround);

        Button startButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/startGameButton.png",180,45,200,350);
        Button InfoPageButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/InfoGameButton.png",180,45,200,400);
        Button HighScorePageButton = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/HighScoreButton.png",180,45,200,450);
        Button MusicButton = new ButtonClass("file:src/p4_group_8_repo/Assets/MusicIcon/soundOn.png",65,65,255,500);

        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 250, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 400, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 550, 730, -1, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 0, 673, 1, 200, 200));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/truck2Right.png", 500, 673, 1, 200, 200));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 500, 623, -5, 50, 50));
        mainStage.add(new Obstacle("file:src/p4_group_8_repo/Assets/GameObjects/car1Left.png", 100, 730, -1, 50, 50));
        mainStage.getChildren().addAll(startButton,InfoPageButton,HighScorePageButton,MusicButton);
        mainStage.start();
        mainScene = new Scene(mainStage,600,800);
        startButton.setOnAction(e->Main.sceneController.startPageScene(Main.ChooseGameLv));
        InfoPageButton.setOnAction(e->Main.sceneController.startPageScene(Main.InfoPage1));
        HighScorePageButton.setOnAction(e->Main.sceneController.startPageScene(Main.ChooseHighScoreLv));
        Image SoundOnImage = new Image("file:src/p4_group_8_repo/Assets/MusicIcon/soundOn.png",65,65,true,false);
        ImageView SoundOnView = new ImageView(SoundOnImage);
        Image SoundOffImage = new Image("file:src/p4_group_8_repo/Assets/MusicIcon/SoundOff.png",65,65,true,false);
        ImageView SoundOffView = new ImageView(SoundOffImage);
        MusicButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if (MusicOn == true){
                    MusicOn = false;
                    MusicButton.setGraphic(SoundOffView);
                }
                else{
                    MusicOn = true;
                    MusicButton.setGraphic(SoundOnView);
                }
            }
        });
    }
    /***
     * To get the Scene of the page of main page
     * @return Scene of the page of main page
     */
    public Scene getScene(){ return mainScene;}
}
