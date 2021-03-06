package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	Stopwatch stopwatch;

	@Override
	public void start(Stage stage) throws Exception {

		BorderPane stopwatch = new Stopwatch(1000);

		// Set up the stage
		stage.setTitle("Stopwatch");
		stage.setScene(new Scene(((Stopwatch) stopwatch).getGraph(), 300, 200));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}