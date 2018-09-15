package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

//********************************************************************************* 
// CscProjectTwo.java     Author: Mohammad Khan     Publication Date: 06/17/18
//
// Demonstrates the creation of shapes and their graphical user interface.
//*********************************************************************************

public class CscProjectTwo extends Application {
	
//-----------------------------------------------------------------------------------------------
// Forms a traffic light that switches from green, yellow, red, and repeats by clicking a button.
//-----------------------------------------------------------------------------------------------
	
	private int count;
	
	Rectangle rect = new Rectangle(250, 50, 100, 300); // Forms a black rectangle representing the base of a traffic light.
	
	// Forms circles for the three lights in the traffic light.
	Circle circle1 = new Circle(300, 100, 40);
	Circle circle2 = new Circle(300, 200, 40);	
	Circle circle3 = new Circle(300, 300, 40);
	
	public void start(Stage primaryStage) {
	count = 1;
	
	// Initializes the colors scheme to one green and two grey lights.
	circle1.setFill(Color.RED);
	circle2.setFill(Color.GREY);
	circle3.setFill(Color.GREY);
	
	// Forms a button to press when changing the traffic signal.
	Button push = new Button("Push Me To Change Signal");
	push.setOnAction(this::processButtonPress);
	
	// Situates the button to the top left of the window.
	FlowPane pane = new FlowPane(push);
	pane.setAlignment(Pos.TOP_LEFT);
	pane.setHgap(20);
	
	// Adds all components together to form the GUI.
	Group root = new Group (rect, circle1, circle2, circle3, pane);
	Scene scene = new Scene(root, 400, 400);
	
	// Presents all components.
	primaryStage.setTitle("Traffic Lights"); 
	primaryStage.setScene(scene);
	primaryStage.show();
}
	
public void processButtonPress(ActionEvent event) {
	count++;
	
	// Sets the green light to only show.
	if (count == 1) {
		circle1.setFill(Color.RED);
		circle2.setFill(Color.GREY);
		circle3.setFill(Color.GREY);
	}
	// Sets the yellow light to only show.
	if (count == 2) {
		circle1.setFill(Color.GREY);
		circle2.setFill(Color.YELLOW);
		circle3.setFill(Color.GREY);
    }
	// Sets the red light to only show.
	if (count == 3 ) {
		circle1.setFill(Color.GREY);
		circle2.setFill(Color.GREY);
		circle3.setFill(Color.GREEN);
	}
	// loops the variable "count" back to 1 to repeat the lighting process.
	if (count >= 3 ) {
		count = 0;
	}
	}
	public static void main(String[] args) {
		launch(args);
	}
}