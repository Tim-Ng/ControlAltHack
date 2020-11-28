# Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)

# Refactorizing
First the images used for the game are place into an "Assets" package and they are further grouped in to more packages according to their usage.\
The packages are:
* BackGrounds       [Package] - for background images
* ButtonImages      [Package]- the images for the button
* FrogImagePosition [Package] - All the image animation of the frog (the actor)
* GameObjects       [Package] - All the images for the obstacles objects as well as their animation (wetTurtle)
* InfoPage          [Package] - the images for the key animations in the info page
* ScoreNumberImages [Package] - the images fot the numbers 

Second the classes according their functions. Which are the "Object_Controllers","SceneClasses" and "SceneControllers".\
"Object_Controllers" contains the classes for the obstacles 1 package and 3 classes:
* InteractiveObjects [Package] that has 12 classes:
    * Animal                        [Class]
    * BackgroundImage               [Class]
    * coordinateArea                [Class]
    * Digit                         [Class]
    * End                           [Class]
    * Log                           [Class]
    * Obstacle                      [Class]
    * PushingWall                   [Class]
    * Turtle                        [Class]
    * wall                          [Class]
    * waterArea                     [Class]
    * WetTurtle                     [Class]
* Actor                             [Class]
* MyStage                           [Class]
* World                             [Class]

"SceneClasses" contains the classes for the Scenes:
* gameSceneClasses [Pagckage] that has 5 classes:
    * ChooseLevel                   [Class]
    * gameLv1                       [Class]
    * gameLv2                       [Class]
    * gameLv3                       [Class]
    * GameScene                     [Class]
* HighScore [Pagckage] that has 2 packages and 3 classes:
    * HighScoreControllers [Pagckage] that has 2 classes:
        * HighscoreManager
        * Score
    * HighScoreData [Pagckage] that has 3 data files with hold the high scores of the levels:
        * scoresStage1.dat
        * scoresStage2.dat
        * scoresStage3.dat
    * ChooseWhichHighScorePage      [Class]
    * GetHighScoreScene             [Class]
    * highScorePage                 [Class]
* info_pageSceneClasses [Pagckage] that has 2 classes:
    * infopage1                     [Class]
    * infopage2                     [Class]
* ButtonClass                       [Class]
* main_page                         [Class]

"SceneController" contains the classes for the Scene Controller class:
* SceneController                   [Class]
# Add Scene Controller
