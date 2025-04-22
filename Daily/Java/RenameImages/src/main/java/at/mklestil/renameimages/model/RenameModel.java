package at.mklestil.renameimages.model;

import at.mklestil.renameimages.view.MainView;

import java.io.File;
import java.util.List;

public class RenameModel {
    private MainView view;
    private String newName;
    private String extension;

    /**
     * The RenameModel class,
     * @param theview
     */

    public RenameModel(MainView theview){
        view = theview;
    }

    /**
     * Renames a list of files by applying a new base name and appending a running number.
     * <p>
     * Example: if newName is "Image", files will be renamed to "Image1.png", "Image2.png", etc.
     * Existing extensions are preserved (currently fixed to .png).
     *
     * @param fileList the list of files to rename
     */
    public void renameFiles(List<File> fileList) {
        /**
         * Check input textfield
         * */
        if(view.getInputField().getText() != null && !view.getInputField().getText().isEmpty()){
            newName = view.getInputField().getText();
            System.out.println("New Name: " + newName);
        }else {
            System.out.println("Error, textfield is null");
        }

        /**
         * Create new name and rename files, update List
         */
        if(fileList != null && !fileList.isEmpty()){
            int count = 0;
            view.getObservableList().clear(); //clear List

            for(File file: fileList){
                // New File Name
                count++;
                File newFile = new File(file.getParent(),  newName + count + ".png");

                //Check and rename Files
                boolean success = file.renameTo(newFile);
                if(success){
                    System.out.println("Rename to: " + newFile);
                    //Update List
                    view.getObservableList().add(newFile.getName());
                }else {
                    System.out.println("Failed to rename: " + file.getName());
                }

                //Update UI
                view.getListView().refresh();

            }
        }
    }

}
