package at.mklestil.java_copy.model;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * The CopyTask class, contains the logic for copy data in the array.
 * Hard code path to desktop, on windows systems.
 */
public class CopyTask extends Task<List<File>> {
    private List<File> listOfCopiedFiles;

    private File selectedDir;

    public CopyTask() {

    }


    @Override
    protected List<File> call() throws Exception {
        if(selectedDir == null){
            System.out.println("Error selectedDir is null");
        }else{
            //path
            File dir = selectedDir;
            // list of files in path
            File[] files = dir.getAbsoluteFile().listFiles();
            //count of files
            int fileCount = files.length;

            listOfCopiedFiles = new ArrayList<File>();

            int i = 0;
            for(File file: files){
                //check file
                if(file.isFile()){
                    copy(file);
                    listOfCopiedFiles.add(file);
                }
                i++;
                // Update Progress 0 to FileCount
                this.updateProgress(i, fileCount);
            }
        }

        return listOfCopiedFiles;
    }

    /**
     * Work with task to give updateMessage with the path of the file and wait 500.
     * @param file
     * @throws Exception
     */
    private void copy(File file) throws Exception{
        this.updateMessage("Copy: " + file.getAbsolutePath());
        Thread.sleep(500);

    }

    public void setSelectedDir(File selectedDir) {
        this.selectedDir = selectedDir;
    }

    public List<File> getListOfCopiedFiles() {
        return listOfCopiedFiles;
    }
}
