package sample;

import sample.Cell;

import java.util.Vector;

public class Console implements Visualization {
   public void printScore(char p1S, int player1,char p2S, int player2) {
       System.out.println("---------------------- \n    Current score:");
       System.out.print("       " + p1S + ": " + player1 + "    " + p2S + ": " + player2 + "\n ---------------------- \n");
    }

    public void printOut(Board gameBoard) {
        gameBoard.printBoard();
    }

    public void printError() {
        System.out.println("Your input is not from the options. \n");
    }

    public void printNoMoreMoves(char player) {
        System.out.println("No possible moves. Play passes back to the other player. Press eny key to continue.");
    }

    public void printOptions(char player, Vector <Cell> moves) {
        System.out.println("It's "  + player + " move. \n"+ "Your possible moves: ");
        this.options(moves);
        System.out.print("\n Please enter your move row,col: \n");
    }

    public void options(Vector <Cell> moves) {
        //print - a vector without duplication options.
        Vector <Cell> print = new Vector<>();
        print.add(moves.get(0));
        //For all the possible moves, check if there are to cells the same.
        for (int i = 0; i < moves.size(); i++) {
            if (!isAlreadyIn(print, moves.get(i))) {
                //If the option does'nt already in print, push back into print.
                print.add(moves.get(i));
            }
        }
        //For all the non-duplicate options - print them out.
        for (int i = 0; i < print.size(); i++) {
            int j = print.get(i).x + 1;
            int n = print.get(i).y + 1;
            System.out.print("(" + j + "," + n + ")");
        }
    }

    public boolean isAlreadyIn(Vector <Cell> print, Cell c) {
    //For the option in print - if c is already in - return false, else return true.
        for (int i = 0; i < print.size(); i++) {
            if (c.x == print.get(i).x && c.y == print.get(i).y) {
                return true;
            }
        }
        return false;
    }

    public void printWinner(char winner) {
        System.out.println("Game over!\n");
        if (winner == 'T') {
            System.out.println("It's a tie!\n");
            return;
        }
        System.out.println(winner + " is the winner!!!\n");
    }

    public void openScreen() {
        System.out.println("Please enter your option:\n(1) Two humen players.\n(2) Play against the computer.\n(3) Play against remote player.\n");
    }


    public void printWhichMovePlayed(char player, String move) {
        System.out.println("\nPlayer " + player + " played " + move + "\n");
    }

    public void subMenuRemote() {
        System.out.println("Please Enter Your Request: \nstart <gameName> \njoin <gameName> \nlist_games \n");
    }


    public void gameList(String listOfGames) {
        System.out.println("The open games are:\n" + listOfGames + "\n");
    }

    public void printMessage(String m) {
        System.out.println(m);
    }

    public void printServerClose() {
        System.out.println("Server is closing...");
    }
}
