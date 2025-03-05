package at.mklestil.java_copy.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class ErrorHandler {
    public static void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fehler");
        alert.setHeaderText("Ein Fehler ist aufgetreten!");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
