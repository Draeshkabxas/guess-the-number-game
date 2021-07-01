package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class MessageGeneratorImpl implements MessageGenerator{

    // == constants ==
    private static final Logger log
            = LoggerFactory.getLogger(GameImpl.class);


    // == fields ==
    @Autowired
    private Game game;

    private final int guessCount=10;

    // == init ==
    @PostConstruct
   public void init(){
       log.info("Post: game = {} guess count = {}",game,guessCount);
   }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between "+
                game.smallest()+
                " and "+
                game.biggest()+
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()){
            return "You guess it! the number was "+game.getNumber();
        }else if (game.isGameLost()){
            return "You lost. the number was "+game.getNumber();
        }else if (!game.isValidNumberRange()){
            return "Invalid number range!";
        }else if (game.getRemainingGuesses() ==guessCount){
            return "What is your first guess?";
        }else {
            String direction="Lower";

            if (game.getGuess() < game.getNumber()){
                direction="Higher";
            }

            return direction+"! you have "+game.getRemainingGuesses()+" guesses left.";
        }

    }
}
