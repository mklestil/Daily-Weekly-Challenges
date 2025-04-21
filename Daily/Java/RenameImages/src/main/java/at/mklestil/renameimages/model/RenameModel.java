package at.mklestil.renameimages.model;

import at.mklestil.renameimages.view.MainView;

import java.io.File;
import java.util.List;

public class RenameModel {
    private MainView view;
    private String newName;

    public RenameModel(MainView theview){
        view = theview;
    }

    public void renameFiles(List<File> fileList) {
        System.out.println("Rename Button Handler start");
        if(view.getInputField().getText() != null && !view.getInputField().getText().isEmpty()){
            newName = view.getInputField().getText();
            System.out.println("New Name: " + newName);
        }else {
            System.out.println("Error, textfield is null");
        }

        if(fileList != null){
            int count = 0;
            for(File file: fileList){
                count++;
                //TODO: Bugfix, wrong filename, to long path
                File newFile = new File(file.getPath()+ newName + count + ".png");
                System.out.println("New File: " + newFile);
                file.renameTo(newFile);

                //Update UI
                view.getObservableList().removeAll();
                view.getObservableList().add(newFile.getName());
                view.getListView().refresh();

            }
        }
    }

}
