
package MyApp;

import java.util.Timer;
import java.util.TimerTask;

import controller.KeyInputController;
import controller.SceneController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {
	
	public static String screen1ID = "home";
	public static String screen1File = "/view/Home.fxml";
	public static String screen2ID = "car";
	public static String screen2File = "/view/Car.fxml";
	public static String screen3ID = "cave";
	public static String screen3File = "/view/cave.fxml";
	public static String screen4ID = "jump";
	public static String screen4File = "/view/jump.fxml";
	
    @Override
    public void start(Stage stage) throws Exception {
    	
    	SceneController mainController = new SceneController();
    	mainController.loadScene(Main.screen1ID, Main.screen1File);
    	mainController.loadScene(Main.screen2ID, Main.screen2File);
    	mainController.loadScene(Main.screen3ID, Main.screen3File);
    	mainController.loadScene(Main.screen4ID, Main.screen4File);
    	
    	mainController.setScene(Main.screen1ID);
    	
    	Group root = new Group();
    	root.getChildren().addAll(mainController);
    	Scene scene = new Scene(root, 850, 425);
    	
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
    		
    		KeyInputController inputKey = new KeyInputController();
			@Override
			public void handle(KeyEvent event) {
				
				String code = event.getCode().toString();
				if (code != null) {
					inputKey.addKey(code);
				}
				
			}
		});
    	
    	scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
    		
    		KeyInputController inputKey = new KeyInputController();
			@Override
			public void handle(KeyEvent event) {
				
				String code = event.getCode().toString();
				if (code != null) {
					inputKey.removeKey(code);
				}
				
			}
		});
    	stage.setResizable(false);
    	stage.setScene(scene);
    	stage.show();
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}
