package controller;

import java.io.IOException;
import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SceneController extends StackPane{
	
	//holds the screens to be displayed
	//StackPane as a structure
	//String = id of the particular scene and,
	//Node = represent root of the scene graph of the particular scene
	private HashMap<String, Node> screens = new HashMap<>();

	public SceneController() {
		super();
	}
	
	//add the scene to the collection which is adding in hashmap
	public void addScene(String name, Node scene) {
		screens.put(name, scene);
	}
	
	//return the Node with the appropriate name
	public Node getScene(String name) {
		return screens.get(name);
	}
	
	//load the fxml file, add the scene to the screens collection and
	//finally injects the screenPane to the controller
	//resources = FXML files
	//each scene load the fxml file and associate id
	public boolean loadScene(String name, String resources) {
		
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resources));
			Parent loadScreen = (Parent) myLoader.load();
			ControlledScene mySceneController = ((ControlledScene) myLoader.getController());
			mySceneController.setSceneParent(this);
			addScene(name, loadScreen); //added to HashMap 
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		} 
	}

	//this method tries to display the scene with a predefined name
	//first it makes sure the scene has been already loaded. then if there is more than
	//one scene the new scene is been added scene, and then current scene is removed
	//if there isn't any scene being displayed, the new scene is added to the root
	public boolean setScene(final String name) {
		if (screens.get(name) != null) {
			final DoubleProperty opacity = opacityProperty();
			
			if (!getChildren().isEmpty()) { //if there is more than one scene
				Timeline fade = new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
						new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent event) {
								getChildren().remove(0)	;	//remove the display scene
								getChildren().add(0, screens.get(name));	//add the scene
								Timeline fadeIn = new Timeline(
										new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
										new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
						  		fadeIn.play();
							}
						}, new KeyValue(opacity, 0.0)));
						fade.play();
			}else {
				setOpacity(0.0);
				getChildren().add(screens.get(name)); //no one else been displayed, then just show
				Timeline fadeIn = new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
						new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
				fadeIn.play();
			}
			return true;
		}else{
			System.out.println("scene hasn't been loadded \n");
			return false;
		}
	}
	
	//this method will remove the scene with the given from the collection of screens
	public boolean unloadScene(String name) {
		if(screens.remove(name) == null) {
			System.out.println("Scene didn't exit");
			return false;
		}else {
			return true;
		}
	}
	
}
