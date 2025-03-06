package at.mklestil.colorpickerexample;

import at.mklestil.colorpickerexample.MyController;
import at.mklestil.colorpickerexample.view.MyView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MyView view = new MyView();
        MyController controller = new MyController(view);

        stage.setTitle("Hello World ColorPicker!");
        stage.setScene(view.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}