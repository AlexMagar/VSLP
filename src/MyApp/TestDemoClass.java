package MyApp;

import java.util.Date;

import org.codehaus.groovy.classgen.GeneratorContext;

import controller.DemoPracticeController;
import controller.KeyInputController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TestDemoClass extends Application{
	
	DemoPracticeController dmo;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(getClass().getResource("/view/Traning.fxml").openStream());
		dmo = (DemoPracticeController) loader.getController();
		Scene scene = new Scene(root);
		
	  	Date dt = new Date();
    	System.out.println("hello world:"+dt.toString());
    	System.out.println("hello world:"+dt.getTime());
    	System.out.println("hello world:"+dt.getYear());
    	System.out.println("hello world:"+dt.getDate());
    	System.out.println("hello world:"+dt.getDay());
    	System.out.println("hello world:"+dt.getMonth());
    	
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(colse->System.exit(0));
		
	}

	public static void main(String[] args) {
		launch(args);
	}


}

