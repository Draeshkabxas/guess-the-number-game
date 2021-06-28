package academy.learnprogramming;

public interface Game {
    int getNumber();
    int getGuess();

    void setGuess(int guess);

    int smallest();

    int biggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumber();

    boolean isGameWon();

    boolean isGameLost();
}
