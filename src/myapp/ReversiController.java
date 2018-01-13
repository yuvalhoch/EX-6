package myapp;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ReversiController {
    @FXML
    private Text messageText;
    @FXML
    ChoiceBox<String> choiceBox1;
    @FXML
    ChoiceBox<String> choiceBox2;
    @FXML
    ChoiceBox<String> choiceBox3;
    @FXML
    protected void signIn() {
        String choice1 = choiceBox1.getSelectionModel().getSelectedItem();
        String choice2 = choiceBox1.getSelectionModel().getSelectedItem();
        String choice3 = choiceBox1.getSelectionModel().getSelectedItem();
        if (choice1 == choice2) {
            messageText.setText("You need to choose different colors!");
            messageText.setFill(Color.BLUE);
        }
    }
    @FXML
    protected void processExit(){}
}