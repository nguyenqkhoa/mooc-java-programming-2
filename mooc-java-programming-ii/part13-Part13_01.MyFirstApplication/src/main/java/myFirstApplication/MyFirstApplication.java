package myFirstApplication;


import javafx.application.Application;
import javafx.stage.Stage;

public class MyFirstApplication extends Application {
    

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MyFirstApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("My first application");
        stage.show();

    }
}
