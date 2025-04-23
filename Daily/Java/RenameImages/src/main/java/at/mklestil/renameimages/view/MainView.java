package at.mklestil.renameimages.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

/**
 * My MainView class, create the view, UI, Scene in JavaFX
 */

public class MainView {
    private BorderPane root;
    private ListView<String> listView; //UI

    private ObservableList<String> observableList = FXCollections.observableArrayList();
    private String newFileName;
    private final Menu menu = new Menu("File");
    private MenuItem open;
    private MenuItem exit;
    private TextField inputField;
    private Button buttonRename;
    private final ProgressBar progressBar = new ProgressBar(0);

    public MainView(int width){
        VBox leftUI = createMyUI();
        VBox listUI = createListUI();
        root = new BorderPane();

        root.setLeft(leftUI);
        root.setRight(listUI);
        root.setTop(createMyMenu());
        root.setBottom(progressBar);
        progressBar.setPrefWidth(width);


    }

    /**
     * Create the right UI, with the ListView
     * @return
     */
    private VBox createListUI() {
        VBox listVBox = new VBox();
        listView = new ListView<String>();
        listView.setItems(observableList);
        listVBox.getChildren().addAll(listView);
        return listVBox;
    }

    /**
     * Create the Menu
     * @return
     */
    private MenuBar createMyMenu() {
        MenuBar menuBar = new MenuBar();
         open = new MenuItem("Öffnen");
         exit = new MenuItem("Exit");
        menuBar.getMenus().add(menu);
        menu.getItems().addAll(open, exit);

        return menuBar;
    }

    /**
     * Create the left UI, Buttons, Input to rename the data
     * @return
     */
    private VBox createMyUI() {
        Label label = new Label("New Name: ");
        inputField = new TextField();
        VBox leftUI = new VBox();
        buttonRename = new Button("Rename");
        leftUI.setAlignment(Pos.CENTER);
        leftUI.getChildren().addAll(label,inputField,buttonRename);
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

    public Button getButtonRename() {
        return buttonRename;
    }

    public TextField getInputField() {
        return inputField;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public ObservableList<String> getObservableList() {
        return observableList;
    }
    public ProgressBar getProgressBar(){
        return progressBar;
    }
}
