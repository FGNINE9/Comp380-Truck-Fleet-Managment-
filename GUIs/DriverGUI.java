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

/**
 * class that takes care of driver GUI and Login with methods including JobToTable and toNotesFormat
 * @author Fabian Garcia
 */
public class DriverGUI extends Application {


    JobDatabase data = new JobDatabase();


    private final int LogID = 111;
    private final String Password = "Pass";
    private final String UserNameAdmin = "Admin";
    private final String PasswordAdmin = "AdminPass";

    //Image icon for Stages
    Image icon = new Image("Icon.png");

    /**
     * Is called to display the Driver job list after login
     * @param primaryStage Stage where the Driver GUI will be set
     */
    public void Driver(Stage primaryStage){

        double Xwin = 1000;
        double Ywin = 600;


        //Labels
        Label title = new Label("Pending Jobs:");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.12);

        Label StartJobError = new Label("Complete current job before starting others!");
        StartJobError.setTranslateX(Ywin/2.12);

        //Buttons and setup
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(Xwin/2.3);
        Logout.setTranslateY(Ywin/2.3);

        Button StartJob = new Button("Start Job");
        StartJob.setTranslateX(Xwin/2.3);
        StartJob.setTranslateY(Ywin/3);

        toNotesFormat("He will he she");

        StackPane root = new StackPane();


        TableView<Job> JobTable = new TableView<>();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));

        TableColumn Start = new TableColumn("Origin");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));


        TableColumn End = new TableColumn("Drop off");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));


        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));

        JobTable.getColumns().addAll(ID, Start, End, Notes);
        jobToTable(JobTable);
        JobTable.setPrefSize(400, 550);
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

        StartJob.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {
               boolean Jobchecked = CheckForJob();
                String selected = JobTable.getSelectionModel().getSelectedItem().getStatus();
               if(Jobchecked){
                   selected = "In Progress";
                   root.getChildren().add(StartJobError);
                   JobTable.getItems().clear();
                   jobToTable(JobTable);
               }else{

               }

            }

        });
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
<<<<<<< HEAD
                TruckerRole truckerRole;

                if (userName.getText().equals(UserName) && password.getText().equals(Password)){
                    truckerRole = new TruckerRole(1, "Pass", "Driver", false); //driver not admin
||||||| be326f4

                if (userName.getText().equals(UserName) && password.getText().equals(Password)){
=======
                int IDEnetered = Integer.parseInt(userName.getText());
                if (IDEnetered == LogID && password.getText().equals(Password)){
>>>>>>> ac517473af51ab7c58867ca0966b96b59663f46a
                    System.out.println("Driver Inside");

                }
<<<<<<< HEAD
                else if (userName.getText().equals(UserNameAdmin) && password.getText().equals(PasswordAdmin)){
                    truckerRole = new TruckerRole(1, "AdminPass", "Admin", true); //user is admin
                    System.out.println("Admin Inside");

                }
                else {
                    System.out.println("Wrong Password");
                    return;
                }

                StartStage.close();
                if (truckerRole.isAdmin()){
                    Driver2(StartStage);
                }else{
                    Driver(StartStage);
                }
||||||| be326f4
                else if (userName.getText().equals(UserNameAdmin) && password.getText().equals(PasswordAdmin)){
                    System.out.println("Admin Inside");
                    StartStage.close();
                    Driver2(StartStage);
                } else {
                    System.out.println("Wrong Password");
                }
=======
>>>>>>> ac517473af51ab7c58867ca0966b96b59663f46a
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
     */
    public void jobToTable(TableView table ){
        int counter = 0;
        int ID;
        String startLocation;
        String endLocation;
        String status;
        String notes;
        int TruckerID;
        ArrayList<Job> joblist = data.getJobListSortedByID();
        do{
            ID = data.getJobListSortedByID().get(counter).getID();
            startLocation = data.getJobListSortedByID().get(counter).getStartLocation();
            endLocation = data.getJobListSortedByID().get(counter).getEndLocation();
            status = data.getJobListSortedByID().get(counter).getStatus();
            TruckerID = data.getJobListSortedByID().get(counter).getTruckerID();
            notes = toNotesFormat(data.getJobListSortedByID().get(counter).getNotes());

            Job adding = new Job(ID, startLocation, endLocation, status, notes);
            if(TruckerID == LogID) {
                table.getItems().add(adding);
            }
                counter++;
        }while(data.getJobListSortedByID().size() != counter);

    }

    /**
     * Method used to split text for the table view
     * @param note the text you want to split
     * @return the text in the split form
     */
    public String toNotesFormat(String note){
        int counter = 0;
        int prev = 0, counter2 = 0;
        String[] splitnote = note.split(" ");
        note = "";
        try {
            while (counter < splitnote.length) {
                if ( counter < splitnote.length && prev  + splitnote[counter].length() + 1 < 25) {
                    prev = prev  + splitnote[counter].length() + 1;
                    counter++;
                } else {

                    while (counter2 < counter){

                        note = note + splitnote[counter2] + " ";
                        counter2++;

                    }
                    note = note + "\n";
                    prev = 0;
                }

                if(counter == splitnote.length + 1){break;}
            }
        }catch (Exception e){return "Error Loading String for Sizing!";}
        return note;
    }

    public boolean CheckForJob( ){
        ArrayList<Job> jobList = data.getJobListStatus();
        int counter = 0;

        while(jobList.size() > counter){
            if(jobList.get(counter).getStatus().equals("In Progress") && jobList.get(counter).getTruckerID() == LogID){
                return true;
            }
            counter ++;
        }

        return false;
    }

    /**
     * Main start method, runs the GUI
     * @param args arguments for main
     */
    public static void main(String[] args) {

        launch(args);

    }

}