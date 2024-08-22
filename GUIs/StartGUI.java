package GUIs;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Date;

public class StartGUI extends Application {

    JobDatabase data = new JobDatabase();
    Image icon = new Image("Icon.png");
    TruckerRole Current = new TruckerRole();
    TruckerRole RN = new TruckerRole(1, "1", "Raashid Norman", "Admin");
    TruckerRole NK = new TruckerRole(2, "2", "Naery Kouyoumjian", "Driver");
    ArrayList<Job> list;

    /**
     * Is called to display the Driver job list after login
     *
     * @param primaryStage Stage where the Driver GUI will be set
     */
    public void Driver(Stage primaryStage) {

        double Xwin = 1000;
        double Ywin = 800;

        Label noSelection = new Label("Job must be selected!");
        noSelection.setTextFill(Color.RED);
        noSelection.setTranslateX(0);
        noSelection.setTranslateY(370);

        Label Selectionnotvalid = new Label("Job Selected is not Pending, make another selection!");
        Selectionnotvalid.setTextFill(Color.RED);
        Selectionnotvalid.setFont(Font.font("Calibre", 12));
        Selectionnotvalid.setTranslateX(0);
        Selectionnotvalid.setTranslateY(370);
        
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

        Button ViewCur = new Button("View Current Job");
        ViewCur.setTranslateX(-100);
        ViewCur.setTranslateY(350);

        Button ViewSummary = new Button("View Summary");
        ViewSummary.setTranslateX(-350);
        ViewSummary.setTranslateY(350);

        Button ViewPending = new Button("View Pending Jobs");
        ViewPending.setTranslateX(-225);
        ViewPending.setTranslateY(350);

        Button InputJobData = new Button("Input Job Data");
        InputJobData.setTranslateX(200);
        InputJobData.setTranslateY(350);

        StackPane root = new StackPane();

        TableView<Job> JobTable = new TableView<Job>();

        TableColumn ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory<TableColumn, Integer>("ID"));
        ID.setPrefWidth(100);

        TableColumn Start = new TableColumn("Start");
        Start.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("startLocation"));
        Start.setPrefWidth(175);

        TableColumn End = new TableColumn("To");
        End.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("endLocation"));
        End.setPrefWidth(175);

        TableColumn Status = new TableColumn("Status");
        Status.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("status"));
        Status.setPrefWidth(100);

        TableColumn Notes = new TableColumn("Notes");
        Notes.setCellValueFactory(new PropertyValueFactory<TableColumn, String>("notes"));
        Notes.setPrefWidth(395);

        JobTable.getColumns().addAll(ID, Start, End, Status, Notes);
        jobToTableDriver(JobTable);
        JobTable.setPrefSize(960, 650);
        JobTable.setEditable(false);
        JobTable.setTranslateX(Xwin / 50);
        JobTable.setTranslateY(Ywin / 20);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(JobTable);
        root.getChildren().addAll(scroll, Logout, title, StartJob, CompleteJob, ViewCur, ViewSummary, ViewPending, noSelection, Selectionnotvalid, InputJobData);
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
        
        noSelection.setVisible(false);
        Selectionnotvalid.setVisible(false);
        PauseTransition noSelectiontimed = new PauseTransition(Duration.seconds(3));
        PauseTransition Selectionnotvalidtimed = new PauseTransition(Duration.seconds(3));

        StartJob.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Job selectedJob = JobTable.getSelectionModel().getSelectedItem();
                if(selectedJob == null) {
                    noSelection.setVisible(true);
                    noSelectiontimed.setOnFinished( e -> noSelection.setVisible(false));
                    noSelectiontimed.play();
                }else{
                    if(!selectedJob.getStatus().equals("Pending")){
                        Selectionnotvalid.setVisible(true);
                        Selectionnotvalidtimed.setOnFinished( e -> Selectionnotvalid.setVisible(false));
                        Selectionnotvalidtimed.play();
                    }else{
                        data.startJob(selectedJob);
                        JobTable.getItems().clear();
                        jobToTableDriver(JobTable);
                    }
                }

            }
        });

        InputJobData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Input Job Data");

                dialog.setHeaderText("Enter Job ID:");

                dialog.showAndWait().ifPresent(jobId -> {
                    dialog.setHeaderText("Enter Start Location");
                dialog.showAndWait().ifPresent(startLocation -> {
                    dialog.setHeaderText("Enter End Location:");
                dialog.showAndWait().ifPresent(endLocation -> {
                    boolean paid = true;
                    String status = "In Progress";
                    Date completionTime = new Date();
                    int jobHours = 1;
                    String notes = "None";

                    Current.inputLoadData(Integer.parseInt(jobId), startLocation, endLocation, paid, status, completionTime, jobHours, notes);
                        });
                });
                });
            }
        });





        CompleteJob.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {



            }
        });

        ViewCur.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {



            }
        });

        ViewSummary.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                System.out.print(Current.getWeeklySummary());

            }
        });

        ViewPending.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {



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
        AssignJob.setTranslateX(80);
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

        /**
         * Check these boxes before clicking the assign button
         */
        CheckBox paidCheckBox = new CheckBox("Paid");
        paidCheckBox.setTranslateX(190);
        paidCheckBox.setTranslateY(350);

        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Not Started", "In Progress", "Completed", "Delayed", "En Route", "On Time");
        statusComboBox.setValue("Not Started");
        statusComboBox.setTranslateX(300);
        statusComboBox.setTranslateY(350);



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
        root.getChildren().addAll(scroll, Logout, title, AssignJob, ViewTickets, DownloadTickets, ViewDrivers, paidCheckBox, statusComboBox, JobTable);


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
        /**
         * Also marks if job is completed
         */
        AssignJob.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Job job = (Job) JobTable.getSelectionModel().getSelectedItem();
                boolean paid = paidCheckBox.isSelected();
                String status = statusComboBox.getValue();
                Admin.AssignJobs(NK, job, paid, status);

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
        wrong.setVisible(false);

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
        log.getChildren().addAll(userName, password, Title, UserNameLabel, PasswordLabel, SignInButton, wrong);

        PauseTransition wrongtimed = new PauseTransition(Duration.seconds(3));
        wrongtimed.setOnFinished(e -> wrong.setVisible(false));

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
                    wrong.setVisible(true);
                    wrongtimed.setOnFinished(e -> wrong.setVisible(false));
                    wrongtimed.play();

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
        list = data.getJobListSortedByID();
        do{
            ID = list.get(counter).getID();
            startLocation = list.get(counter).getStartLocation();
            endLocation = list.get(counter).getEndLocation();
            status = list.get(counter).getStatus();
            notes = toNotesFormat(list.get(counter).getNotes(), 70);
            Job adding = new Job(ID, startLocation, endLocation, status, notes);
            table.getItems().add(adding);
            counter++;
        }while(data.getJobListSortedByID().size() != counter);

    }

    public void jobToTableAdmin(TableView table ){

        int counter = 0;
        int ID;
        String startLocation;
        String endLocation;
        boolean paid;
        String status;
        Date Compl;
        int TruckID;
        int JobH;
        String notes;
        do{
            ID = data.getJobListSortedByID().get(counter).getID();
            startLocation = data.getJobListSortedByID().get(counter).getStartLocation();
            endLocation = data.getJobListSortedByID().get(counter).getEndLocation();
            paid = data.getJobListSortedByID().get(counter).getPaid();
            status = data.getJobListSortedByID().get(counter).getStatus();
            Compl = data.getJobListSortedByID().get(counter).getCompletionTime();
            TruckID = data.getJobListSortedByID().get(counter).getTruckerID();
            JobH = data.getJobListSortedByID().get(counter).getJobHours();
            notes = toNotesFormat(data.getJobListSortedByID().get(counter).getNotes(), 30);
            Job adding = new Job(ID, startLocation, endLocation, paid, status,Compl, TruckID, JobH, notes);
            table.getItems().add(adding);
            counter++;
        }while(data.getJobListSortedByID().size() != counter);

    }

    /**
     * Method used to split text for the table view
     *
     * @param note the text you want to split
     * @return the text in the split form
     */
    public String toNotesFormat(String note, int space){
        int counter = 0;
        int prev = 0, counter2 = 0;

        if(note.length() < space){
            return note;
        }

        String[] splitnote = note.split(" ");
        note = "";
        try {
            while (counter < splitnote.length) {
                if ( counter < splitnote.length && prev  + splitnote[counter].length() + 1 < space) {
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
