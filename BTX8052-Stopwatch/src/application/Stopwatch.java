/**
 * 
 */
package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author andy.moser
 *
 */
public class Stopwatch extends BorderPane implements EventHandler<ActionEvent> {
	Timer timer;
	BorderPane root;
	Label stoppuhrzeit;
	int interval;
	private Button startbutton;
	private Button stopbutton;
	private Button resetbutton;
	private Label statuslabel;

	public Stopwatch(int interval) {
		this.interval = interval;
		timer = new Timer(interval);

		timer.attach(this);
	}

	public BorderPane getGraph() {
		root = new BorderPane();
		root.minHeight(500);

		BorderPane stoppUhrPane = new BorderPane();
		BorderPane centerPane = new BorderPane();
		HBox stoppuhr = new HBox();

		Label stoppuhrtext = new Label("Sekunden:");
		this.stoppuhrzeit = new Label("0.00");

		VBox bottom = new VBox();

		HBox controlbox = new HBox();

		this.startbutton = new Button("Start");
		this.stopbutton = new Button("Stop");
		this.resetbutton = new Button("Reset");

		startbutton.setMinWidth(50.00);
		stopbutton.setMinWidth(50.00);
		resetbutton.setMinWidth(50.00);

		startbutton.addEventHandler(ActionEvent.ACTION, this);
		stopbutton.addEventHandler(ActionEvent.ACTION, this);
		resetbutton.addEventHandler(ActionEvent.ACTION, this);

		stoppuhr.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 3;" + "-fx-border-color: black;");

		HBox statusbox = new HBox();
		this.statuslabel = new Label("stopped");

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

		return root;
	}

	public void update() {

		Platform.setImplicitExit(false);

		System.out.println(timer.getTimeString().toString());

		this.stoppuhrzeit.setText(timer.getTimeString().toString());

	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == this.startbutton) {
			timer.start();
			this.statuslabel.setText("started");
		} else if (event.getSource() == this.stopbutton) {
			timer.stop();
			this.statuslabel.setText("stopped");
		} else if (event.getSource() == this.resetbutton) {
			timer.reset();
			this.statuslabel.setText("reset");
		}

	}

}
