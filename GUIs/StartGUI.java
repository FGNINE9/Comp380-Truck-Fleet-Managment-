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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StartGUI extends Application {

    JobDatabase data = new JobDatabase();
    Image icon = new Image("Icon.png");
    TruckerRole Current = new TruckerRole();
    TruckerRole RN = new TruckerRole(1, "1", "Raashid Norman", "Admin");
    TruckerRole NK = new TruckerRole(2, "2", "Naery Kouyoumjian", "Driver");

    /**
     * Is called to display the Driver job list after login
     *
     * @param primaryStage Stage where the Driver GUI will be set
     */
    public void Driver(Stage primaryStage) {

        double Xwin = 1000;
        double Ywin = 800;


        //Labels
        Label title = new Label("Pending Jobs:");
        title.setTranslateX(-Xwin / 2.3);
        title.setTranslateY(-Ywin / 2.12);

        //Buttons and setup
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(450);
        Logout.setTranslateY(370);

        Button StartJob = new Button("Start Job");
        StartJob.setTranslateX(0);
        StartJob.setTranslateY(350);

        Button CompleteJob = new Button("Complete Job");
        CompleteJob.setTranslateX(100);
        CompleteJob.setTranslateY(350);


        StackPane root = new StackPane();


        TableView<Job> JobTable = new TableView<Job>();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));
        ID.setPrefWidth(50);

        TableColumn Start = new TableColumn("Start");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));
        Start.setPrefWidth(200);

        TableColumn End = new TableColumn("To");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));
        End.setPrefWidth(200);

        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));
        Notes.setPrefWidth(495);

        JobTable.getColumns().addAll(ID, Start, End, Notes);
        jobToTableDriver(JobTable);
        JobTable.setPrefSize(960, 650);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin / 50);
        JobTable.setTranslateY(Ywin / 20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title, StartJob, CompleteJob);
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

    public void Admin(Stage primaryStage) {

        // Instantiate class calls
        AdministratorRole Admin = new AdministratorRole();
        Tickets Tickets = new Tickets();

        double Xwin = 1000;
        double Ywin = 800;

        //Labels
        Label title = new Label("Pending Jobs");
        title.setTranslateX(-Xwin / 2.3);
        title.setTranslateY(-Ywin / 2.12);

        //Buttons and setup
        Button Logout = new Button("Sign out");
        Logout.setTranslateX(430);
        Logout.setTranslateY(350);


        Button AssignJob = new Button("Assign Job");
        AssignJob.setTranslateX(90);
        AssignJob.setTranslateY(350);


        Button ViewDrivers = new Button("View Drivers");
        ViewDrivers.setTranslateX(-30);
        ViewDrivers.setTranslateY(350);


        Button DownloadTickets = new Button("Download Tickets");
       DownloadTickets.setTranslateX(-250);
        DownloadTickets.setTranslateY(350);

        Button ViewTickets = new Button("View Tickets");
        ViewTickets.setTranslateX(-140);
        ViewTickets.setTranslateY(350);



        StackPane root = new StackPane();

        TableView JobTable = new TableView();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));

        TableColumn Start = new TableColumn("Start");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));


        TableColumn End = new TableColumn("To");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));

        TableColumn paid = new TableColumn("Paid");
        paid.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("paid"));

        TableColumn status = new TableColumn("Status");
        status.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("status"));

        TableColumn completionTime = new TableColumn("Completion Time");
        completionTime.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("completionTime"));

        TableColumn truckerID = new TableColumn("Trucker ID");
        truckerID.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("truckerID"));

        TableColumn jobHours = new TableColumn("Job Hours");
        jobHours.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("jobHours"));

        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));

        JobTable.getColumns().addAll(ID, Start, End, paid, status, completionTime, truckerID, jobHours, Notes);
        jobToTableAdmin(JobTable);
        JobTable.setPrefSize(960, 650);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin / 50);
        JobTable.setTranslateY(Ywin / 20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title, AssignJob, ViewTickets, DownloadTickets, ViewDrivers);


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

        AssignJob.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Job job = (Job) JobTable.getSelectionModel().getSelectedItem();
                Admin.AssignJobs(NK, job);
            }
        });

        DownloadTickets.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Job job = (Job) JobTable.getSelectionModel().getSelectedItem();
                Tickets.DownloadTickets(new Tickets(job));
            }
        });

        ViewTickets.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Job job = (Job) JobTable.getSelectionModel().getSelectedItem();
                Admin.ViewTickets(job);
            }
        });

        ViewDrivers.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Current Drivers: ");
                System.out.println("Driver ID: " + NK.getIDNumber());
                System.out.println("Driver Name: " + NK.getName());
            }
        });

    }


    /**
     * Start up for program where the user logs in
     *
     * @param StartStage Stage where the Log in GUI will be set
     */
    public void start(Stage StartStage) {

        Button SignInButton = new Button("Sign In!");
        SignInButton.setTranslateY(50);


        Label Title = new Label("Sign In!");
        Title.setTranslateY(-75);
        Title.setFont(Font.font("Calibre", 20));

        Label wrong = new Label("Wrong Password or Username!");
        wrong.setTranslateY(-50);
        wrong.setFont(Font.font("Calibre", 20));
        wrong.setTextFill(Color.RED);

        Label UserNameLabel = new Label("User Name: ");
        UserNameLabel.setTranslateX(-140);
        UserNameLabel.setTranslateY(-25);
        UserNameLabel.setFont(Font.font("Calibre", 15));

        TextField userName = new TextField();
        userName.setPrefHeight(25);
        userName.setMaxWidth(200);
        userName.setTranslateY(-25);

        Label PasswordLabel = new Label("Password: ");
        PasswordLabel.setTranslateX(-137);
        PasswordLabel.setTranslateY(10);
        PasswordLabel.setFont(Font.font("Calibre", 15));

        PasswordField password = new PasswordField();
        password.setPrefHeight(25);
        password.setMaxWidth(200);
        password.setTranslateY(10);

        StackPane log = new StackPane();
        log.getChildren().addAll(userName, password, Title, UserNameLabel, PasswordLabel, SignInButton);

        SignInButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (Integer.parseInt(userName.getText()) == NK.getIDNumber() && password.getText().equals(NK.getPassword())) {
                    //Driver GUI
                    Current.setIDNumber(Integer.parseInt(userName.getText()));

                    StartStage.close();
                    Driver(StartStage);

                } else if (Integer.parseInt(userName.getText()) == RN.getIDNumber() && password.getText().equals(RN.getPassword())) {
                    //Admin GUI
                    Current.setIDNumber(Integer.parseInt(userName.getText()));

                    StartStage.close();
                    Admin(StartStage);

                } else {
                    log.getChildren().add(wrong);
                }


            }

        });


        Scene Scenelog = new Scene(log, 400, 200);
        StartStage.setScene(Scenelog);
        StartStage.getIcons().add(icon);
        StartStage.setResizable(false);
        StartStage.setTitle("Sign In");
        StartStage.show();


    }

    public static void main(String[] args) {

        launch(args);

    }

    public void jobToTableDriver(TableView table ){
        int counter = 0;
        int ID;
        String startLocation;
        String endLocation;
        String status;
        String notes;
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

    public void jobToTableAdmin(TableView table ){

        for(int i=0;i<data.getJobListSortedByID().size();i++)
        {
            table.getItems().add(data.getJobListSortedByID().get(i));
        }

    }

    /**
     * Method used to split text for the table view
     *
     * @param note the text you want to split
     * @return the text in the split form
     */
    public String toNotesFormat(String note){
        int counter = 0;
        int prev = 0, counter2 = 0;

        if(note.length() < 80){
            return note;
        }

        String[] splitnote = note.split(" ");
        note = "";
        try {
            while (counter < splitnote.length) {
                if ( counter < splitnote.length && prev  + splitnote[counter].length() + 1 < 80) {
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
