package sample;

import sample.Cell;

import java.util.Vector;

public class Console implements Visualization {
    public void printScore(char p1S, int player1,char p2S, int player2){}
    public void printOut(Board gameBoard){}
    public void printError(){}
    public void printNoMoreMoves(char player){}
    public void printOptions(char player, Vector<Cell> moves){}
    public void printWinner(char winner){}
    public void openScreen(){}
    public void printWhichMovePlayed(char player, String move){}
    public void subMenuRemote(){}
    public void printMessage(String m){}
}
