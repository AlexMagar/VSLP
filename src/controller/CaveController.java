package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class CaveController implements Initializable, ControlledScene{
	
	SceneController myController;
	
	@FXML
	private Pane cavePane;

	@FXML
    private ImageView imgCBackground1;
	
	@FXML
    private ImageView imgCBackground2;
	
	@FXML
    private ImageView imgcrystal1;
	
	@FXML
    private ImageView imgcrystal2;
	
	@FXML
    private ImageView imgcrystal3;
	
	@FXML
    private ImageView imgcrystal4;
	
	@FXML
    private ImageView imgcrystal5;
	
	@FXML
    private ImageView imgcrystal6;
	
	@FXML
    private ImageView imgcrystal7;
	
	@FXML
    private ImageView imgcrystal8;
	
	@FXML
    private ImageView imgcrystal9;
	
	@FXML
    private ImageView imgcrystal11;
	
	@FXML
    private ImageView imgcrystal12;
	
	@FXML
    private ImageView imgcrystal13;
	
	@FXML
    private ImageView imgcrystal14;
	
	@FXML
    private ImageView imgcrystal15;
	
	@FXML
    private ImageView imgcrystal16;
	
	@FXML
    private ImageView imgcrystal17;
	
	@FXML
    private ImageView imgcrystal18;
	
	@FXML
    private ImageView imgcrystal19;
	
	@FXML
    private ImageView imgBat;
	
    @FXML
    private Button btnStart;
    
    @FXML
    private Pane CavePane;
	
	private ParallelTransition parallelTransition;
	
    
    @Override
	public void setSceneParent(SceneController sceneParent) {
		
		myController = sceneParent;
		
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, Exception
    {  
       if (event.getSource()==btnStart)
       {
    	   btnStart.setVisible(false);
    	   
    	       	   
    	   TranslateTransition cavebg1 = new TranslateTransition(Duration.millis(10000),imgCBackground1);
    	   cavebg1.setToX(-1*2200);
    	   cavebg1.setFromX(0);
    	   cavebg1.setInterpolator(Interpolator.LINEAR);
    	   
    	   TranslateTransition cavebg2 = new TranslateTransition(Duration.millis(10000),imgCBackground2);
    	   cavebg2.setToX(-1*2200);
    	   cavebg2.setFromX(0);
    	   cavebg2.setInterpolator(Interpolator.LINEAR);
			
    	   TranslateTransition crystal1 = new TranslateTransition(Duration.millis(10000), imgcrystal1);
		    crystal1.setToX(-1*2200);
			crystal1.setFromX(0);
			crystal1.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal2 = new TranslateTransition(Duration.millis(10000), imgcrystal2);
			crystal2.setToX(-1*2200);
			crystal2.setFromX(0);
			crystal2.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal3 = new TranslateTransition(Duration.millis(10000), imgcrystal3);
			crystal3.setToX(-1*2200);
			crystal3.setFromX(0);
			crystal3.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal4 = new TranslateTransition(Duration.millis(10000), imgcrystal4);
			crystal4.setToX(-1*2200);
			crystal4.setFromX(0);
			crystal4.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal5 = new TranslateTransition(Duration.millis(10000), imgcrystal5);
			crystal5.setToX(-1*2200);
			crystal5.setFromX(0);
			crystal5.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal6 = new TranslateTransition(Duration.millis(10000), imgcrystal6);
			crystal6.setToX(-1*2200);
			crystal6.setFromX(0);
			crystal6.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal7 = new TranslateTransition(Duration.millis(10000), imgcrystal7);
			crystal7.setToX(-1*2200);
			crystal7.setFromX(0);
			crystal7.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal8 = new TranslateTransition(Duration.millis(10000), imgcrystal8);
			crystal8.setToX(-1*2200);
			crystal8.setFromX(0);
			crystal8.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal9 = new TranslateTransition(Duration.millis(10000), imgcrystal9);
			crystal9.setToX(-1*2200);
			crystal9.setFromX(0);
			crystal9.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal11 = new TranslateTransition(Duration.millis(10000), imgcrystal11);
			crystal11.setToX(-1*2200);
			crystal11.setFromX(0);
			crystal11.setInterpolator(Interpolator.LINEAR);	
			
			TranslateTransition crystal12 = new TranslateTransition(Duration.millis(10000), imgcrystal12);
			crystal12.setToX(-1*2200);
			crystal12.setFromX(0);
			crystal12.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal13 = new TranslateTransition(Duration.millis(10000), imgcrystal13);
			crystal13.setToX(-1*2200);
			crystal13.setFromX(0);
			crystal13.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal14 = new TranslateTransition(Duration.millis(10000), imgcrystal14);
			crystal14.setToX(-1*2200);
			crystal14.setFromX(0);
			crystal14.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal15 = new TranslateTransition(Duration.millis(10000), imgcrystal15);
			crystal15.setToX(-1*2200);
			crystal15.setFromX(0);
			crystal15.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal16 = new TranslateTransition(Duration.millis(10000), imgcrystal16);
			crystal16.setToX(-1*2200);
			crystal16.setFromX(0);
			crystal16.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal17 = new TranslateTransition(Duration.millis(10000), imgcrystal17);
			crystal17.setToX(-1*2200);
			crystal17.setFromX(0);
			crystal17.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal18 = new TranslateTransition(Duration.millis(10000), imgcrystal18);
			crystal18.setToX(-1*2200);
			crystal18.setFromX(0);
			crystal18.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition crystal19 = new TranslateTransition(Duration.millis(10000), imgcrystal19);
			crystal19.setToX(-1*2200);
			crystal19.setFromX(0);
			crystal19.setInterpolator(Interpolator.LINEAR);
			
			
			parallelTransition = new ParallelTransition(cavebg1,cavebg2,crystal1,crystal2,crystal3,crystal4,crystal5,crystal6,crystal7,crystal8,crystal9,crystal11,crystal12,crystal13,crystal14,crystal15,crystal16,crystal17,crystal18,crystal19);
			parallelTransition.setCycleCount(Animation.INDEFINITE);
            parallelTransition.setInterpolator(Interpolator.LINEAR);
            
    		cavePane.setOnKeyPressed(new EventHandler<KeyEvent>() {

    			@Override
    			public void handle(KeyEvent event) {
    				System.out.println("hello1");
    				if(event.getCode() == KeyCode.A) {
        				System.out.println("hello2");
    					imgBat.setLayoutY(imgBat.getLayoutY()-1.9);
    				}else if (event.getCode() == KeyCode.W) {
        				System.out.println("hello3");
    					imgBat.setLayoutY(imgBat.getLayoutY()+1.9);
    				}else {

        				System.out.println("hello4");
    				}
    			}
    		   });
    		   
            
			parallelTransition.play();
       }
         
    }

	@Override
	public void makeDecision(String output) {
		// TODO Auto-generated method stub
		
	}  


}
