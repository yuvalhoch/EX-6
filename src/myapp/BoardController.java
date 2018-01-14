package myapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by shaytzir on 13/01/2018.
 */
public class BoardController extends GridPane {
    private ArrayList<ArrayList<Character>> matrix;
    private String color1;
    private String color2;
    private char player1Color;
    private char player2Color;
    private Vector<Button> options;
    private int cellHeight;
    private int cellWidth;
    private String move;
    private GameController gameControl;
    public BoardController(char first, char second, String color1, String color2, GameController gameControl) {
        this.options = new Vector<>();
        this.player1Color = first;
        this.player2Color = second;
        this.color1 = color1;
        this.color2 = color2;
        this.gameControl = gameControl;
        //this.board = new Board(size, size, player1Color, player2Color);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    public void draw(Board board) {
        this.matrix = board.getMatrix();
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();
        this.cellHeight = height / matrix.size();
        this.cellWidth = width / matrix.get(0).size();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                Rectangle r = new Rectangle(cellWidth, cellHeight, Color.WHITE);
                r.setStroke(Color.BLACK);
                this.add(r, j, i);
                Circle c = new Circle();
                if (matrix.get(i).get(j).equals(player1Color)) {
                    c.setCenterX(i);
                    c.setCenterY(j);
                    c.setRadius(cellWidth/2);
                    if (color1.toUpperCase().equals("WHITE")) {
                        c.setStroke(Color.BLACK);
                    }
                    c.setFill(Paint.valueOf(color1.toUpperCase()));
                    this.add(c, j, i);
                } else if (matrix.get(i).get(j).equals(player2Color)) {
                    c.setCenterX(i);
                    c.setCenterY(j);
                    c.setRadius(cellWidth/2);
                    if (color2.toUpperCase().equals("WHITE")) {
                        c.setStroke(Color.BLACK);
                    }
                    c.setFill(Paint.valueOf(color2.toUpperCase()));
                    this.add(c, j, i);
                }
            }
        }
    }
    public void getNextMove(Board board_, Vector<Cell> movesForCurrentPlayer, char now, ReversiRules rules) {
        this.options.clear();
        this.options = new Vector<>();
        for (int i = 0; i < movesForCurrentPlayer.size(); i++) {
            final int moveX;
            final int moveY;
            Cell c = movesForCurrentPlayer.get(i);
            Pane button = new Pane();
            Rectangle rec = new Rectangle(this.cellWidth, this.cellHeight, Color.GRAY);
            button.setShape(rec);
            this.add(rec, c.y, c.x);
            this.add(button, c.y, c.x);
            button.setOnMouseClicked(event1 -> {
                rules.doAfterClick(c.x, c.y);
                this.gameControl.run();
            });
        }
    }

    public String getColor1() {
        return color1;
    }
    public String getColor2() {
        return color2;
    }
}
