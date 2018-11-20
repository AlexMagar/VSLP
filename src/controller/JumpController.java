package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import MyApp.Main;
import javafx.animation.ParallelTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import marytts.TextToSpeech;

public class JumpController implements Initializable, ControlledScene{
	
	static int BACKGROUND_WIDTH = 1200;
    SceneController myController;
    private static double init_man_X=60, init_man_Y=226;
    
    TextToSpeech tts = new TextToSpeech();
    
    Image[] manRunning;
    Image[] manStopped;
    Image manCollide;
 	
    @FXML
    private ImageView man1;
    
    @FXML
    private Pane jump_pane;
    
	@FXML
	private Button goHome;
	
	
	@Override
	public void setSceneParent(SceneController sceneParent) {
		
		myController = sceneParent;
		
	}	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		jump_pane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				if(event.getCode() == KeyCode.A) {
					man1.setLayoutY(man1.getLayoutY()-150);
				}
			}
		});
				
		jump_pane.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.A) {
					man1.setLayoutY(init_man_Y);
				}
				
			}
		});
		Timer timer = new Timer();
		JumpController app = this;
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				app.update();				
			}
		}, 20, 20);
		
	}
	

	
	@FXML
	public void goToHome(ActionEvent event) {
		myController.setScene(Main.screenId[3]);
	}
	
	public void update() {
		
	}


	@Override
	public void makeDecision(String output) {
		// TODO Auto-generated method stub
		
	}


	
	
//	@FXML
//	private void playScene(ActionEvent event) {
//		
//		play.setVisible(false);
//		
//		//for upper background image
//		TranslateTransition skyBG1 = new TranslateTransition(Duration.millis(7000),sky1);
//		skyBG1.setToX(-1*BACKGROUND_WIDTH);
//		skyBG1.setInterpolator(Interpolator.LINEAR);
//		
//
//		TranslateTransition skyBG2 = new TranslateTransition(Duration.millis(7000),sky2);
//		skyBG2.setToX(-1*BACKGROUND_WIDTH);
//		skyBG2.setInterpolator(Interpolator.LINEAR);
//		
//		parallelTrans = new ParallelTransition(skyBG1, skyBG2);
//		parallelTrans.setCycleCount(Animation.INDEFINITE);
//		parallelTrans.play();
//		
//		//for lower background image
//		TranslateTransition ground_BG1 = new TranslateTransition(Duration.millis(7000),ground1);
//		ground_BG1.setToX(-1*BACKGROUND_WIDTH);
//		ground_BG1.setInterpolator(Interpolator.LINEAR);
//		
//
//		TranslateTransition ground_BG2 = new TranslateTransition(Duration.millis(7000),ground2);
//		ground_BG2.setToX(-1*BACKGROUND_WIDTH);
//		ground_BG2.setInterpolator(Interpolator.LINEAR);
//		
//		parallelTrans = new ParallelTransition(ground_BG1, ground_BG2);
//		parallelTrans.setCycleCount(Animation.INDEFINITE);
//		parallelTrans.play();
//		
//		//for obstacle
//		TranslateTransition tunnel = new TranslateTransition(Duration.millis(4000),tunnel_obs);
//		tunnel.setToX(-1*BACKGROUND_WIDTH);
//		tunnel.setInterpolator(Interpolator.LINEAR);
//		
//		parallelTrans = new ParallelTransition(tunnel_obs);
//		parallelTrans.setCycleCount(Animation.INDEFINITE);
//		parallelTrans.play();
//		
//	}
//	
//	@FXML
//	public void moveObstracle() {
//		//layoutX="485.0" layoutY="268.0"
//		translateTran.setDuration(Duration.INDEFINITE);
//		translateTran.setNode(man_jump);
//		
//		translateTran.setToY(-100);
//		translateTran.setCycleCount(2);
//		translateTran.play();
//		
//	}
//
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		
//
//		man_jump.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				switch(event.getCode()) {
//				case A: System.out.println("hello there"); break;
//				case SPACE: System.out.println("hello matra"); break;
//				default: System.out.println("out of here bro"); break;
//				}
//			}
//		});
//		
//		//for upper background image
//				TranslateTransition skyBG1 = new TranslateTransition(Duration.millis(7000),sky1);
//				skyBG1.setToX(-1*BACKGROUND_WIDTH);
//				skyBG1.setInterpolator(Interpolator.LINEAR);
//				
//
//				TranslateTransition skyBG2 = new TranslateTransition(Duration.millis(7000),sky2);
//				skyBG2.setToX(-1*BACKGROUND_WIDTH);
//				skyBG2.setInterpolator(Interpolator.LINEAR);
//				
//				parallelTrans = new ParallelTransition(skyBG1, skyBG2);
//				parallelTrans.setCycleCount(Animation.INDEFINITE);
//				parallelTrans.play();
//				
//				//for lower background image
//				TranslateTransition ground_BG1 = new TranslateTransition(Duration.millis(5000),ground1);
//				ground_BG1.setToX(-1*BACKGROUND_WIDTH);
//				ground_BG1.setInterpolator(Interpolator.LINEAR);
//				
//
//				TranslateTransition ground_BG2 = new TranslateTransition(Duration.millis(5000),ground2);
//				ground_BG2.setToX(-1*BACKGROUND_WIDTH);
//				ground_BG2.setInterpolator(Interpolator.LINEAR);
//				
//				parallelTrans = new ParallelTransition(ground_BG1, ground_BG2);
//				parallelTrans.setCycleCount(Animation.INDEFINITE);
//				parallelTrans.play();
//				
//				//for obstacle
//				TranslateTransition tunnel = new TranslateTransition(Duration.millis(5000),tunnel_obs);
//				tunnel.setToX(-BACKGROUND_WIDTH);
//				tunnel.setAutoReverse(false); //bring image in same path background
//				tunnel.setCycleCount(TranslateTransition.INDEFINITE);
//				tunnel.play();
//				
//	}


	
//	@Override
//	public void handle(KeyEvent event){
//		
//		switch(event.getCode()) {
//		case A: System.out.println("hello world"); break;
//		default: System.out.println("out of the loop"); break;
//		}
		
		
//			for man
//			TranslateTransition man = new TranslateTransition(Duration.millis(5000),man_jump);			
//			man.setToY(-100);
//			man.setAutoReverse(true);
//			man.setCycleCount(TranslateTransition.INDEFINITE);
//			man.play();
//			
		
		
//		int carLeftPos = 187, carRightPos = 338; 
//		switch (event.getCode()) {
//		case A:	car.setLayoutX(carLeftPos); break;
//		case D:	car.setLayoutX(carRightPos); break;
//		default: System.out.println("press Valid Key"); break;
//		}
//			
//		
//	}
//	
	
}
