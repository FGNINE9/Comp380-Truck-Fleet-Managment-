package GUIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Date;


public class DriverGUI extends Application {


    @Override
    public void start(Stage Stage){

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
        Button returnButton = new Button("Return");
        returnButton.setTranslateX(Xwin/2.3);
        returnButton.setTranslateY(Ywin/2.3);

        //Images
        Image icon = new Image("Icon.png");

        //Layout
        StackPane root = new StackPane();
        root.getChildren().add(title);
        root.getChildren().add(returnButton);

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
        root.getChildren().add(scroll);

        //Scenes
        Scene scene = new Scene(root, Xwin, Ywin);

        title.toFront();
        returnButton.toFront();

        //Primary Stage
        Stage.setResizable(false);
        Stage.getIcons().add(icon);
        Stage.setScene(scene);
        Stage.setTitle("Fleet Management System");
        Stage.show();

        returnButton.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {

                System.out.println("Upload Hit");
            }});

    }


    public static void main(String[] args) {
        launch(args);

    }



}