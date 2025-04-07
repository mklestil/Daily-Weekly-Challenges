package at.mklestil.renameimages.view;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainView {
    private HBox root;
    private ListView<String> listView; //UI
    private List<String> list; //Names of Data
    private ObservableList<String> observableList;
    private String newFileName;

    public MainView(){
        VBox leftUI = createMyUI();
        root = new HBox();
        root.getChildren().addAll(leftUI);

    }

    private VBox createMyUI() {
        Label label = new Label("New Name: ");
        TextField inputField = new TextField();
        Button button = new Button("Rename");
        VBox leftUI = new VBox();
        leftUI.setAlignment(Pos.CENTER);
        leftUI.getChildren().addAll(label,inputField,button);
        return  leftUI;
    }

    public HBox getRoot(){
        return root;
    }
}
