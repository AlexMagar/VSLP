package controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import MyApp.Main;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class CarController implements Initializable, ControlledScene, EventHandler<KeyEvent> {
	
	SceneController myController;
	
	@FXML
	private Pane car_Pane;
	        
	@FXML 
	private ImageView imgSky;
	
	@FXML
	private ImageView imgCloud1;
	
	@FXML
	private ImageView imgCloud2;
	
	@FXML 
	private ImageView imgCloud3;
	
	@FXML
	private ImageView imgCloud11;
	
	@FXML
	private ImageView imgCloud21;
	
	@FXML 
	private ImageView imgCloud31;
	
	@FXML
	private ImageView imgRBuilding;
	
	@FXML
	private ImageView imgLBuilding;
	
	@FXML
	private ImageView imgCar;
	
	@FXML
	private ImageView imgRoad;
	
	@FXML
	private ImageView imgTree1;
	
	@FXML
	private ImageView imgTree2;
	
	@FXML 
	private ImageView imgTree3;
	
	@FXML
	private ImageView obstracle;
	
	@FXML
	private Button btnPlay;
	
	@FXML
	private Button goNext;
	
	@FXML
	private Button btnPause;
	
	private final static int MAX_Y = 350, MIN_Y = 140, MIN_X = 300, MAX_X =500;
	private final static int SMALL_START_SIZE = 80;
	boolean collisionDetect = false;
	
//	@FXML
//	private void buttonAction(ActionEvent e) throws IOException,Exception{
//	    
//		
//	    if (e.getSource()== btnPlay){
//	        
//	        btnPlay.setVisible(false);
//	//        imgCloud1.setLayoutX(setRandLayoutX());
//	//        imgCloud2.setLayoutX(setRandLayoutX());
//	//        imgCloud3.setLayoutX(setRandLayoutX());
//	        
//	        TranslateTransition cloud1 = new TranslateTransition(Duration.millis(10000),imgCloud1);
//	        cloud1.setFromY(0);
//	        cloud1.setFromX(setRandLayoutX());
//	        cloud1.setToY(-500);
//	        
//	        TranslateTransition cloud2 = new TranslateTransition(Duration.millis(10000),imgCloud2);
//	        cloud2.setFromY(0);
//	        cloud2.setFromX(setRandLayoutX());
//	        cloud2.setToY(-500);
//	        
//	        TranslateTransition cloud3 = new TranslateTransition(Duration.millis(10000),imgCloud3);
//	        cloud3.setFromY(0);
//	        cloud3.setFromX(setRandLayoutX());
//	        cloud3.setToY(-500);
//	        
//	        ScaleTransition scaleTransition1 = new ScaleTransition(Duration.seconds(10),imgCloud1);
//	        scaleTransition1.setToX(1.5);
//	        scaleTransition1.setToY(2.2);
//	        
//	        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.seconds(10),imgCloud2);
//	        scaleTransition2.setToX(1.5);
//	        scaleTransition2.setToY(2.2);
//	        
//	        ScaleTransition scaleTransition3 = new ScaleTransition(Duration.seconds(10),imgCloud3);
//	        scaleTransition3.setToX(1.5);
//	        scaleTransition3.setToY(2.2);
//	      
//	        ParallelTransition pt = new ParallelTransition(cloud1,cloud2,cloud3,scaleTransition1,scaleTransition2,scaleTransition3);
//	        pt.setCycleCount(Animation.INDEFINITE);
//	        pt.setInterpolator(Interpolator.LINEAR);
//	        pt.play();
//	        
//	    }
//	}
//	
	
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        TranslateTransition cloud1 = new TranslateTransition(Duration.millis(15000),imgCloud1);
	        cloud1.setFromY(0);
	        cloud1.setFromX(setRandLayoutX());
	        cloud1.setToY(-500);
	        
	        TranslateTransition cloud2 = new TranslateTransition(Duration.millis(15000),imgCloud2);
	        cloud2.setFromY(0);
	        cloud2.setFromX(setRandLayoutX());
	        cloud2.setDelay(Duration.millis(1500));
	        cloud2.setToY(-500);
	        
	        TranslateTransition cloud3 = new TranslateTransition(Duration.millis(15000),imgCloud3);
	        cloud3.setFromY(0);
	        cloud3.setFromX(setRandLayoutX());
	        cloud3.setDelay(Duration.millis(2500));
	        cloud3.setToY(-500);
	        
	        ScaleTransition scaleTransition1 = new ScaleTransition(Duration.seconds(5),imgCloud1);
	        scaleTransition1.setToX(1.5);
	        scaleTransition1.setToY(2.2);
	        
	        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.seconds(5),imgCloud2);
	        scaleTransition2.setToX(1.5);
	        cloud2.setDelay(Duration.millis(1500));
	        scaleTransition2.setToY(2.2);
	        
	        ScaleTransition scaleTransition3 = new ScaleTransition(Duration.seconds(5),imgCloud3);
	        scaleTransition3.setToX(1.5);
	        cloud3.setDelay(Duration.millis(2500));
	        scaleTransition3.setToY(2.2);
	      
	        ParallelTransition pt = new ParallelTransition(cloud1,cloud2,cloud3,scaleTransition1,scaleTransition2,scaleTransition3);
	        pt.setCycleCount(Animation.INDEFINITE);
	        pt.setInterpolator(Interpolator.LINEAR);
	        pt.play();
	        
	        car_Pane.setOnKeyPressed(this);
	        
	        Timer timer = new Timer();
	        CarController app = this;
	        timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					
					app.update();
					
				}
			}, 20, 20);
	        
	        
	    }  
	    
	    public void moveStone() {
	    	
	    	int xdiff = MAX_X - MIN_X;
	    	int newX = (int)Math.floor(Math.random() * xdiff) + MIN_X;
	    	
	    	double currentY = obstracle.getLayoutY();
	    	if(currentY < MAX_Y) {
	    		currentY = currentY + 0.9;
	    		obstracle.setLayoutY(currentY);
	    		obstracle.setFitHeight(SMALL_START_SIZE * (currentY * 0.01));
	    		obstracle.setFitWidth(SMALL_START_SIZE * (currentY * 0.01));
	    		obstracle.setLayoutX(obstracle.getLayoutX() - 1.5);
	    	}else {
	    		obstracle.setLayoutX(newX);
	    		obstracle.setLayoutY(MIN_Y);
	    		obstracle.setFitHeight(SMALL_START_SIZE);
	    		obstracle.setFitWidth(SMALL_START_SIZE);
	    		
	    	}
	    	
	    }
	    
	    public void detectCollide() {
	    	
	    	if(obstracle.getBoundsInParent().intersects(imgCar.getLayoutX() + 10, imgCar.getLayoutY() + 10, imgCar.getFitWidth() -10, imgCar.getFitWidth()-10)) {
	    		System.out.println("accident occur");
	    	}
	    }
	    
	    
	    protected void update() {
			moveStone();
			detectCollide();
	    	
		}

		public int setRandLayoutX(){
	        Random r = new Random();
			int x = r.nextInt(500)+1;
	    //    System.out.println("controller.CarController.setRandLayoutX()"+x);
	        return x;
	    }
	
	
		@Override
		public void setSceneParent(SceneController sceneParent) {
			
			myController = sceneParent;
			
		}
		
		@FXML
		public void goNextStage(ActionEvent event) {
			myController.setScene(Main.screen3ID);
		}

		@Override
		public void handle(KeyEvent event) {
			int carLeftPos = 187, carRightPos = 338;  
			switch (event.getCode()) {
			case A:	imgCar.setLayoutX(imgCar.getLayoutX() - 50); break;
			case D:	imgCar.setLayoutX(imgCar.getLayoutX() + 50); break;
			default: System.out.println("press Valid Key"); break;
			
			}
    
		}
}
