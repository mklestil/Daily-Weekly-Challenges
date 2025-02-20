module at.mklestil.java_copy {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.mklestil.java_copy to javafx.fxml;
    exports at.mklestil.java_copy;
}