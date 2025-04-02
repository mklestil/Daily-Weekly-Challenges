package at.mklestil.expandingcards.view;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class MainView {
    BorderPane root = new BorderPane();

    public MainView() {
        FlowPane containter = new FlowPane();
        StackPane titleContainer = new StackPane();
        Label title = new Label("Expanding Cards");
        title.setStyle("-fx-font-size: 25px; -fx-text-fill: black; -fx-font-weight: bold;");
        titleContainer.getChildren().addAll(title);
        containter.getChildren().addAll(
                new ExpandingCard("Card 1", "/img/1.jpg"),
                new ExpandingCard("Card 2", "/img/2.jpg"),
                new ExpandingCard("Card 3", "/img/3.jpg"),
                new ExpandingCard("Card 4", "/img/4.jpg"),
                new ExpandingCard("Card 5", "/img/5.jpg")
        );
        containter.setVgap(20);
        containter.setHgap(20);

        root.setTop(titleContainer);
        root.setCenter(containter);
    }

    public BorderPane getRoot() {
        return root;
    }
}
