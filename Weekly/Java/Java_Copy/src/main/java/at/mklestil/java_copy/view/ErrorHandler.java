package at.mklestil.java_copy.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class ErrorHandler {
    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error has occurred!");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
