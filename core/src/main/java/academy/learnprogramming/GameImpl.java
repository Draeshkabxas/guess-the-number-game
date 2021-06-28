package academy.learnprogramming;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game{
    // == constants ==
    private static final Logger log
               = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    private NumberGenerator numberGenerator;
    private int guessCount=10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuess;
    private boolean validNumberRange=true;

    //== public methods ==

    @Override
    public void reset() {
      guess=0;
      smallest=0;
      biggest=numberGenerator.getMaxNumber();
      remainingGuess=guessCount;
      number=numberGenerator.next();

      log.debug("The number is {}",number);
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
       this.guess=guess;
    }

    @Override
    public int smallest() {
        return smallest;
    }

    @Override
    public int biggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuess;
    }



    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange){
            if (guess > number){
                biggest=guess-1;
            }

            if (guess < number){
                smallest=guess+1;
            }


        }

        remainingGuess--;

    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuess <= 0;
    }

    //== private methods ==
    private void checkValidNumberRange(){
        validNumberRange=(guess>=smallest) && (guess<=biggest);
    }
}
