package controller;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LeftRightController extends Application implements EventHandler<KeyEvent>{
	
	@FXML
	private ImageView stone_small;
	
	@FXML
	private ImageView stone_big;
	
	@FXML
	private ImageView stone_mud;
	
	@FXML
	private ImageView car;
	
	public void moveStone() {
		int minX = 265, minY = 150, maxX = 324, maxY = 380;
		int xDiff = maxX - minX; // range to move for x
		int yDiff = maxY - minY;
		int size = 30;
//		int newX = (int)Math.floor((Math.random()* xDiff)) + minX;
//	//	int newY = (int)Math.floor((Math.random() * yDiff)) + minY;
//		stone_small.setLayoutX(newX);
//		stone_small.setLayoutY(stone_small.getLayoutY() +10);
//	//	stone_small.setLayoutY(newY);
//	//	stone_small.setFitHeight(size * (newY / 100));
//	//	stone_small.setFitWidth(size * (newY / 100));
////		System.out.println(stone);
		
		double currentY = stone_small.getLayoutY();
		if(currentY < maxY) {
			currentY += 1;
			stone_small.setLayoutY(currentY);
		}else {
			stone_small.setLayoutX(minX);
			stone_small.setLayoutY(minY);
		}
		
	}
	
	

	@Override
	public void handle(KeyEvent event) {
		
		switch (event.getCode()) {
		case A: car.setTranslateX(car.getTranslateX() -10); break;
		case D: car.setLayoutX(car.getLayoutX() + 10); break;
		default: System.out.println("out of the way"); break;
		}
		
	}
	public void update() {
		moveStone();
		if(car.getBoundsInParent().intersects(stone_small.getBoundsInParent())) {
			System.out.println("you stuck in stone");
		}
	}

	@Override
	public void start(Stage primaryStage){
		try {
			//	BorderPane root = new BorderPane();
				Parent root = FXMLLoader.load(getClass().getResource("/view/leftRight.fxml"));
				Scene scene = new Scene(root,600,400);
				scene.setOnKeyPressed(this);
			//	scene.getStylesheets().add(getClass().getResource("/color/application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				Timer timer = new Timer();
				LeftRightController app = this;
				stone_small = (ImageView) scene.lookup("#stone_small");
				car = (ImageView) scene.lookup("#car");
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						app.update();
					}
				}, 10000, 10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
