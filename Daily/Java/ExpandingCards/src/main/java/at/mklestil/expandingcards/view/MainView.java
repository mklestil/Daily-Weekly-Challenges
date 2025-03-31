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
        containter.getChildren().addAll(
                new ExpandingCard("Card 1", "/img/1.jpg"),
                new ExpandingCard("Card 2", "/img/2.jpg"),
                new ExpandingCard("Card 3", "/img/3.jpg"),
                new ExpandingCard("Card 4", "/img/4.jpg"),
                new ExpandingCard("Card 5", "/img/5.jpg")
        );

        root.getChildren().addAll(title, containter);
    }

    public VBox getRoot() {
        return root;
    }
}
