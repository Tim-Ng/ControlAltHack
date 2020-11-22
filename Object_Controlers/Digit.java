package p4_group_8_repo.Object_Controlers;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/Assets/ScoreNumberImages/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	public Digit(int n, int dim, int x, int y,String which) {
		im1 = new Image("file:src/p4_group_8_repo/Assets/ScoreNumberImages/"+n+which+".png", dim, dim, true, true);
		setImage(im1);
		setFitHeight(55);
		setFitWidth(55);
		setX(x);
		setY(y);
	}
	
}
