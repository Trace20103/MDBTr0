package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Controller {
    @FXML
    private Text actiontarget;

    @FXML
    private TextField loginInfo;

    @FXML
    private PasswordField passInfo;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws SQLException {
        actiontarget.setText("Wrong login or password");
        loginInfo.getText();
        passInfo.getText();
        System.out.println(passInfo.getText());
        SQLOperator sql = new SQLOperator();
        sql.testConnection("root","keklol123");
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mongot?user=root&password=keklol123&serverTimezone=UTC");
    }
}

