package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.Channel;
import java.sql.Statement;

public class Main extends Application {
    public static  String currentUserLogin;
    private static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("MongoDB Trainer");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 350, 270));
        primaryStage.show();

        SQLOperator sql = new SQLOperator();
        if(sql.testConnection("root", "keklol123") == -1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Connection error");
            alert.setContentText("Could not connect to the database. Please, wait until the servers respond");
            alert.showAndWait();
            primaryStage.close();
            }
    }

    public static void terminateWindow(){
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
