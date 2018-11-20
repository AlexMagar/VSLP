
package controller;

import MyApp.Main;
import groovy.sql.OutParameter;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
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
    private int man_inital_pos = 228;
    private ParallelTransition parallelTransition;
    public TranslateTransition mountain1;
    
    @FXML
    private Pane rootPane;
    
<<<<<<< HEAD
    @FXML 
    private Button btnProfile,btnPause,btnResume;
=======
    @FXML
    private Button btnProfile;
>>>>>>> 77a3d3f75cbcf552e29bf78a6fec51d1ff52374c
    
    @FXML
    private ImageView imgMountain1,imgMountain2,imgTower1,imgTower2,imgTower3,imgTower4;
	
    @FXML
    private ImageView imgpipe1,imgpipe2,imgbird,imgbush,man;
 
    @FXML 
    private Button btnProfileDone,btnSetting,btnExit,btnCar,btnSettingDone,btnChangeName,btnPlay;
  
    @FXML
<<<<<<< HEAD
    private Button btnChangeNameDone,btnArena,btnArenaDone;
=======
    private Button btnSetting;
    
    @FXML
    private Button btnExit;
    
    @FXML
    private Button btnCar;
    
    @FXML
    private Button btnSettingDone;
    
    @FXML
    private Button btnChangeName;
        
    @FXML
    private ImageView man;
    
    @FXML
    private Button btnPlay, btnChangeNameDone, btnArena, btnArenaDone;
>>>>>>> 77a3d3f75cbcf552e29bf78a6fec51d1ff52374c
    
    @FXML
    private TextField txtPlayerName;
    
    @FXML
<<<<<<< HEAD
    private Label lblStatus;

=======
    private Label lblStatus, lblScore;
    
>>>>>>> 77a3d3f75cbcf552e29bf78a6fec51d1ff52374c
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
            
            ProgressBar progressBar = new ProgressBar();
            Task task = taskCreator(10);
            progressBar.progressProperty().unbind();
            progressBar.progressProperty().bind(task.progressProperty());
            new Thread(task).start();
            
    	    mountain1 = new TranslateTransition(Duration.millis(20000),imgMountain1);
			mountain1.setToX(-1*BACKGROUND_WIDTH);
            mountain1.setFromX(0);
			mountain1.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition mountain2 = new TranslateTransition(Duration.millis(20000),imgMountain2);
			mountain2.setToX(-1*BACKGROUND_WIDTH);
            mountain2.setFromX(0);
			mountain2.setInterpolator(Interpolator.LINEAR);
			
			
			TranslateTransition tower1 = new TranslateTransition(Duration.millis(20000),imgTower1);
			tower1.setToX(-2*BACKGROUND_WIDTH);
            tower1.setFromX(0);
			tower1.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition tower2 = new TranslateTransition(Duration.millis(20000),imgTower2);
			tower2.setToX(-2*BACKGROUND_WIDTH);
            tower2.setFromX(0);
			tower2.setInterpolator(Interpolator.LINEAR);
                       
            TranslateTransition tower3 = new TranslateTransition(Duration.millis(20000),imgTower3);
			tower3.setToX(-2*BACKGROUND_WIDTH);
            tower3.setFromX(0);
			tower3.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition tower4 = new TranslateTransition(Duration.millis(20000),imgTower4);
			tower4.setToX(-2*BACKGROUND_WIDTH);
            tower4.setFromX(0);
			tower4.setInterpolator(Interpolator.LINEAR);
			
			TranslateTransition p11 = new TranslateTransition(Duration.millis(10000),imgpipe1);
			p11.setFromX(0);
			p11.setToX(-910);

			TranslateTransition p12 = new TranslateTransition(Duration.millis(10000),imgpipe2);
			p12.setFromX(0);
			p12.setToX(-910);
			p12.setDelay(Duration.millis(4000));
			
			TranslateTransition p13 = new TranslateTransition(Duration.millis(10000),imgbird);
			p13.setFromX(0);
			p13.setToX(-960);
			p13.setDelay(Duration.millis(7500));
			
			TranslateTransition p14 = new TranslateTransition(Duration.millis(10000),imgbush);
			p14.setFromX(0);
			p14.setToX(-960);
			p14.setDelay(Duration.millis(10000));
		
			ParallelTransition pipePT1 = new ParallelTransition(p11,p12,p13,p14);
//			ParallelTransition pipePT2 = new ParallelTransition(p12,p13,p11);
			//SequentialTransition sq = new SequentialTransition(pipePT1);
						
			
			parallelTransition = new ParallelTransition(mountain1,pipePT1,mountain2,tower1,tower2,tower3,tower4);
			parallelTransition.setCycleCount(Animation.INDEFINITE);
            parallelTransition.setInterpolator(Interpolator.LINEAR);

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
    
    private Task taskCreator(int seconds){
        return new Task() {

                   @Override
                   protected Object call() throws Exception {
                       for(int i=0; i<seconds;i++){
                        Thread.sleep(1000);
                        updateProgress(i+1, seconds);
                       
                       }
                       return true;
                   }
               };
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
		if (output.contains("up")) {
			
			man.setLayoutY(man.getLayoutY() -20);
			System.out.println("form the homeController:"+output);			
		}else if(output.contains(null)) {
			man.setLayoutY(man_inital_pos);
		}
	}

	@Override
	public void detectCollision() {
		// TODO Auto-generated method stub
		
	}
	
	

}
