package GUIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Date;


public class DriverGUI extends Application {

    JobDatabase data = new JobDatabase();
    Job GetJob = new Job();

    private String UserName = "U";
    private String Password = "P";

    //Image icon for Stages
    Image icon = new Image("Icon.png");

    /**
     * Is called to display the Driver job list after login
     * @param primaryStage
     */
    public void Driver(Stage primaryStage){

        double Xwin = 1200;
        double Ywin = 600;
        String Jobs = GetJob.printJob();


        //Labels
        Label title = new Label("Pending Jobs:");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.12);


        Button Logout = new Button("Sign out");
        Logout.setTranslateX(Xwin/2.3);
        Logout.setTranslateY(Ywin/2.3);


        StackPane root = new StackPane();

        Job adddata = new Job(2313, "Las Vegas", "Los Angeles", false, "Not Assigned", new Date(), 123, 12, "No Notes");

        TableView JobTable = new TableView();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));

        TableColumn Start = new TableColumn("Start");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));


        TableColumn End = new TableColumn("To");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));

        TableColumn Paid = new TableColumn("Paid");
        Paid.setCellValueFactory(new PropertyValueFactory<TableColumn, Boolean>("paid"));

        TableColumn Status = new TableColumn("Status");
        Status.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("status"));

        TableColumn Date = new TableColumn("Date Completed");
        Date.setCellValueFactory(new PropertyValueFactory<TableColumn, Date>("completionTime"));

        TableColumn TruckID = new TableColumn("TruckID");
        TruckID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("truckerID"));

        TableColumn JobHours = new TableColumn("Job Hours");
        JobHours.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("jobHours"));

        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));

        JobTable.getColumns().addAll(ID, Start, End, Paid,  Status, Date, TruckID, JobHours, Notes);
        JobTable.getItems().add(adddata);

        
        JobTable.setPrefSize(1000, 550);
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


    /**
     * Start up for program where the user logs in
     * @param StartStage
     */
    public void start(Stage StartStage) {

        Button SignInButton = new Button("Sign In!");
        SignInButton.setTranslateY(50);


        Label Title = new Label("Sign In!");
        Title.setTranslateY(-75);
        Title.setFont(Font.font("Calibri", 20));

        Label UserNameLabel = new Label("User Name: ");
        UserNameLabel.setTranslateX(-140);
        UserNameLabel.setTranslateY(-25);
        UserNameLabel.setFont(Font.font("Calibri", 15));

        TextField userName = new TextField();
        userName.setPrefHeight(25);
        userName.setMaxWidth(200);
        userName.setTranslateY(-25);

        Label PasswordLabel = new Label("Password: ");
        PasswordLabel.setTranslateX(-137);
        PasswordLabel.setTranslateY(10);
        PasswordLabel.setFont(Font.font("Calibri", 15));

        PasswordField password = new PasswordField();
        password.setPrefHeight(25);
        password.setMaxWidth(200);
        password.setTranslateY(10);

        SignInButton.setOnMouseClicked( new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {

                if (userName.getText().equals(UserName) && password.getText().equals(Password)){
                    System.out.println("Inside");
                    StartStage.close();
                    Driver(StartStage);
                }
            }

        });

        StackPane log = new StackPane();
        log.getChildren().addAll(userName,password,Title,UserNameLabel, PasswordLabel, SignInButton);
        Scene Scenelog = new Scene(log, 400, 200);
        StartStage.setScene(Scenelog);
        StartStage.getIcons().add(icon);
        StartStage.setResizable(false);
        StartStage.setTitle("Sign In");
        StartStage.show();
        System.out.println(userName.getLayoutBounds().getWidth());



    }


    public static void main(String[] args) {

        launch(args);

    }

}