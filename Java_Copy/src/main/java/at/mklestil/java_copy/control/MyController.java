package at.mklestil.java_copy.control;

import at.mklestil.java_copy.model.CopyTask;
import at.mklestil.java_copy.view.MainView;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class MyController {
    private CopyTask copyTask;
    private final Stage stage;
    public MyController(MainView view, Stage stage) {
        this.stage = stage;

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
                copyTask = new CopyTask(selectedDir);


                view.getStartButton().setDisable(true);
                view.getCancleButton().setDisable(false);
                view.getProgressBar().setProgress(0);
                view.getProgressIndicator().setProgress(0);

                // Binding
                view.getProgressBar().progressProperty().unbind();
                view.getProgressBar().progressProperty().bind(copyTask.progressProperty());
                view.getProgressIndicator().progressProperty().unbind();
                view.getProgressIndicator().progressProperty().bind(copyTask.progressProperty());

                view.getStatusLabel().textProperty().unbind();
                //copy task updateMessage
                view.getStatusLabel().textProperty().bind(copyTask.messageProperty());

                // start task when succeeded
                copyTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        List<File> copiedList = copyTask.getValue();
                        System.out.println("List of copied data: " + copiedList);

                    }
                });
                //start copy task
                Thread copdyTaskThread = new Thread(copyTask);
                copdyTaskThread.start();
            }
        });

    }
}
