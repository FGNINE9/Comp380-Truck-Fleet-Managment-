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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class DriverGUI extends Application {


    @Override
    public void start(Stage Stage){

        //JobDatabase data = new JobDatabase();

        Job GetJob = new Job();


        double Xwin = 800;
        double Ywin = 600;
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
        textBox.setPrefSize(175, 175);
        textBox.setText(Jobs);
        textBox.setEditable(false);
        textBox.setWrapText(true);
        textBox.setTranslateX(Xwin/45);
        textBox.setTranslateY(Ywin/9.5);

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(textBox);
        root.getChildren().add(scroll);

        //Scenes
        Scene scene = new Scene(root, Xwin, Ywin);

        title.toFront();
        ReturnB.toFront();

        //Primary Stage
        Stage.setResizable(false);
        Stage.getIcons().add(icon);
        Stage.setScene(scene);
        Stage.setTitle("Fleet Management System");
        Stage.show();

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