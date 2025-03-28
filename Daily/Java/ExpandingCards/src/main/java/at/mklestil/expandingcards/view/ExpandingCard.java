package at.mklestil.expandingcards.view;

import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ExpandingCard extends StackPane {
    private final Rectangle background;
    private final Label label;
    private boolean expanded = false;

    public ExpandingCard(String text) {
        //Background
        background = new Rectangle(100, 200, Color.LIGHTGREEN);
        background.setArcWidth(20);
        background.setArcWidth(20);

        //Text
        label = new Label(text);

        this.setOnMouseClicked(event ->  toggleExpand());

        this.getChildren().addAll(background, label);

    }

    private void toggleExpand() {
        if(expanded){
            background.setWidth(100);
            expanded = false;
        }else{
            background.setWidth(300);
            expanded = true;
        }
    }
}
