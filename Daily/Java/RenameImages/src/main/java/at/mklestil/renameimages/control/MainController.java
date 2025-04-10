package at.mklestil.renameimages.control;

import at.mklestil.renameimages.view.MainView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * MainController, Manages view and logic, takes care of event handling
 */
public class MainController {
    private MainView view;
    private List<File> listeOfFiles; //List of Files
    private ArrayList<String> nameList = new ArrayList<String>();
    private Stage stage;

    public MainController(MainView view, Stage stage){
        this.view = view;
        this.stage = stage;

        openHandler();
        exitHandler();
    }

    private void openHandler() {
        view.getOpen().setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png", "*.png"));
            listeOfFiles = fileChooser.showOpenMultipleDialog(stage);

            if (listeOfFiles != null){
                for(File file : listeOfFiles){
                    String fileName = file.getName();
                    nameList.add(fileName);

                }
                System.out.println("Size of List nameList: " + nameList.size());
            }
        });
    }

    private void exitHandler(){
        view.getExit().setOnAction(event -> {
            stage.close();
        });
    }
}
