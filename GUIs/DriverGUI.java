package GUIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class DriverGUI extends Application {


    @Override
    public void start(Stage Stage){

        Job GetJob = new Job();

        Stage.setMaximized(true);
        Stage.show();
        double Xwin = 1280;
        double Ywin = 720;
        String Name = "";


        //Labels
        Label title = new Label("Pending Jobs: \n\n");
        title.setTranslateX(-Xwin/2.3);
        title.setTranslateY(-Ywin/2.3);

        // Buttons
        Button ReturnB = new Button("Return");
        ReturnB.setTranslateX(-Xwin/2.3);
        ReturnB.setTranslateY(Ywin/2.3);

        //Images
        Image icon = new Image("Icon.png");

        //Layout
        StackPane root = new StackPane();
        root.getChildren().add(title);
        root.getChildren().add(ReturnB);

        //Scenes
        Scene scene = new Scene(root, Xwin, Ywin);

        //Primary Stage
        Stage.getIcons().add(icon);
        Stage.setScene(scene);
        Stage.setTitle("Fleet Management System");

        ReturnB.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event) {

                System.out.println("Upload Hit");
            }});

    }


    public static void main(String[] args) {

        launch(args);

    }

    public static String getName(int ID){

        return "None";
    }




}