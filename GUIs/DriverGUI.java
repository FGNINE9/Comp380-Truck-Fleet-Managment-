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

        Stage.setMaximized(true);
        Stage.show();
        double Ywin = Stage.getY();
        double Xwin = Stage.getX();
        String Name = "";


        //Labels
        Label title = new Label("Welcome To fleet Manager" + Name);
        title.setTranslateY(-Ywin/3);

        // Buttons
        Button Upload = new Button("Upload");
        Upload.setTranslateX(-Xwin/4);

        //Images
        Image icon = new Image("Icon.png");

        //Layout
        StackPane root = new StackPane();
        root.getChildren().add(title);
        root.getChildren().add(Upload);

        //Scenes
        Scene scene = new Scene(root);

        //Primary Stage
        Stage.getIcons().add(icon);
        Stage.setScene(scene);
        Stage.setTitle("Fleet Management System");

        Upload.setOnAction(new EventHandler<ActionEvent>()
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