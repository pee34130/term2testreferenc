package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Timer;

public class Main extends Application {
	// implement your code here
	public static Timer timer;
	@Override
	public void start(Stage primaryStage) {
		// implement your code here
		HBox root = new HBox();
		Timer RightClock = new Timer("rightclock", 1);
		Timer MidddleClock =new Timer("middleclock", 1);
		timer = new Timer("leftclock", -1);
		root.getChildren().addAll(timer.getTimerGUI(),MidddleClock.getTimerGUI(),RightClock.getTimerGUI());
		Scene scene = new Scene(root);
		primaryStage.setTitle("Timer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main (String [] args) {
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		Platform.exit();
	}
	
	
}
