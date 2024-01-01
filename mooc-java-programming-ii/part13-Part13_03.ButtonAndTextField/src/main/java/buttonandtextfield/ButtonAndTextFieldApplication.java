package buttonandtextfield;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {


    @Override
    public void start(Stage window) {
        FlowPane componentGroup = new FlowPane();

        Button buttonComponent = new Button("This is a button");
        componentGroup.getChildren().add(buttonComponent);

        TextField textComponent = new TextField("Text field element");
        componentGroup.getChildren().add(textComponent);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

}
