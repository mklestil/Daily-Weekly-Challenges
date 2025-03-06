package at.mklestil.java_copy;

import at.mklestil.java_copy.control.MyController;
import at.mklestil.java_copy.view.MainView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;


/**
 * The Main Class of the application.
 * Start the JavaFX Ui.
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainView view = new MainView();
        MyController controller = new MyController(view, stage);

        //set Icon, title
        setMyIcon(stage);

        stage.setTitle("Copy Desktop");
        stage.setScene(view.getScene());
        stage.show();
    }

    /**
     * Puts the icon on the stage if the input stream is working.
     * @param stage
     */
    public void setMyIcon(Stage stage){
        //Set Icon and check
        InputStream iconStream = getClass().getResourceAsStream("/images/Icon.png");
        if(iconStream != null){
            Image icon = new Image(iconStream);
            if (!icon.isError()) {
                stage.getIcons().add(icon);
            } else {
                System.out.println("Error loading icon.");
            }
        } else {
            System.out.println("Icon file not found.");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}