package at.mklestil.renameimages.model;

import at.mklestil.renameimages.view.MainView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RenameModel {
    private String newName;
    private String extension;

    /**
     * The RenameModel class,
     */

    public RenameModel(){

    }

    public File renameFile(File file, String baseName, int count) {
        String newName = baseName + count + ".png";
        File renamed = new File(file.getParent(), newName);
        boolean success = file.renameTo(renamed);
        if(success){
            System.out.println("Rename successful");
        }else {
            System.out.println("Rename error: " + file.getName());
        }
        return renamed;
    }

    public List<String> renamedFiles(List<File> files, String baseName){
        int count = 1;
        List<String> renamedNames = new ArrayList<>();

        /**
         * Rename files with model
         */
        for (File file : files) {
            File renamedFile = renameFile(file, baseName, count++);
            renamedNames.add(renamedFile.getName());
        }
        return renamedNames;

    }

}
