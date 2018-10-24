package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.management.timer.Timer;

import MyApp.Main;
import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class JumpController implements Initializable, ControlledScene{
	
	static int BACKGROUND_WIDTH = 1200;
	private ParallelTransition parallelTrans;
    SceneController myController;
    
    Image[] manRunning;
    Image[] manStopped;
    Image manCollide;
 	
	@FXML
	private Button goHome;
	
	@FXML
	public void goToHome(ActionEvent event) {
		myController.setScene(Main.screen4ID);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		manRunning = new Image[23];
		manStopped = new Image[19];
		manCollide = new Image("/image/character/collide.png");
		
		for(int i = 0; i < manRunning.length; i++) {
			if(i < manRunning.length) {
				manRunning[i] = new Image("image/character/d ("+(i+1)+").png");
			}else if (i < manStopped.length) {
				manStopped[i] = new Image("image/character/b ("+(i+1)+").png");
			}
		}
		
		final long startNanoTime = System.nanoTime();
		
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {

				System.out.println("hello world");
				
			}
		};
		
	}

	@Override
	public void setSceneParent(SceneController sceneParent) {
		
		myController = sceneParent;
		
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
