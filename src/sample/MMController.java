package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class MMController {
    /** Exiting the program after the exit button is pressed**/
    @FXML
    protected void exitButtonClicked() {

        Main.terminateWindow();
    }
    /** Giving the user info to the user after the button is pressed**/
    @FXML
    protected  void profileButtonClicked() throws SQLException {
        String formedMessage;
        SQLOperator sql = new SQLOperator();
        formedMessage = "Name: "+ sql.getUserName(Main.currentUserLogin) +"\nAssignments completed: "
                        + Integer.toString(sql.getUsersAssignments(sql.getUserID(Main.currentUserLogin)));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User information");
        alert.setHeaderText(null);
        alert.setContentText(formedMessage);
        alert.showAndWait();
    }
}