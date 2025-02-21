package at.mklestil.java_copy.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;

public class MainView {
    private FlowPane root;

    private Scene scene;

    private final Label infoLabel = new Label("copie items ...");
    private final ProgressBar progressBar = new ProgressBar();
    private final ProgressIndicator progressIndicator = new ProgressIndicator();
    private final Button startButton = new Button("Start");
    private final Button cancleButton = new Button("Cancle");

    public MainView() {
        //Scene
        root = new FlowPane();
        scene = new Scene(root, 600,400);
        root.setPadding(new Insets(10));

        //create ProgressBar

        root.getChildren().addAll(progressBar, progressIndicator);
    }

    public FlowPane getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }
}
