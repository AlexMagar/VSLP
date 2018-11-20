
package controller;

import MyApp.Main;
import groovy.sql.OutParameter;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeController implements Initializable, ControlledScene {
	
	SceneController myController;

    private int BACKGROUND_WIDTH = 1200;
    private ParallelTransition parallelTransition;
    public TranslateTransition mountain1;
    
    @FXML
    private Pane rootPane;
    
    @FXML 
    private Button btnProfile, btnPause, btnResume, btnProfileDone, btnSetting, btnExit, btnCar, btnSettingDone, btnChangeName;
     
    @FXML
    private ImageView imgMountain1, imgMountain2, imgTower1, imgTower2, imgTower3, imgTower4, man;
    
    @FXML
    private Button btnPlay, btnChangeNameDone, btnArena, btnArenaDone;
    
    @FXML
    private TextField txtPlayerName;
    
    @FXML
    private Label lblStatus, lblScore;
    
    @FXML
    private ProgressBar progressBar;
    

	@Override
	public void setSceneParent(SceneController sceneParent) {
		
		myController = sceneParent;
		
	} 
	
	int tmt = (int)(new Date().getTime());
    
	@FXML
    private void handleButtonAction(ActionEvent event) throws IOException, Exception
    {  
		
		
		
       Stage stage;
       Parent root;
       if (event.getSource()==btnProfile)
       {
           stage = new Stage();
           root = FXMLLoader.load(getClass().getResource("/view/profile.fxml"));
           stage.setScene(new Scene(root));
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.initOwner(btnProfile.getScene().getWindow());
           stage.showAndWait();
           
           
       }
       else if (event.getSource()==btnProfileDone)
       {
    	   
           stage =(Stage) btnProfileDone.getScene().getWindow();
           stage.close();
       }
       else if (event.getSource()==btnSetting)
       {

           stage = new Stage();
           root = FXMLLoader.load(getClass().getResource("/view/setting.fxml"));
           stage.setScene(new Scene(root));
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.initOwner(btnSetting.getScene().getWindow());
           stage.showAndWait();
       }
       else if (event.getSource()==btnSettingDone)
       {
           stage = (Stage) btnSettingDone.getScene().getWindow();
           stage.close();
       }
       else if (event.getSource()==btnArena)
       {
           stage = new Stage();
           root = FXMLLoader.load(getClass().getResource("/view/arena.fxml"));
           stage.setScene(new Scene(root));
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.initOwner(btnSetting.getScene().getWindow());
           stage.showAndWait();
       }
//       else if (event.getSource()==btnArenaDone)
//       {
//           stage = (Stage)btnArenaDone.getScene().getWindow();
//           stage.close();
//       }
//       
//              
//       else if(event.getSource()==btnCar){
////           stage = (Stage)btnCar.getScene().getWindow();
////           stage.close();
////           stage = new Stage();
////           root = FXMLLoader.load(getClass().getResource("/view/Car.fxml"));
////           stage.setScene(new Scene(root));
////           stage.initModality(Modality.APPLICATION_MODAL);
////           stage.initOwner(btnCar.getScene().getWindow());
////           stage.showAndWait();
////           
//           myController.setScene(Main.screenId[1]);
//       }
       
       else if (event.getSource()==btnChangeName)
       {
       stage = new Stage();
       root = FXMLLoader.load(getClass().getResource("/view/changeName.fxml"));
       stage.setScene(new Scene(root));
       stage.initModality(Modality.APPLICATION_MODAL);
       stage.initOwner(btnChangeName.getScene().getWindow());
       stage.showAndWait();
       }
       else if (event.getSource()==btnPlay)
       {   
            btnExit.setVisible(true);
            btnProfile.setDisable(true);
            btnPlay.setVisible(false);
            btnArena.setVisible(false);
            btnSetting.setVisible(false);
            btnPause.setVisible(true);  
            
//            Date date = new Date();
//            date.setSeconds(10);
//            lblScore.setText("Score:"+date.getSeconds());
                                    
            progressBar.setFocusTraversable(true);
            
            mountain1 = new TranslateTransition(Duration.millis(10000),imgMountain1);
			mountain1.setToX(-1*BACKGROUND_WIDTH);
                       mountain1.setFromX(0);
			mountain1.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition mountain2 = new TranslateTransition(Duration.millis(10000),imgMountain2);
			mountain2.setToX(-1*BACKGROUND_WIDTH);
                       mountain2.setFromX(0);
			mountain2.setInterpolator(Interpolator.LINEAR);
			
			
			TranslateTransition tower1 = new TranslateTransition(Duration.millis(10000),imgTower1);
			tower1.setToX(-2*BACKGROUND_WIDTH);
                       tower1.setFromX(0);
			tower1.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition tower2 = new TranslateTransition(Duration.millis(10000),imgTower2);
			tower2.setToX(-2*BACKGROUND_WIDTH);
                       tower2.setFromX(0);
			tower2.setInterpolator(Interpolator.LINEAR);
                       
                       TranslateTransition tower3 = new TranslateTransition(Duration.millis(10000),imgTower3);
			tower3.setToX(-2*BACKGROUND_WIDTH);
                       tower3.setFromX(0);
			tower3.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition tower4 = new TranslateTransition(Duration.millis(10000),imgTower4);
			tower4.setToX(-2*BACKGROUND_WIDTH);
                       tower4.setFromX(0);
			tower4.setInterpolator(Interpolator.LINEAR);
			
			parallelTransition = new ParallelTransition(mountain1,mountain2,tower1,tower2,tower3,tower4);
			parallelTransition.setCycleCount(Animation.INDEFINITE);
            parallelTransition.setInterpolator(Interpolator.LINEAR);
            
        	rootPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

    			@Override
    			public void handle(KeyEvent event) {
    				if(event.getCode() == KeyCode.A) {
    					man.setLayoutY(man.getLayoutY() - 50);
    				}
    			}
    		});
        	
        	rootPane.setOnKeyReleased(new EventHandler<KeyEvent>() {

    			@Override
    			public void handle(KeyEvent event) {
    				if (event.getCode() == KeyCode.A) {
    					man.setLayoutY(228);
    				}
    			}
    		});
                  
			parallelTransition.play();
			
		
       }
       else if(event.getSource()==btnPause){
           if (parallelTransition.getStatus()==Animation.Status.RUNNING){
            parallelTransition.pause();
            btnPause.setVisible(true);
            btnPause.setText("Resume");
           }
           else if (parallelTransition.getStatus()==Animation.Status.PAUSED){
            parallelTransition.play();
            btnPause.setVisible(true);
            btnPause.setText("Pause");
           }
           
       }

      else if(event.getSource()==btnExit){
//           main = new Main();
//           stage = new Stage();
//           main.start(stage);
 //   	  Platform.exit();
    	  
    	  myController.setScene(Main.screenId[1]);
    	  
       }else {
    	   stage = (Stage) btnChangeNameDone.getScene().getWindow();
           stage.close();
           }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	System.out.println(tmt - 1);
    	
//    	rootPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				if(event.getCode() == KeyCode.A) {
//					man.setLayoutY(man.getLayoutY() - 50);
//				}
//			}
//		});
//    	
//    	rootPane.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent event) {
//				if (event.getCode() == KeyCode.A) {
//					man.setLayoutY(228);
//				}
//			}
//		});
    	
    }

	@Override
	public void makeDecision(String output) {
		output = output.trim();
		if (output.contains(output)) {
			
			System.out.println("form the homeController:"+output);			
		}
	}

}
