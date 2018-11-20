package controller;

import java.io.IOException;

import MyApp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ArenaController implements ControlledScene{
	
	SceneController myController;
	
	@FXML
	private Button btnCar, btnPractise, btnArenaDone;
	

	@Override
	public void setSceneParent(SceneController sceneParent) {
		myController = sceneParent;
	}
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException, Exception{
		
		if(event.getSource() == btnCar) {
			myController.setScene(Main.screenId[1]);
		}else if(event.getSource() == btnPractise) {
			myController.setScene(Main.screenId[4]);
		}
		
	}
	
	public void onDone() {
		
	}

	@Override
	public void makeDecision(String output) {
		// TODO Auto-generated method stub
		
	}

}
