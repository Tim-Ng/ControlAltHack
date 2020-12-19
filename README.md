# Info
This game uses java 14,JDK 14,JUnit4 and SDK 11.0.1.

# Screenshot of Game


# Refactorizing
The images/texture for the game is place in "Assets" package and further group according to where is it used. \
The class controllers for the objects are place in the "Object_Controllers" package and further group according to usage. \
The classes that are used for the scene/page are place in "SceneClasses" package and further group according to the type. 

# Add Scene Controller
The **Main** class creates objects of main_page,infopage1,infopage2,ChooseLevel,GameScene,
 ChooseWhichHighScorePage and highScorePage, then sends it to the "SceneController" class
 to be stored and used later on.  \
 Using a scene controller allows the program to switch scenes easily. 
 
# Added Main Page
Button to change scene to main_page,infopage1,ChooseLevel,GameScene and to mute or unmute music.

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
in the "coordinateArea" object. \
The previous animal class allows the player to enter and send to spawn of any activated End. Therefore, the code is modified
So that it could not enter the activated End.

# Add new Obstacles
To enhance the experience of the game "walls" and "moving wall" are added. \
The classes that controls them are "wall" and "PushingWall". \
These classes holds objects of the class "coordinateArea". \
Wall don't allows the player to go through it. \
PushingWall will move and push the player when in contact.

 # To create new levels
 The way to create new levels can found in the package named Template in the package that contains other 2 
 package that are photoShopFiles for file to edit the UI images and GameLv which is a template of a game level with all
 the instructions.

# Added current highest score during game
This is so that the player can view the current highest score while playing the game.


