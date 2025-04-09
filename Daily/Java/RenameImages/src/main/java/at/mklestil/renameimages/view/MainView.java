package at.mklestil.renameimages.view;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MainView {
    private BorderPane root;
    private ListView<String> listView; //UI

    private ObservableList<String> observableList;
    private String newFileName;
    private final Menu menu = new Menu("File");
    private MenuItem open;
    private MenuItem exit;

    public MainView(){
        VBox leftUI = createMyUI();
        root = new BorderPane();

        root.setLeft(leftUI);

        root.setTop(createMyMenu());

    }

    private MenuBar createMyMenu() {
        MenuBar menuBar = new MenuBar();
         open = new MenuItem("Öffnen");
         exit = new MenuItem("Exit");
        menuBar.getMenus().add(menu);
        menu.getItems().addAll(open, exit);

        return menuBar;
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

    public BorderPane getRoot(){
        return root;
    }

    public Menu getMenu() {
        return menu;
    }

    public MenuItem getOpen() {
        return open;
    }

    public MenuItem getExit() {
        return exit;
    }
}
