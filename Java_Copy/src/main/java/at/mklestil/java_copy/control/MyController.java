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

public class MyController {
    private final Stage stage;
    private  CopyTask copyTaskModel;
    private ArrayList<String> copyFilesAsString = new ArrayList<>();
    public MyController(MainView view, Stage stage) {
        this.stage = stage;
        copyTaskModel = new CopyTask();

        view.getStartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //chose path
                DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDir = directoryChooser.showDialog(stage);
                if (selectedDir == null){
                    System.out.println("path null");
                    return;
                }
                copyTaskModel.setSelectedDir(selectedDir);

                view.getStartButton().setDisable(true);
                view.getCancleButton().setDisable(false);
                view.getProgressBar().setProgress(0);
                view.getProgressIndicator().setProgress(0);

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
        });

    }
}
