package sample;

import sample.Board;
import sample.Cell;

import java.util.Vector;

public interface Visualization {
    /**
     * printScore.
     * @param player1 the firs player.
     * @param player2 the second player.
     * Print the current scores of the players.
     */
    public void printScore(char p1S, int player1,char p2S, int player2);
    /**
     * printOut.
     * @param gameBoard print this board on screen.
     */
    public void printOut(Board gameBoard);
    /**
     * printError.
     * Print this massage if the input from the player is not from the options.
     */
    public void printError();
    /**
     * printNoMoreMoves.
     * @param player the current player.
     * Print this massage if there are no more move possible moves.
     */
    public void printNoMoreMoves(char player);
    /**
     * printScore.
     * @param player the first player.
     * Print the current scores of the players.
     */
    public void printOptions(char player, Vector<Cell> moves);
    /**
     * printWinner.
     * @param winner the winner player.
     * Print out the winner of this game.
     */
    public void printWinner(char winner);
    /**
     * openScreen.
     * Print out the main menu of the game.
     */
    public void openScreen();
    /**
     * print the last move of the last player
     */
    public void printWhichMovePlayed(char player, String move);
    /**
     * this function asks the user to enter a request for the server
     */
    public void subMenuRemote();;
    /**
     *printMessage.
     * @param m the message to printout.
     */
    public void printMessage(String m);
}
