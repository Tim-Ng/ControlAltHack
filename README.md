# Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)

# Refactorizing
The images/texture for the game is place in "Assets" package and further group according to where is it used. \
The controllers for the objects are place in the "Object_Controllers" package and further group according to usage. \
The classes that are used for the scene/page are place in "SceneClasses" package and further group according to the type. \
First the images used for the game are place into an "Assets" package and they are further grouped in to more packages according to their usage.\
The packages are:
* BackGrounds       [Package] - for background images
* ButtonImages      [Package]- the images for the button
* FrogImagePosition [Package] - All the image animation of the frog (the actor)
* GameObjects       [Package] - All the images for the obstacles objects as well as their animation (wetTurtle)
* InfoPage          [Package] - the images for the key animations in the info page
* ScoreNumberImages [Package] - the images fot the numbers 

Second the classes according their functions. Which are the "Object_Controllers" and "SceneClasses".\
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

# Add High Score Controller 
These classes are modified from "Auther:Shaddix" which is available from [this link](http://forum.codecall.net/topic/50071-ystem/) . \
The high score controller includes 2 classes "HighscoreManager" and "Score".\
The "HighscoreManager" class reads, sorts ,add and stores the list of "Score" object from data files.\
The "Score" class holds the score of a person.\
The list of "Score" objects are sorted from the highest to the lowest by using a reversed bubble sort algorithm output.\
The "HighscoreManager" class only stores up to 10 scores in to the data files, so that the class does not need to sort 
through multiple Score object everytime.\
The new Scores can be added into "HighscoreManager" class. 

# Added Coordinate Class
"coordinateArea" class are used to hold the coordinates of the top left and the bottom right of a square.\ 
This class is used in the "walls","moving wall","Animla" and "waterArea" classes.

# Modified Animal class
The previous water area and border of "Animal" class are fixed, which in turn limits the creativity to create new levels.\
Therefore, the "Animal" class is modified by using "coordinateArea" object for the border and "waterArea" object for the water areas.\
The "waterArea" holds an array of "coordinateArea" objects and check if the coordinate of x and y is within any of the coordinates define
in the "coordinateArea" object.

# Add new Obstacles
To enhance the experience of the game "walls" and "moving wall" are added. \
The classes that controls them are "wall" and "PushingWall". \
These classes holds objects of the class "coordinateArea". 


# Add Scene Controller
The **Main** class creates objects of main_page,infopage1,infopage2,ChooseLevel,GameScene
,ChooseWhichHighScorePage and highScorePage

