package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	Button Signin;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Fleet Manager");
		
		
		
		Signin = new Button();
		Signin.setText("Sign in!");
		Signin.setLayoutX(500);
		
		StackPane layout = new StackPane();
		layout.getChildren().add(Signin);
		
		Scene scene = new Scene(layout, 1000, 250);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
