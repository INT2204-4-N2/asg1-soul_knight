package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import java.awt.event.ActionEvent;

//import java.awt.event.ActionEvent;

//import java.awt.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dictionary");
        primaryStage.setScene(new Scene(root, 900, 750));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

