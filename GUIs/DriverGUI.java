package GUIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


public class DriverGUI extends Application {


    @Override
    public void start(Stage Stage){

        Job GetJob = new Job();

        Stage.show();
        double Xwin = 1920;
        double Ywin = 1080;
        String Jobs = GetJob.printJob();


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

        TextArea textBox= new TextArea();
        textBox.setText(Jobs);
        textBox.setEditable(false);

        ScrollPane scroll = new ScrollPane();
        scroll.setTranslateX(Xwin/100);
        scroll.setTranslateY(Ywin/100);
        scroll.setPrefViewportHeight(Xwin/2.3);
        scroll.setPannable(true);
        scroll.setContent(textBox);
        root.getChildren().add(scroll);

        //Scenes
        Scene scene = new Scene(root, Xwin, Ywin);


        //Primary Stage
        Stage.setResizable(false);
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




}