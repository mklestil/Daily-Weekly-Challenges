package at.mklestil.renameimages;

import at.mklestil.renameimages.control.MainController;
import at.mklestil.renameimages.view.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainView view = new MainView();
        MainController controller = new MainController(view);
        Scene scene = new Scene(view.getRoot(), 320, 240);
        stage.setTitle("Rename Images");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}