package controller;

import java.net.URL;
import java.util.ResourceBundle;

import MyApp.SoundControl;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import marytts.TextToSpeech;

public class DemoPracticeController implements ControlledScene{

	TextToSpeech tts = new TextToSpeech();
	SoundControl sd;
	
	SceneController myController;
	
	@FXML
	private AnchorPane speechPane;
	
	@FXML
	private AnchorPane tranningPane;
	
	@FXML
	private Rectangle boxRec;
	
	@FXML
	private TextArea areaText;
	
	@FXML
	private Label label, label_one;
	
	@FXML
	private ButtonBar btnBar;
	
	@FXML
	private Button btn;
	
	@FXML
	public Rectangle box;
	Parent mRoot;
		
	@Override
	public void setSceneParent(SceneController sceneParent) {
		myController = sceneParent;
		
	}
	
	public void init(Parent root) {
		mRoot = root;
	}
	
//	public void makeDecision(final String output) {
//		
//			tts.setVoice("cmu-slt-hsmm");
//		
//	//	String A = output;
//		System.out.println(output);
//		Platform.runLater(new Runnable() {
//			
//			@Override
//			public void run() {
//				if(output.contains("hello")) {
////					box.setLayoutX(box.getLayoutX()+10);
//					label_one.setText(output);
//					box.setLayoutX(box.getLayoutX()+20);
//				//	tts.speak(output,2.0f,false,true);
//				}
//			}
//		});
//		
//	}
//	
//	
//	
//	
	public void showSth() {
		label.setText("hello there");
				
	}
//
//	public void showThis() {
//		
//		String A = sd.getOutput();
//		
//		Platform.runLater(new Runnable() {
//			
//			@Override
//			public void run() {
//			
//				if (A.contains("up")) {
//					box.setLayoutY(box.getLayoutY()-10);
//				}else if(A.contains("down")) {
//					box.setLayoutY(box.getLayoutY()+10);
//				}else if(A.contains("right")) {
//					box.setLayoutX(box.getLayoutX()+10);
//				}else if (A.contains("left")) {
//					box.setLayoutX(box.getLayoutX()-10);					
//				}							
//			}
//		});
//
//	}

//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		
	//	System.out.println("hello there");
//		
//		tranningPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
//			@Override
//			public void handle(KeyEvent event) {
//				switch(event.getCode()) {
//				case A: boxRec.setLayoutX(boxRec.getLayoutX() - 10); System.out.println("from inside"); break;
//				case W: boxRec.setLayoutY(boxRec.getLayoutY() - 10); break;
//				case D: boxRec.setLayoutX(boxRec.getLayoutX() + 10); break;
//				case S: boxRec.setLayoutY(boxRec.getLayoutY() + 10); break;
//				case Z: boxRec.setHeight(boxRec.getHeight()+20); boxRec.setWidth(boxRec.getWidth() + 20); break;
//				case O: boxRec.setHeight(boxRec.getHeight()-20); boxRec.setWidth(boxRec.getWidth() - 20); break;
//				default: System.out.println("no root");break;
//				
//				}
//			}
//		});
//	}

	@Override
	public void makeDecision(String output) {
		
		tts.setVoice("cmu-slt-hsmm");
		
	//	String A = output;
		System.out.println(output);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				if(output.contains("hello")) {
//					box.setLayoutX(box.getLayoutX()+10);
					label_one.setText(output);
					box.setLayoutX(box.getLayoutX()+20);
				//	tts.speak(output,2.0f,false,true);
				}
			}
		});
	}

	@Override
	public void detectCollision() {
		// TODO Auto-generated method stub
		
	}

}
