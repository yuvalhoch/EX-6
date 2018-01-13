package myapp;

public class GameFlow {
    private ReversiRules currentGame_;
    private Visualization screen_;
    public void run() {
        //as long as the game isnt over, keep switching turns
        do {
            currentGame_.nextTurn();
        } while (!currentGame_.gameOver());
        currentGame_.whoWon();
    }

    public GameFlow(GeneralPlayer first, GeneralPlayer second, Visualization screen) {
        currentGame_ = new ReversiRules(first, second, screen);
        this.screen_ = screen;
    }
}
