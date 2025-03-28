package at.mklestil.expandingcards.view;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView {
    VBox root = new VBox();

    public MainView() {
        FlowPane containter = new FlowPane();
        Label title = new Label("Expanding Cards");
        containter.getChildren().addAll(new ExpandingCard("Card 1"),
                new ExpandingCard("Card 2"),
                new ExpandingCard("Card 3"),
                new ExpandingCard("Card 4"));

        root.getChildren().addAll(title, containter);
    }

    public VBox getRoot() {
        return root;
    }
}
