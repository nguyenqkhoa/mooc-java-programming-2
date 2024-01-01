package buttonandlabel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application{

    @Override
    public void start(Stage window) {
        FlowPane componentGroup = new FlowPane();

        Label textComponent = new Label("Text element");
        componentGroup.getChildren().add(textComponent);

        Button buttonComponent = new Button("This is a button");
        componentGroup.getChildren().add(buttonComponent);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
