package notifier;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {
        TextField textField = new TextField();
        Label labelText = new Label();
        Button button = new Button("Update");

        button.setOnAction((event) -> {
            labelText.setText(textField.getText());
        });

        VBox componentGroup = new VBox();
        componentGroup.setSpacing(10);
        componentGroup.getChildren().addAll(textField, button, labelText);

        Scene scene = new Scene(componentGroup);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(NotifierApplication.class);
    }

}
