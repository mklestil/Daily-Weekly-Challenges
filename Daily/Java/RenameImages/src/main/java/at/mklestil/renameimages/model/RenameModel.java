package at.mklestil.renameimages.model;

import at.mklestil.renameimages.view.MainView;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RenameModel {
    private MainView view;
    private String newName;
    private List<File> fileList;

    public RenameModel(MainView theview, List<File> fileList){
        view = theview;
        this.fileList = fileList;

        renameButtonHandler();
    }

    private void renameButtonHandler() {
        view.getButtonRename().setOnAction(event -> {
            if(view.getInputField().getText() != null && !view.getInputField().getText().isEmpty()){
                newName = view.getInputField().getText();
            }else {
                System.out.println("Error, textfield is null");
            }

            if(fileList != null){
                int count = 0;
                for(File file: fileList){
                    count++;
                    System.out.println(file.getName());
                }
            }
        });
    }

}
