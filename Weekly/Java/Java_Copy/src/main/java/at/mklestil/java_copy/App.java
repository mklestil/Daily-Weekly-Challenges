package at.mklestil.java_copy;

import at.mklestil.java_copy.control.MyController;
import at.mklestil.java_copy.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main Class of the application.
 * Start the JavaFX Ui.
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainView view = new MainView();
        MyController controller = new MyController(view, stage);

        stage.setTitle("Copy Desktop");
        stage.setScene(view.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}