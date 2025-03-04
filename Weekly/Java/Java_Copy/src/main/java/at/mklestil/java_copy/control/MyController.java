package at.mklestil.java_copy.control;

import at.mklestil.java_copy.model.CopyTask;
import at.mklestil.java_copy.view.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * The logic for the start and cancel buttons is implemented here.
     * <p>
     * The start button starts a new thread of the CopyTask model for the copying process.
     * </p>
     */
    private void initialization() {
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
                    System.out.println("path null");
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
}
