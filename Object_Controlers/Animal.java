package p4_group_8_repo.Object_Controlers;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Scenes_controlers.PushingWall;
import p4_group_8_repo.Scenes_controlers.coordinateArea;
import p4_group_8_repo.Scenes_controlers.wall;
import p4_group_8_repo.Scenes_controlers.waterArea;


public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int end = 0;
	private boolean canDieOne;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	private double SpawnPositionX;
	private double SpawnPositionY;
	private coordinateArea Border;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	waterArea waterDeathArea;
	public Animal(String imageLink, waterArea waterDeathArea,double SpawnPositionX, double SpawnPositionY, coordinateArea Border) {
		this.waterDeathArea = waterDeathArea;
		this.Border = Border;
		canDieOne = true;
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
		                changeScore = false;
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
				else if (event.getCode() == KeyCode.W) {
					move(0, -movement);
					if (isInWall()){
						move(0, movement);
					}
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {
					move(-movementX, 0);
					if (isInWall()){
						move(movementX, 0);
					}
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {
					move(0, movement);
					if (isInWall()){
						move(0, -movement);
					}
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {
					move(movementX, 0);
					if (isInWall()){
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
					if (isInWall()){
						move(0, movement);
					}
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
					if (isInWall()){
						move(movementX, 0);
					}
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
					if (isInWall()){
						move(0, -movement);
					}
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
					if (isInWall()){
						move(-movementX, 0);
					}
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}

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
		if (carDeath) {
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
		if (waterDeath) {
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
		else if (getIntersectingObjects(PushingWall.class).size()>=1 && !noMove){
			move(1*(getIntersectingObjects(PushingWall.class).get(0).getSpeed()), 0);
			if (getX()<0 || getX()>600){
				carDeath = true;
			}
		}
	}
	public boolean getStop() {
		return end==5;
	}

	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
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
