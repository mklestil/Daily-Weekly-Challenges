package at.mklestil.java_copy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Scene
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 600,400);
        root.setPadding(new Insets(10));

        //create ProgressBar
        ProgressBar progressBar = new ProgressBar();
        ProgressIndicator progressIndicator = new ProgressIndicator();
        root.getChildren().addAll(progressBar, progressIndicator);

        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}