package ticTacToe;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToeApplication extends Application {

    private String playerTurn;
    ArrayList<Button> buttons = new ArrayList<>();

    public TicTacToeApplication(){
        this.playerTurn = "X";
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane firstBorderPane = new BorderPane();
        GridPane thirdGridPane = new GridPane();

        Label firstText = new Label("Turn: " + this.playerTurn);
        firstText.setFont(Font.font("MonoSpaced", 40));
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                Button btn = new Button("");
                btn.setFont(Font.font("MonoSpaced", 40));
                thirdGridPane.add(btn, x, y);
                btn.setOnMouseClicked((event) -> {
                    if(btn.getText() == "") {
                        if (playerTurn == "X") {
                            System.out.println("X");
                            playerTurn = "O";
                            firstText.setText("Turn: " + this.playerTurn);
                            btn.setText("X");
                            if (checkIfWinner()) {
                                firstText.setText("The end!");
                                btn.disarm();
                            } else if (draw()){
                                firstText.setText("The end!");
                                btn.disarm();
                            }
                        } else if (playerTurn == "O") {
                            System.out.println("O");
                            playerTurn = "X";
                            firstText.setText("Turn: " + this.playerTurn);
                            btn.setText("O");
                            if (checkIfWinner()) {
                                firstText.setText("The end!");
                                btn.disarm();
                            } else if (draw()){
                                firstText.setText("The end!");
                                btn.disarm();
                            }
                        }

                        if (!(btn.getText() == "")) {

                        }
                    }

                });
                buttons.add(btn);
            }
        }

        thirdGridPane.setVgap(10);
        thirdGridPane.setHgap(10);
        thirdGridPane.setAlignment(Pos.CENTER);

        firstBorderPane.setTop(firstText);
        firstBorderPane.setCenter(thirdGridPane);

        Scene first = new Scene(firstBorderPane, 450, 450);

        stage.setScene(first);
        stage.show();
    }

    public boolean checkIfWinner() {
        return checkVerticalColumns() || checkHorizontalRows() || checkDiagonals();
    }

    public boolean checkVerticalColumns() {
        if (!buttons.get(0).getText().isEmpty()
                && ((buttons.get(0).getText().equals(buttons.get(1).getText()))
                && (buttons.get(0).getText().equals(buttons.get(2).getText())))) {
            return true;
        }
        if (!buttons.get(3).getText().isEmpty()
                && ((buttons.get(3).getText().equals(buttons.get(4).getText()))
                && (buttons.get(3).getText().equals(buttons.get(5).getText())))) {
            return true;
        }
        if (!buttons.get(6).getText().isEmpty()
                && ((buttons.get(6).getText().equals(buttons.get(7).getText()))
                && (buttons.get(6).getText().equals(buttons.get(8).getText())))) {
            return true;
        }

        return false;
    }

    public boolean checkHorizontalRows() {
        if (!buttons.get(0).getText().isEmpty()
                && ((buttons.get(0).getText().equals(buttons.get(3).getText()))
                && (buttons.get(0).getText().equals(buttons.get(6).getText())))) {
            return true;
        }
        if (!buttons.get(1).getText().isEmpty()
                && ((buttons.get(1).getText().equals(buttons.get(4).getText()))
                && (buttons.get(1).getText().equals(buttons.get(7).getText())))) {
            return true;
        }
        if (!buttons.get(2).getText().isEmpty()
                && ((buttons.get(2).getText().equals(buttons.get(5).getText()))
                && (buttons.get(2).getText().equals(buttons.get(8).getText())))) {
            return true;
        }
        return false;
    }

    public boolean checkDiagonals() {
        if (!buttons.get(0).getText().isEmpty()
                && ((buttons.get(0).getText().equals(buttons.get(4).getText()))
                && (buttons.get(0).getText().equals(buttons.get(8).getText())))) {
            return true;
        }
        if (!buttons.get(2).getText().isEmpty()
                && ((buttons.get(2).getText().equals(buttons.get(4).getText()))
                && (buttons.get(2).getText().equals(buttons.get(6).getText())))) {
            return true;
        }
        return false;
    }

    public boolean draw() {
        for (Button b : buttons) {
            if (b.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TicTacToeApplication.class);
    }

}
