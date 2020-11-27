package p4_group_8_repo.Object_Controlers.InteractiveObjects;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Object_Controlers.Actor;

/***
 * This class is to create the user's avatar and control the avatar
 */
public class Animal extends Actor {
	/***
	 * Frog image Up
	 */
	private Image imgW1;
	/***
	 * Frog image Left
	 */
	private Image imgA1;
	/***
	 * Frog image Down
	 */
	private Image imgS1;
	/***
	 * Frog image Right
	 */
	private Image imgD1;
	/***
	 * Frog image Up Jump
	 */
	private Image imgW2;
	/***
	 * Frog image Left Jump
	 */
	private Image imgA2;
	/***
	 * Frog image Down Jump
	 */
	private Image imgS2;
	/***
	 * Frog image Right Jump
	 */
	private Image imgD2;
	/***
	 * current points
	 */
	private int points = 0;
	/***
	 * How many ends has been meet
	 */
	private int end = 0;
	/***
	 * If the key is pressed on the second time = true else = false
	 */
	private boolean second = false;
	/***
	 *  If there is movement will = to false else = true
	 */
	private boolean noMove = false;
	/***
	 * The amount of movement for Y axis
	 */
	private double movement = 13.3333333*2;
	/***
	 * The amount of movement for X axis
	 */
	private double movementX = 10.666666*2;
	/***
	 * Image size
	 */
	private int imgSize = 40;
	/***
	 * If interact with car then carDeath = true else = false
	 */
	private boolean carDeath = false;
	/***
	 * If interact with water then waterDeath = true else = false
	 */
	private boolean waterDeath = false;
	/***
	 * If the game is stopped then stop = true else = false
	 */
	private boolean stop = false;
	/***
	 * If there is the change in the score than changeScore = true else = false
	 */
	private boolean changeScore = false;
	/***
	 * For easier testing change god mode to true
	 * */
	private boolean GodMode = false;
	/***
	 *  Car death animation handler
	 */
	private int carD = 0;
	/***
	 * Spawn position X
	 * */
	private double SpawnPositionX;
	/***
	 * Spawn position Y
	 * */
	private double SpawnPositionY;
	/***
	 * The coordinateArea class with hold the border of the game.
	 * */
	private coordinateArea Border;
	/***
	 * Top most Y the Animal has traveled
	 * */
	private double w = 800;
	/***
	 * Hold an arraylist of all the End classes
	 */
	private ArrayList<End> inter = new ArrayList<End>();
	/***
	 * The waterArea class with hold the water areas of the game.
	 * */
	private waterArea waterDeathArea;

	/***
	 * @param imageLink set the start image of the Animal
	 * @param waterDeathArea waterArea class which will check if your in water
	 * @param SpawnPositionX spawn X position of the Animal
	 * @param SpawnPositionY spawn Y position of the Animal
	 * @param Border takes in coordinateArea class, the border of the map that the Animal cannot go pass
	 */
	public Animal(String imageLink, waterArea waterDeathArea,double SpawnPositionX, double SpawnPositionY, coordinateArea Border) {
		this.waterDeathArea = waterDeathArea;
		this.Border = Border;
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		this.SpawnPositionX = SpawnPositionX;
		setX(SpawnPositionX); //300
		this.SpawnPositionY = SpawnPositionY;
		setY(SpawnPositionY+movement); //679.8
		imgW1 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {
						move(0, -movement);
						if (isInWall()&& !GodMode){
							move(0, movement);
						}
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						if (isInWall()&& !GodMode){
							move(movementX, 0);
						}
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						if (isInWall()&& !GodMode){
							move(0, -movement);
						}
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						if (isInWall()&& !GodMode){
							move(0, -movement);
						}
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {
					move(0, -movement);
					if (isInWall()&& !GodMode){
						move(0, movement);
					}
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {
					move(-movementX, 0);
					if (isInWall()&& !GodMode){
						move(movementX, 0);
					}
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {
					move(0, movement);
					if (isInWall()&& !GodMode){
						move(0, -movement);
					}
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {
					move(movementX, 0);
					if (isInWall()&& !GodMode){
						move(-movementX, 0);
					}
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}

	/***
	 * This will check the position of the animal and act accordingly. For example card death in border and so on
	 * @param now The timestamp of the current frame given in nanoseconds. This value will be the same for all AnimationTimers called during one frame.
	 */
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY() < Border.getY1()) {
			move(0, movement * 2);
			//setX(SpawnPositionX);
			//setY(SpawnPositionY + movement);
		}
		if ( getY() > Border.getY2()){
			move(0, -movement * 2);
		}
		if (getX() < Border.getX1()) {
			move(movement * 2, 0);
		}
		if (carDeath && !GodMode) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setX(SpawnPositionX);
				setY(SpawnPositionY + movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points > 50) {
					points -= 50;
					changeScore = true;
				}
			}

		}
		if (waterDeath&& !GodMode) {
			noMove = true;
			if ((now) % 11 == 0) {
				carD++;
			}
			if (carD == 1) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/waterdeath1.png", imgSize, imgSize, true, true));
			}
			if (carD == 2) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/waterdeath2.png", imgSize, imgSize, true, true));
			}
			if (carD == 3) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/waterdeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/waterdeath4.png", imgSize, imgSize, true, true));
			}
			if (carD == 5) {
				setX(SpawnPositionX);
				setY(SpawnPositionY+ movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/Assets/FrogImagePosition/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				if (points > 50) {
					points -= 50;
					changeScore = true;
				}
			}

		}

		if (getX() > Border.getX2()) {
			move(-movement * 2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
			/*if (getX() == 240 && getY() == 82) {
				stop = true;
			}*/
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if (getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2, 0);
			else
				move(.75, 0);
		} else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points -= 50;
			}
			points += 50;
			changeScore = true;
			w = 800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(SpawnPositionX);
			setY(SpawnPositionY + movement);
		} else if (waterDeathArea.checkCoordinate(getX(), getY())) {
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
		else if (getIntersectingObjects(PushingWall.class).size()>=1 && !noMove && !GodMode){
			move(1*(getIntersectingObjects(PushingWall.class).get(0).getSpeed()), 0);
			if (getX()<0 || getX()>600){
				carDeath = true;
			}
		}
	}

	/***
	 * Check if all is done
	 * @return return true if all of the end goal is done else false
	 */
	public boolean getStop() {
		return end==5;
	}

	/***
	 * To get current points
	 * @return current points in int
	 */
	public int getPoints() {
		return points;
	}

	/***
	 * Will detect if the score changed
	 * @return true if the score did not change
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	/***
	 *
	 * @return true if the animal is dectected touching a wall or in wall else false
	 */
	public boolean isInWall(){
		if (getIntersectingObjects(wall.class).size() >= 1){
			 return true;
		}
		if (getIntersectingObjects(PushingWall.class).size()>=1){
			return true;
		}
		return false;
	}

}
