package at.mklestil.java_copy.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class MainView {
    private FlowPane root;

    private Scene scene;

    private final Label infoLabel = new Label("copie items ...");
    private final ProgressBar progressBar = new ProgressBar();
    private final ProgressIndicator progressIndicator = new ProgressIndicator();
    private final Button startButton = new Button("Start");
    private final Button cancleButton = new Button("Cancle");
    private final Label statusLabel = new Label();
    ListView<String> listView = new ListView<String>();

    public MainView() {
        //Scene
        root = new FlowPane();
        scene = new Scene(root, 600,400);
        root.setPadding(new Insets(10));
        root.setVgap(20);
        root.setHgap(20);

        //add elemets to root
        root.getChildren().addAll(infoLabel, progressBar, progressIndicator, statusLabel, startButton, cancleButton, listView);
    }

    public FlowPane getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getCancleButton() {
        return cancleButton;
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }
}
