package GUIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class DriverGUI extends Application {

    public void Driver(Stage primaryStage){

        JobDatabase data = new JobDatabase();

        Job GetJob = new Job();


        double Xwin = 800;
        double Ywin = 600;
        String Jobs = GetJob.printJob();


        //Labels
        Label title = new Label("Pending Jobs:");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.12);

        // Buttons
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(Xwin/2.3);
        Logout.setTranslateY(Ywin/2.3);

        //Images
        Image icon = new Image("Icon.png");

        //Layout
        StackPane root = new StackPane();


        TableView JobTable = new TableView();
        TableColumn ID = new TableColumn("ID");
        TableColumn From = new TableColumn("From");
        TableColumn To = new TableColumn("To");
        TableColumn Paid = new TableColumn("Paid");
        TableColumn Status = new TableColumn("Status");
        TableColumn Notes = new TableColumn("Notes");
        JobTable.getColumns().addAll(ID, From, To, Paid, Status, Notes);

        JobTable.setPrefSize(600, 550);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin/50);
        JobTable.setTranslateY(Ywin/20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title);
        //Scenes
        Scene driverJobList = new Scene(root, Xwin, Ywin);

        title.toFront();
        Logout.toFront();

        //Primary Stage
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(driverJobList);
        primaryStage.setTitle("Fleet Management System");
        primaryStage.show();

        Logout.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {

                primaryStage.close();
                start(primaryStage);


            }
        });

    }
    public void start(Stage StartStage) {

        TextField username = new TextField();
        username.setPrefHeight(25);
        username.setPrefWidth(50);

        StackPane root = new StackPane();
        root.getChildren().addAll(username);
        Scene Scenelog = new Scene(root, 400, 200);
        StartStage.setScene(Scenelog);
        StartStage.setResizable(false);
        StartStage.setTitle("Sign In");
        StartStage.show();



    }


    public static void main(String[] args) {
        launch(args);

    }

}