package at.mklestil.java_copy.model;

import javafx.concurrent.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CopyTask extends Task<List<File>> {
    private List<File> listOfCopiedFiles;

    @Override
    protected List<File> call() throws Exception {
        //path
        File dir = new File("C:/Windows/Desktop");
        File[] files = dir.listFiles();
        int fileCount = files.length;

        listOfCopiedFiles = new ArrayList<File>();

        int i = 0;
        for(File file: files){
            if(file.isFile()){
                listOfCopiedFiles.add(file);
            }
        }

        return null;
    }
}
