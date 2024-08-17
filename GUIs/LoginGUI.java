package GUIs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    private final String adminUserName = "Admin";
    private final String adminPassword = "APass";
    private final String driverUserName = "Driver";
    private final String driverPassword = "DPass";

    Image icon = new Image ("Icon.png");

    @Override
    public void start(Stage primaryStage) {
        Button signInButton = new Button("Sign In!");
        signInButton.setTranslateY(50);

        Label title = new Label("Sign In!");
        title.setTranslateY(-75);
        title.setFont(Font.font("Calibri", 20));

        Label userNameLabel = new Label("User Name: ");
        userNameLabel.setTranslateX(-140);
        userNameLabel.setTranslateY(-25);
        userNameLabel.setFont(Font.font("Calibri", 15));

        TextField userName = new TextField();
        userName.setPrefHeight(25);
        userName.setMaxWidth(200);
        userName.setTranslateY(-25);

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setTranslateX(-137);
        passwordLabel.setTranslateY(10);
        passwordLabel.setFont(Font.font("Calibri", 15));

        PasswordField password = new PasswordField();
        password.setPrefHeight(25);
        password.setMaxWidth(200);
        password.setTranslateY(10);

        signInButton.setOnAction(event -> {
            String enteredUserName = userName.getText();
            String enteredPassword = password.getText();

            if (enteredUserName.equals(adminUserName) && enteredPassword.equals(adminPassword)) {
                System.out.println("Admin Inside");
                primaryStage.close();
                AdminGUI adminGUI = new AdminGUI();
                adminGUI.start(primaryStage);
            } else if (enteredUserName.equals(driverUserName) && enteredPassword.equals(driverPassword)) {
                System.out.println("Driver Inside");
                primaryStage.close();
                DriverGUI truckerGUI = new DriverGUI();
                truckerGUI.start(primaryStage);
            } else {
                System.out.println("Wrong Username or Password");
            }
        });

        StackPane log = new StackPane();
        log.getChildren().addAll(userName, password, title, userNameLabel, passwordLabel, signInButton);
        Scene sceneLog = new Scene(log, 400, 200);
        primaryStage.setScene(sceneLog);
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Sign In");
        primaryStage.show();
    }
}
