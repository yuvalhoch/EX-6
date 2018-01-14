package myapp;

public class GameFlow {
    private ReversiRules currentGame_;
    private BoardController boardControl;
    public GameFlow(int size, GeneralPlayer first, GeneralPlayer second, BoardController boardController) {
        this.boardControl = boardController;
        currentGame_ = new ReversiRules(size, first, second, boardControl);
    }
    public String run() {
        String winner = null;
        //as long as the game isnt over, keep switching turns
        if (!currentGame_.gameOver()) {
            currentGame_.nextTurn();
        } else {
            currentGame_.drow();
            char w = currentGame_.whoWon();
            String color1 = boardControl.getColor1();
            String color2 = boardControl.getColor2();
            if (w == color1.charAt(0)) {
                winner = "The winner is: " + color1;
            } else if (w == color2.charAt(0)) {
                winner = "The winner is: " + color2;
            } else {
                winner = "It's a tie!";
            }
        }
        return winner;
    }
    public char currentPlayer() {
        return this.currentGame_.getCurrentPlayer();
    }
}
