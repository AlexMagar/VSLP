package controller;


import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SpaceInvadorController extends Rectangle{
	
	boolean dead = false;
	final String type;
	
	@FXML
	private Rectangle shoter;
	
	SpaceInvadorController(int x, int y, int w, int h, String type, Color color) {
		super(w, h, color); 
		this.type = type;
		setTranslateX(x);
		setTranslateY(y);
	}
	
	void moveLeft() {
		setTranslateX(getTranslateX() - 5 );
	}
	
	void moveRight() {
		setTranslateX(getTranslateX() + 5);
	}
	
	void moveUp() {
		setTranslateY(getTranslateX() - 5);
	}
	
	void moveDown() {
		setTranslateY(getTranslateY() + 5);
	}

}
