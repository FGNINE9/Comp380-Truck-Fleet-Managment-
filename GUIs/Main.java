package GUIs;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an instance of the login GUI
        LoginGUI loginGUI = new LoginGUI();
        // Pass the primaryStage to the login GUI
        loginGUI.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
