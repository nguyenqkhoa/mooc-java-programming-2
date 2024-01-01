package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();
        int cloneWidth = (int) (sourceImage.getWidth() / 2);
        int cloneHeight = (int) (sourceImage.getHeight() / 2);

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < cloneHeight) {
            int xCoordinate = 0;
            while (xCoordinate < cloneWidth) {

                Color color = imageReader.getColor(xCoordinate * 2, yCoordinate * 2);

                double notRed = 1.0 - color.getRed();
                double notGreen = 1.0 - color.getGreen();
                double notBlue = 1.0 - color.getBlue();
                double opacity = color.getOpacity();

                Color newColor = new Color(notRed, notGreen, notBlue, opacity);

                imageWriter.setColor(xCoordinate, yCoordinate, newColor);
                imageWriter.setColor(xCoordinate + cloneWidth, yCoordinate, newColor);
                imageWriter.setColor(xCoordinate, yCoordinate + cloneHeight, newColor);
                imageWriter.setColor(xCoordinate + cloneWidth, yCoordinate + cloneHeight, newColor);

                xCoordinate++;
            }
            yCoordinate++;
        }

        ImageView image = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(image);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
