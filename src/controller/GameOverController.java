package controller;

import MyApp.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Window;

public class GameOverController implements ControlledScene {
	SceneController myControler;
	
	@FXML
	private Button exitGame;
	
	@FXML
	private Button goHome;

	@Override
	public void setSceneParent(SceneController sceneParent) {
		
		myControler = sceneParent;
	}
	
	public void goToHome() {
		myControler.setScene(Main.screenId[0]);
	}
	
	public void exitGame() {
		Platform.exit();
	}

	@Override
	public void makeDecision(String output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detectCollision() {
		// TODO Auto-generated method stub
		
	}
	
	

}
