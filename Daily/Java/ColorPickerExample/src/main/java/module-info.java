module at.mklestil.colorpickerexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.mklestil.colorpickerexample to javafx.fxml;
    exports at.mklestil.colorpickerexample;
}