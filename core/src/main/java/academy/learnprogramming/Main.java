package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    //Logging
    private final static Logger log= LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context (container)
        ConfigurableApplicationContext context
                =new AnnotationConfigApplicationContext(AppConfig.class);

        //Get numberGenerator bean from context (container)
        NumberGenerator numberGenerator
                =context.getBean(NumberGeneratorImpl.class);

        //Call method next to get() a random number.
        int number=numberGenerator.next();

        //Log generated number.
        log.info("Number = {}",number);

        //Get messageGenerator bean from context (container)
        MessageGenerator messageGenerator=context.getBean(MessageGeneratorImpl.class);
        log.info("getMainMessage() {}",messageGenerator.getMainMessage());
        log.info("getResultMessage() {}",messageGenerator.getResultMessage());



        //Close context (container)
        context.close();
    }
}
