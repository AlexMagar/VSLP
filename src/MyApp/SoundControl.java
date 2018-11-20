package MyApp;

import javax.sound.sampled.LineUnavailableException;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GSpeechDuplex;
import com.darkprograms.speech.recognizer.GSpeechResponseListener;
import com.darkprograms.speech.recognizer.GoogleResponse;

import net.sourceforge.javaflacencoder.FLACFileWriter;

import controller.DemoPracticeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SoundControl extends Application{
	
	public final Microphone mic = new Microphone(FLACFileWriter.FLAC);
	public final GSpeechDuplex duplex = new GSpeechDuplex("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	public String output = "";

	DemoPracticeController demo;


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent root = fxmlLoader.load(getClass().getResource("/view/DemoPractice.fxml").openStream());
		demo = (DemoPracticeController) fxmlLoader.getController();
		
		System.out.println(demo);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(close->System.exit(0));
		
		
		//configuration Duplex
		duplex.setLanguage("en");

		duplex.addResponseListener(new GSpeechResponseListener() {
			
			@Override
			public void onResponse(GoogleResponse googleResponse) {

				//getting response from the google 
				output = googleResponse.getResponse();
			//	System.out.println("do i get "+output);
				if(output != null) {
					System.out.println("up demo:"+output);
					demo.makeDecision(output);
					setOutput(output);
				}else {
					System.out.println("Output was null");
				}
			}

		});
		
		startSpeechRecognition();

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
	

	public void setOutput(String output) {
		this.output = output;
	}
	
	public String getOutput() {
		return output;
	}

	public static void main(String[] args) {
		launch(args);
		
	}

}
