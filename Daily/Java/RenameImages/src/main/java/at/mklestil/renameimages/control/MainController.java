package at.mklestil.renameimages.control;

import at.mklestil.renameimages.model.RenameModel;
import at.mklestil.renameimages.view.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
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
    private List<File> listOfFiles; //List of Files
    private Stage stage;
    private RenameModel renameModel;

    public MainController(MainView view, Stage stage){
        this.view = view;
        this.stage = stage;
        renameModel = new RenameModel();

        registerEventHandlers();
    }

    private void registerEventHandlers() {
        openHandler();
        exitHandler();
        renameHandler();
    }

    private void renameHandler() {
        view.getButtonRename().setOnAction(event -> {
            // rename Files and update UI
            updateUI(renameModel.renamedFiles(listOfFiles, getRenameInput()));
        });
    }

    private void openHandler() {
        view.getOpen().setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png", "*.png"));
            listOfFiles = fileChooser.showOpenMultipleDialog(stage);

            if (listOfFiles != null) {
                // Background task to avoid blocking the UI
                Task<List<String>> loadFileNamesTask = new Task<>() {
                    @Override
                    protected List<String> call() {
                        List<String> nameList = new ArrayList<>();
                        for (int i = 0; i < listOfFiles.size(); i++) {
                            nameList.add(listOfFiles.get(i).getName());
                            //update progress
                            updateProgress(i+ 1 , listOfFiles.size());
                        }
                        return nameList;
                    }
                };

                // When task finished: Update UI
                loadFileNamesTask.setOnSucceeded(workerStateEvent -> {
                    List<String> nameList = loadFileNamesTask.getValue();
                    view.getObservableList().setAll(nameList);
                    System.out.println("Size of List nameList: " + nameList.size());
                    view.getListView().refresh(); // Optional
                    view.getListView().setVisible(true);
                });

                // Error Handling
                loadFileNamesTask.setOnFailed(workerStateEvent -> {
                    Throwable ex = loadFileNamesTask.getException();
                    ex.printStackTrace();
                });

                // Task start & progressbar binding
                view.getProgressBar().progressProperty().bind(loadFileNamesTask.progressProperty());
                new Thread(loadFileNamesTask).start();
            }
        });
    }

    private String getRenameInput(){
        /**
         * Check input textfield
         * */
        String inputName = view.getInputField().getText();
        if(inputName == null || inputName.isEmpty()){
            System.out.println("Error: input is null");
            inputName = "Error";
        }
        return inputName;
    }

    /**
     * Update UI
     * @param renamedNames
     */
    private void updateUI(List<String> renamedNames){
        view.getObservableList().setAll(renamedNames);
        view.getListView().refresh();
    }

    private void exitHandler(){
        view.getExit().setOnAction(event -> {
            stage.close();
        });
    }
}
