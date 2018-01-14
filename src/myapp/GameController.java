package myapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private String color1;
    private String color2;
    private char player1Color;
    private char player2Color;
    private int size;
    private GameFlow game;
    private HumanP player1;
    private HumanP player2;
    @FXML
    Text winner;
    @FXML
    Text currentPlayer;
    @FXML
    Text player1text;
    @FXML
    Text player2text;
    @FXML
    Text p1Score;
    @FXML
    Text p2Score;
    @FXML
    private HBox root;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
                BufferedReader reader = new BufferedReader(new FileReader("src/settings.txt"));
                color1 = reader.readLine();
                player1Color = color1.charAt(0);
                color2 = reader.readLine();
                player2Color = color2.charAt(0);
                size = Integer.parseInt(reader.readLine());
                reader.close();
            } catch (FileNotFoundException e) {
                color1 = "Black";
                color2 = "White";
                player1Color = 'B';
                player2Color = 'W';
                size = 8;
            } catch (IOException e) {
            e.printStackTrace();
            }
        this.player1 = new HumanP(player1Color);
        this.player2 = new HumanP(player2Color);
        player1text.setText(color1 + " player score:");
        player2text.setText(color2 + " player score:");
        BoardController boardControl = new BoardController(player1Color, player2Color, color1, color2, this);
        this.game = new GameFlow(size, player1, player2, boardControl);
        boardControl.setPrefWidth(300);
        boardControl.setPrefHeight(350);
        root.getChildren().add(0, boardControl);
        this.run();
    }
    public void run() {
        String win;
        p1Score.setText(Integer.toString(this.player1.getScore()));
        p2Score.setText(Integer.toString(this.player2.getScore()));
        if(this.game.currentPlayer() == player1Color) {
            currentPlayer.setText("Current player: " + color1);
        } else {
            currentPlayer.setText("Current player: " + color2);
        }
        win = this.game.run();
        if (winner != null) {
            winner.setText(win);
            currentPlayer.setText("Game over");
        }
    }
    @FXML
    protected void endGame(){
        Stage s = (Stage)p1Score.getScene().getWindow();
        s.close();
    }
}
