package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ArenaController {
	
	@FXML
	private Button btnArenaDone;
	
	@FXML
	private Button templeRunLoad;
	
	public void loadNewArenia() {
		
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/view/Car.fxml"));
			stage.setScene(new Scene(root));
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onDone() {
		Platform.exit();
	}
	
}
