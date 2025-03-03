/**
 * The main module of the application.
 * <p>
 * It contains the controls and the ui with javafx.
 * </p>
 */

module at.mklestil.java_copy {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.mklestil.java_copy to javafx.fxml;
    exports at.mklestil.java_copy;
}