package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {

		BorderPane root = new BorderPane();
		root.minHeight(500);

		BorderPane stoppUhrPane = new BorderPane();
		BorderPane centerPane = new BorderPane();
		HBox stoppuhr = new HBox();

		Label stoppuhrtext = new Label("Sekunden:");
		Label stoppuhrzeit = new Label("0.00");

		VBox bottom = new VBox();

		HBox controlbox = new HBox();

		Button startbutton = new Button("Start");
		Button stopbutton = new Button("Stop");
		Button resetbutton = new Button("Reset");

		startbutton.setMinWidth(50.00);
		stopbutton.setMinWidth(50.00);
		resetbutton.setMinWidth(50.00);

		stoppuhr.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 3;" + "-fx-border-color: black;");

		HBox statusbox = new HBox();
		Label statuslabel = new Label("stopped");

		root.setCenter(centerPane);
		centerPane.setCenter(stoppUhrPane);

		stoppUhrPane.setCenter(stoppuhr);
		stoppuhr.setAlignment(Pos.CENTER);
		stoppuhr.getChildren().addAll(stoppuhrtext, stoppuhrzeit);

		centerPane.setBottom(controlbox);
		controlbox.setAlignment(Pos.CENTER);
		controlbox.getChildren().addAll(startbutton, stopbutton, resetbutton);

		root.setBottom(bottom);
		bottom.getChildren().add(statusbox);
		statusbox.getChildren().add(statuslabel);

		// Set up the stage
		stage.setTitle("Stopwatch");
		stage.setScene(new Scene(root, 300, 200));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}