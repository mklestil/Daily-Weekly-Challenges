module at.mklestil.renameimages {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.mklestil.renameimages to javafx.fxml;
    exports at.mklestil.renameimages;
}