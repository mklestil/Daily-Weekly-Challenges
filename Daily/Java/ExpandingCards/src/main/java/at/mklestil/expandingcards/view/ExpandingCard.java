package at.mklestil.expandingcards.view;

import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.InputStream;

public class ExpandingCard extends StackPane {
    private final Rectangle background;
    private final ImageView imageView = new ImageView();
    private final Label label;
    private boolean expanded = false;

    public ExpandingCard(String text, String imagePath) {
        //Background
        background = new Rectangle(100, 200); //Draw a rectangle
        background.setArcWidth(20); // round corners
        background.setArcWidth(20);
        background.setFill(Color.LIGHTGREEN); // If the image does not load

        // Add Image
        loadImage(imagePath);
        imageView.setFitWidth(100);
        imageView.setFitHeight(200);
        imageView.setClip(background); // Adopt rounded corners

        //Text
        label = new Label(text);
        label.setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold;");

        this.setOnMouseClicked(event ->  toggleExpand());

        this.getChildren().addAll(imageView, label);

    }

    public void loadImage(String imagePath){
        InputStream inputStream = getClass().getResourceAsStream(imagePath);
        if(inputStream != null){
            //Check Image is correct
            Image image = new Image(inputStream);
            if(!image.isError()){
                imageView.setImage(image);
            }else {
                System.out.println("Error loading image");
            }
        }else{
            System.out.println("Image file not found.");
        }
    }

    private void toggleExpand() {
        if(expanded){
            imageView.setFitWidth(100);
            background.setWidth(100);
            expanded = false;
        }else{
            imageView.setFitWidth(300);
            background.setWidth(300);
            expanded = true;
        }
    }
}
