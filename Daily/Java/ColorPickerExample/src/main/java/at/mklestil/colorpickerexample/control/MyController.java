package at.mklestil.colorpickerexample;

import at.mklestil.colorpickerexample.view.MyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyController {
    private MyView view;

    public MyController(MyView view) {
        this.view = view;
        initialization();
    }

    private void initialization() {
        //Default Fill
        view.getCircle().setFill(view.getPicker().getValue());
        //on Action Fill
        view.getPicker().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.getCircle().setFill(view.getPicker().getValue());
            }
        });
    }

}