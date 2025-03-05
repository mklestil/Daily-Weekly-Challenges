package at.mklestil.java_copy.control;

import at.mklestil.java_copy.model.CopyTask;
import at.mklestil.java_copy.view.ErrorHandler;
import at.mklestil.java_copy.view.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;

/**
 * The Controller class, to handel the input from user.
 */
public class MyController {
    private final Stage stage;
    private final CopyTask copyTaskModel;
    private ArrayList<String> copyFilesAsString = new ArrayList<>();
    private final MainView view;


    /**
     * Creates a new instance of the controller and starts the initialization.
     * <p>
     * The controller manages the user interactions of the application.
     * It takes the reference to the main view ({@link MainView}) and the main stage ({@link Stage}) and then calls the initialization method.
     * </p>
     *
     * @param view The main view of the application, which contains UI components.
     * @param stage The main stage of the application, on which the UI is displayed.
     */
    public MyController(MainView view, Stage stage) {
        this.stage = stage;
        copyTaskModel = new CopyTask();
        this.view = view;

        initialization();


    }


    private void initialization() {
        initializationStartBtnEvent();
        initializationCancleBtnEvent();
        initializationListViewEvent();

    }



    /**
     * The logic for the start buttons is implemented here.
     * <p>
     * The start button starts a new thread of the CopyTask model for the copying process.
     * </p>
     */
    private void initializationStartBtnEvent(){
        // Start Button
        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Buttons and Progress
                view.getStartButton().setDisable(true);
                view.getCancleButton().setDisable(false);
                view.getProgressBar().setProgress(0);
                view.getProgressIndicator().setProgress(0);

                //chose path
                DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDir = directoryChooser.showDialog(stage);
                if (selectedDir == null){
                    ErrorHandler.showError("selected path is null");
                    return;
                }
                copyTaskModel.setSelectedDir(selectedDir);

                // Binding
                view.getProgressBar().progressProperty().unbind();
                view.getProgressBar().progressProperty().bind(copyTaskModel.progressProperty());
                view.getProgressIndicator().progressProperty().unbind();
                view.getProgressIndicator().progressProperty().bind(copyTaskModel.progressProperty());

                view.getStatusLabel().textProperty().unbind();
                //copy task updateMessage
                view.getStatusLabel().textProperty().bind(copyTaskModel.messageProperty());

                // start task when succeeded
                copyTaskModel.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        List<File> copiedList = copyTaskModel.getValue();
                        System.out.println("List of copied data: " + copiedList);
                        //Update ListView after copy
                        for(File file: copyTaskModel.getListOfCopiedFiles()){
                            copyFilesAsString.add(file.toString());
                        }
                        // create observableList, add to view
                        ObservableList<String> observableList = FXCollections.observableArrayList(copyFilesAsString);
                        view.getListView().setItems(observableList);
                    }
                });

                //start copy task
                Thread copdyTaskThread = new Thread(copyTaskModel);
                copdyTaskThread.start();
            }
        }); // End Start Button

    }

    /**
     * The logic for the cancle buttons is implemented here.
     * <p>
     * The cancle button cancelled the thread of the CopyTask model for the copying process.
     * </p>
     */
    private void initializationCancleBtnEvent(){
        // Cancle Button
        view.getCancleButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.getStartButton().setDisable(true);
                view.getCancleButton().setDisable(false);

                copyTaskModel.addEventHandler(WorkerStateEvent.WORKER_STATE_CANCELLED, new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        for (File file : copyTaskModel.getListOfCopiedFiles()) {
                            copyFilesAsString.add(file.toString());
                        }
                        copyFilesAsString.add("Copy Task cancled!");
                        // create observableList, add to view
                        ObservableList<String> observableList = FXCollections.observableArrayList(copyFilesAsString);
                        view.getListView().setItems(observableList);
                    }
                });

                // Cancle task
                copyTaskModel.cancel(true);
            }
        });
    }

    /**
     * The logic for the ListView is implemented here.
     * <p>
     * Make the ListView Elements clickable.
     * </p>
     */
    private void initializationListViewEvent() {
        view.getListView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String filename = view.getListView().getSelectionModel().getSelectedItem();
                System.out.println(filename);
                File file = new File(filename);

                //use awt for desktop
                if(!file.exists()){
                    ErrorHandler.showError("File does not exist!");
                }
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    ErrorHandler.showError("Desktop function is not supported.");
                }

            }
        });
    }
}
