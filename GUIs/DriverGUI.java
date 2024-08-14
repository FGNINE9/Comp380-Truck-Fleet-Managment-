package GUIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;


public class DriverGUI extends Application {

    JobDatabase data = new JobDatabase();
    Job GetJob = new Job();

    private final String UserName = "User";
    private final String Password = "Pass";
    private final String UserNameAdmin = "Admin";
    private final String PasswordAdmin = "AdminPass";

    //Image icon for Stages
    Image icon = new Image("Icon.png");

    /**
     * Is called to display the Driver job list after login
     * @param primaryStage Stage where the Driver GUI will be set
     * @author Fabian Garcia
     */
    public void Driver(Stage primaryStage){

        double Xwin = 1000;
        double Ywin = 600;
        String Jobs = GetJob.printJob();


        //Labels
        Label title = new Label("Pending Jobs:");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.12);

        //Buttons and setup
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(Xwin/2.3);
        Logout.setTranslateY(Ywin/2.3);

        Button StartJob = new Button("Start Job");
        StartJob.setTranslateX(Xwin/2.3);
        StartJob.setTranslateY(Ywin/3);


        StackPane root = new StackPane();


        TableView JobTable = new TableView();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));

        TableColumn Start = new TableColumn("Start");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));


        TableColumn End = new TableColumn("To");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));


        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));

        JobTable.getColumns().addAll(ID, Start, End, Notes);
        jobToTable(JobTable);
        JobTable.setPrefSize(365, 550);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin/50);
        JobTable.setTranslateY(Ywin/20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title, StartJob);
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

    public void Driver2(Stage primaryStage){
        double Xwin = 1000;
        double Ywin = 600;
        String Jobs = GetJob.printJob();


        //Labels
        Label title = new Label("Pending Jobs:");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.12);

        //Buttons and setup
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(Xwin/2.3);
        Logout.setTranslateY(Ywin/2.3);

        Button StartJob = new Button("Start Job");
        StartJob.setTranslateX(Xwin/2.3);
        StartJob.setTranslateY(Ywin/3);


        StackPane root = new StackPane();


        TableView JobTable = new TableView();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));

        TableColumn Start = new TableColumn("Start");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));


        TableColumn End = new TableColumn("To");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));


        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));

        JobTable.getColumns().addAll(ID, Start, End, Notes);
        jobToTable(JobTable);
        JobTable.setPrefSize(365, 550);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin/50);
        JobTable.setTranslateY(Ywin/20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title, StartJob);
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
     * @param StartStage Stage where the Log in GUI will be set
     * @author Fabian Garcia
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
                    System.out.println("Driver Inside");
                    StartStage.close();
                    Driver(StartStage);
                }
                else if (userName.getText().equals(UserNameAdmin) && password.getText().equals(PasswordAdmin)){
                    System.out.println("Admin Inside");
                    StartStage.close();
                    Driver2(StartStage);
                } else {
                    System.out.println("Wrong Password");
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



    }

    /**
     * This method helps add the Jobs to a tableview for the Driver GUI
     * @param table Table that jobs will be added to
     * @author Fabian Garcia
     */
    public void jobToTable(TableView table ){
        int counter = 0;
        int ID;
        String startLocation;
        String endLocation;
        String status;
        String notes;
        ArrayList<Job> joblist = data.getJobListSortedByID();
        do{
            ID = data.getJobListSortedByID().get(counter).getID();
            startLocation = data.getJobListSortedByID().get(counter).getStartLocation();
            endLocation = data.getJobListSortedByID().get(counter).getEndLocation();
            status = data.getJobListSortedByID().get(counter).getStatus();
            notes = data.getJobListSortedByID().get(counter).getNotes();
            Job adding = new Job(ID, startLocation, endLocation, status, notes);
            table.getItems().add(adding);
            counter++;
        }while(data.getJobListSortedByID().size() != counter);

    }


    public static void main(String[] args) {

        launch(args);

    }

}
