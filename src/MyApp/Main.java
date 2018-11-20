package MyApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.LineUnavailableException;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;

import controller.HomeController;
import controller.SceneController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sourceforge.javaflacencoder.FLACFileWriter;

public class Main extends Application {
	
	public final Microphone mic = new Microphone(FLACFileWriter.FLAC);
	public final GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	public String output = "";
	HomeController homeCnt;
	
	public static String screenId[] = {"home", "car", "jump", "cave", "tranning"};
	
//	public static String screen1ID = "home";
	public static String screen1File = "/view/Home.fxml";
//	public static String screen2ID = "car";
	public static String screen2File = "/view/Car.fxml";
//	public static String screen3ID = "jump";
	public static String screen3File = "/view/Jump.fxml";
//	public static String screen4ID = "cave";
	public static String screen4File = "/view/Cave.fxml";
	public static String screen5File = "/view/Traning.fxml";
	
	Object objm="";
	
    @Override
    public void start(Stage stage) throws Exception {
    	
    	
    	SceneController mainController = new SceneController();
    	mainController.loadScene(Main.screenId[0], Main.screen1File);
    	mainController.loadScene(Main.screenId[1], Main.screen2File);
    	mainController.loadScene(Main.screenId[2], Main.screen3File);
    	mainController.loadScene(Main.screenId[3], Main.screen4File);
    	mainController.loadScene(Main.screenId[4], Main.screen5File);

		mainController.setScene(Main.screenId[0]);
		
		System.out.println(mainController.getScene("home"));
		System.out.println(mainController.getScene("car"));
		System.out.println(mainController.getScene("jump"));
		System.out.println(mainController.getScene("cave"));
		System.out.println(mainController.getScene("tranning"));
		Node ntm = mainController.getScene("home");
		System.out.println(ntm);
		
		System.out.println(mainController.getController("tranning"));
		Object obj = mainController.getController("home");
		System.out.println(obj);
		
//    	Timer timer = new Timer();
//        	timer.scheduleAtFixedRate(new TimerTask() {
//        		int i =1;
//    			@Override
//    			public void run() {
//    				
//    				System.out.println(i);
//    				mainController.setScene(Main.screenId[i]);
//    				objm = mainController.getController(Main.screenId[i]);
//					i+=1;
//					if(i==5) { 
//						
//						timer.cancel();
//					
//					}
//    			}
//    		}, 3000, 3000);
//		
		
		duplex.setLanguage("en");
		
		duplex.addResponseListener(new GSpeechResponseListener() {
			
			@Override
			public void onResponse(GoogleResponse googleResponse) {
				
				//getting response from google
				output = googleResponse.getResponse();
				System.out.println(output);
				
				if (output != null) {
					
					homeCnt = (HomeController) obj;
					homeCnt.makeDecision(output);
				}else {
					System.out.println("no response from google");
				}
				
			}
		});
		
		startSpeechRecognition();
    	
        System.out.println("out of the loop:"+objm);	
        
        	
    	Group root = new Group();
    	root.getChildren().addAll(mainController);
    	Scene scene = new Scene(root, 850, 420);
    	stage.setResizable(false);
    	stage.setScene(scene);
    	stage.show();
    	stage.setOnCloseRequest(close ->System.exit(0));
    	
    }
    
    public String makeDecision(String output) {
    	
    	output = output.trim();
    	System.out.println(output);
    	return output;
    }
    
	//starts the speech Recognition
	public void startSpeechRecognition() {
		//start a new Thread so that application don't lags
		new Thread(()->{
			try {
				duplex.recognize(mic.getTargetDataLine(), mic.getAudioFormat());
			} catch (LineUnavailableException | InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	//stop the speech Recognition
	public void stopSpeechRecognition() {
		mic.close();
		System.out.println("stop speech recognition.."+ mic.getState());
	}

    public static void main(String[] args) {
        launch(args);
    }
}
