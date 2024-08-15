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

public class AdminGUI extends Application {

    JobDatabase data = new JobDatabase();
    Job GetJob = new Job();
    Tickets tickets = new Tickets();
    AdministratorRole admin = new AdministratorRole();
    TruckerRole trucker = new TruckerRole();

    private final String UserName = "Admin";
    private final String Password = "APass";

    Image icon = new Image("Icon.png");
    /**
     * Display Admin job list after login
     * @param primaryStage
     */
    public void Admin(Stage primaryStage) {

        double Xwin = 1000;
        double Ywin = 800;

        //Labels
        Label title = new Label("Pending Jobs");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.12);

        //Buttons and setup
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(Xwin/2.3);
        Logout.setTranslateY(Ywin/2.3);

        Button AssignJob = new Button("Assign Job");
        AssignJob.setTranslateX(Xwin/2.3);
        AssignJob.setTranslateY(Ywin/2.7);

        Button ViewTickets = new Button("View Tickets");
        ViewTickets.setTranslateX(Xwin/2.3);
        ViewTickets.setTranslateY(Ywin/3.1);

        Button DownloadTickets = new Button("Download Tickets");
        DownloadTickets.setTranslateX(Xwin/2.3);
        DownloadTickets.setTranslateY(Ywin/3.5);

        Button EditTickets = new Button("Edit Tickets");
        EditTickets.setTranslateX(Xwin/2.3);
        EditTickets.setTranslateY(Ywin/3.9);

        toNotesFormat("He will he she");

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
        JobTable.setPrefSize(400, 550);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin/50);
        JobTable.setTranslateY(Ywin/20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title, AssignJob, ViewTickets, DownloadTickets, EditTickets);

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

        Logout.setOnAction(new EventHandler<ActionEvent>() {
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

                if (userName.getText().equals(UserName) && password.getText().equals(Password)){
                    System.out.println("Admin Inside");
                    StartStage.close();
                    Admin(StartStage);
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
            notes = toNotesFormat(data.getJobListSortedByID().get(counter).getNotes());

            Job adding = new Job(ID, startLocation, endLocation, status, notes);
            table.getItems().add(adding);
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
}
