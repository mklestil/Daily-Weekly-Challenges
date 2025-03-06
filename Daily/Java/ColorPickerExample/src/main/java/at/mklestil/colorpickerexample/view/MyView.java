package at.mklestil.colorpickerexample.view;

import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.concurrent.Flow;

public class MyView {
    private Scene scene;
    private Circle circle = new Circle(100);
    private ColorPicker picker = new ColorPicker();

    public MyView() {
        VBox root = new VBox();
        FlowPane mainPane = new FlowPane();
        scene = new Scene(root, 600,400);
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        picker.setValue(Color.GREEN);
        Label infoLabel = new Label("A small Example for ColorPicker in JavaFX");
        mainPane.getChildren().addAll(picker, circle);
        root.getChildren().addAll(infoLabel, mainPane);
    }

    public Scene getScene() {
        return scene;
    }

    public Circle getCircle() {
        return circle;
    }

    public ColorPicker getPicker() {
        return picker;
    }
}
