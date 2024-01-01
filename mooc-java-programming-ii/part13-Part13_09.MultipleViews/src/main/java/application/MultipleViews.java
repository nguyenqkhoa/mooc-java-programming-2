package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane firstBorderPane = new BorderPane();
        VBox secondVBox = new VBox();
        GridPane thirdGridPane = new GridPane();

        Label firstText = new Label("First view!");
        Button forth = new Button("To the second view!");
        firstBorderPane.setTop(firstText);
        firstBorderPane.setCenter(forth);

        Button secondForth = new Button("To the third view!");
        Label secondText = new Label("Second view!");
        secondVBox.getChildren().add(secondForth);
        secondVBox.getChildren().add(secondText);

        Button thirdForth = new Button("To the first view!");
        Label thirdText = new Label("Third view!");
        thirdGridPane.add(thirdText, 0, 0);
        thirdGridPane.add(thirdForth, 1, 1);


        Scene first = new Scene(firstBorderPane);
        Scene second = new Scene(secondVBox);
        Scene third = new Scene(thirdGridPane);

        forth.setOnAction((event) -> {
            stage.setScene(second);
        });

        secondForth.setOnAction((event) -> {
            stage.setScene(third);
        });

        thirdForth.setOnAction((event) -> {
            stage.setScene(first);
        });

        stage.setScene(first);
        stage.show();
    }
}
