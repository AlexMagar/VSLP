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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class CarController implements Initializable, ControlledScene {
	
	SceneController myController;
	
	@FXML
	private Pane car_Pane;
	        
	@FXML 
	private ImageView imgSky,imgCloud1,imgCloud2,imgCloud3,imgRBuilding,imgLBuilding,imgCar,imgRoad;

	@FXML
	private ImageView imgTree1,imgTree2,imgTree3,imgCar1,imgCar2,imgCar3;

	@FXML
<<<<<<< HEAD
	private Button btnPlay,goNext,btnPause;

	private final static int MAX_Y = 350, MIN_Y = 140, MIN_X = 300, MAX_X =500;
=======
	private Button btnPause;
	
	private final static int MAX_Y = 350, MIN_Y = 140;
>>>>>>> 77a3d3f75cbcf552e29bf78a6fec51d1ff52374c
	private final static int SMALL_START_SIZE = 80;
	boolean collisionDetect = false;
	
	static int carInitialPos[] = {300, 400, 500};
	
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
	public void setSceneParent(SceneController sceneParent) {
		
		myController = sceneParent;
		
	}
	

	@Override
	public void makeDecision(String output) {
		
		
		
	}
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
	        
   
	//        car_Pane.setOnKeyPressed(this);
	        
	        Timer timer = new Timer();
	        CarController app = this;
	        timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					
					app.update();
					
				}
			}, 2000, 2000);
	        
	        
	    }  
	    
	    public void moveStone() {
	    	
<<<<<<< HEAD
	    	int xdiff = MAX_X - MIN_X;
	    	int newX = (int)Math.floor(Math.random() * xdiff) + MIN_X;
	    	
	    	double currentY = imgCar1.getLayoutY();
	    	if(currentY < MAX_Y) {
	    		currentY = currentY + 0.9;
	    		imgCar1.setLayoutY(currentY);
	    		imgCar1.setFitHeight(SMALL_START_SIZE * (currentY * 0.01));
	    		imgCar1.setFitWidth(SMALL_START_SIZE * (currentY * 0.01));
	    		imgCar1.setLayoutX(imgCar1.getLayoutX() - 1.5);
	    	}else {
	    		imgCar1.setLayoutX(newX);
	    		imgCar1.setLayoutY(MIN_Y);
	    		imgCar1.setFitHeight(SMALL_START_SIZE);
	    		imgCar1.setFitWidth(SMALL_START_SIZE);
	    		
=======
	    	double currentY = 140;

	    	if(currentY < MAX_Y) {
	    		currentY = currentY + 0.7;
	    		obstracle.setLayoutY(currentY);
	    		obstracle.setLayoutX(setRandLayoutX());
	    	//	System.out.println(setRandLayoutX());
	    	//	obstracle.setFitHeight(SMALL_START_SIZE * (currentY * 0.009));
	    	//	obstracle.setFitWidth(SMALL_START_SIZE * (currentY * 0.009));
	    		obstracle.setLayoutX(obstracle.getLayoutX() - 1.5);

	    	}else {
	    		obstracle.setLayoutY(MIN_Y);
	    		obstracle.setFitHeight(SMALL_START_SIZE);
	    		obstracle.setFitWidth(SMALL_START_SIZE);    		
>>>>>>> 77a3d3f75cbcf552e29bf78a6fec51d1ff52374c
	    	}
	    	
	    }
	    
	    public void detectCollide() {
	    	
	    	if(imgCar1.getBoundsInParent().intersects(imgCar.getLayoutX() + 10, imgCar.getLayoutY() + 10, imgCar.getFitWidth() -10, imgCar.getFitWidth()-10)) {
	    		System.out.println("accident occur");
	    	}
	    }
	    
	    
	    protected void update() {
			moveStone();
			detectCollide();
	    	
		}

//		public int  setRandLayoutX(){
//			
//			int rand = new Random().nextInt(carInitialPos.length);
//			return carInitialPos[rand];
	    
		public int setRandLayoutX(){
	        Random r = new Random();
	        int low = 100;
	        int high = 300;
			int x = r.nextInt(high - low)+low;
	    //    System.out.println("controller.CarController.setRandLayoutX()"+x);
	        return x;
	    }
	
			
		@FXML
		public void goNextStage(ActionEvent event) {
			myController.setScene(Main.screenId[2]);
		}


		@Override
		public void detectCollision() {
			// TODO Auto-generated method stub
			
		}
		
}
