package at.mklestil.renameimages;

import at.mklestil.renameimages.control.MainController;
import at.mklestil.renameimages.view.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * My Main Class, create JavaFX, start the app.
 */

public class App extends Application {

    private int width = 320;

    @Override
    public void start(Stage stage) throws IOException {
        MainView view = new MainView(width);
        MainController controller = new MainController(view, stage);
        Scene scene = new Scene(view.getRoot(), width, 240);
        stage.setTitle("Rename Images");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}