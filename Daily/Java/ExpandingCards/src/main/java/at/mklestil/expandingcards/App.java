package at.mklestil.expandingcards;

import at.mklestil.expandingcards.control.MainController;
import at.mklestil.expandingcards.view.MainView;
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
        Scene scene = new Scene(view.getRoot(), 800, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}