package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class loginController {
    @FXML
    private GridPane rootPane;

    @FXML
    private TextField loginInfo;

    @FXML
    private PasswordField passInfo;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
        SQLOperator sql = new SQLOperator();
        if (sql.checkLogin(loginInfo.getText(), passInfo.getText()) != -1) {
            Main.currentUserLogin = loginInfo.getText();
            loadMainMenu();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Authentication error");
            alert.setContentText("Wrong login or password. Please, try again.");
            alert.showAndWait();
        }
    }

    @FXML
    private void loadMainMenu() throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}


