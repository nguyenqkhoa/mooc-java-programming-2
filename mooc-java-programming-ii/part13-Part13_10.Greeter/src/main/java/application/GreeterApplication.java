package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        System.out.println("Hellow world! :3");
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label instructionText = new Label("Enter your name and start.");
        TextField textField = new TextField("");
        Button startButton = new Button("Start");

        GridPane gridPane = new GridPane();
        gridPane.add(instructionText, 0 , 0);
        gridPane.add(textField, 0 , 1);
        gridPane.add(startButton, 0 , 2);

        // 1.3 styling the layout
        gridPane.setPrefSize(300, 180);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        Scene firstScene = new Scene(gridPane);

        Label welcomeText = new Label("Welcome, this is the beginning!");

        Label welcomeLabel = new Label("");

        GridPane welcomeLayout = new GridPane();
        welcomeLayout.add(welcomeLabel, 0, 0);

        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.setAlignment(Pos.CENTER);
        welcomeLayout.setVgap(10);
        welcomeLayout.setHgap(10);
        welcomeLayout.setPadding(new Insets(20, 20, 20, 20));

        Scene welcomeView = new Scene(welcomeLayout);

        startButton.setOnAction((event) -> {
                    String name = textField.getText();
                    welcomeLabel.setText("Welcome " + name + "!");
                    stage.setScene(welcomeView);
                });

        stage.setScene(firstScene);
        stage.show();

    }
}
