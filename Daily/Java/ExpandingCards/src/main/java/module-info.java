module at.mklestil.expandingcards {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.mklestil.expandingcards to javafx.fxml;
    exports at.mklestil.expandingcards;
}