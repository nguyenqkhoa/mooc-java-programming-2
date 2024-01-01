package textstatistics;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication extends Application {

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox label = new HBox();
        label.setSpacing(10);
        Label letters = new Label();
        Label wordCount = new Label();
        Label longestWords = new Label();
        label.getChildren().add(letters);
        label.getChildren().add(wordCount);
        label.getChildren().add(longestWords);

        TextArea textArea = new TextArea("");

        textArea.textProperty().addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            letters.setText("Letters: " + characters);
            wordCount.setText("Words: " + words);
            longestWords.setText("The longest word is: " + longest);

        });

        layout.setBottom(label);

        layout.setCenter(textArea);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TextStatisticsApplication.class);
    }


}
