package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    //Logging
    private final static Logger log= LoggerFactory.getLogger(Main.class);

    //Configuration Location
    public static final String CONFIG_LOCATION="beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context (container)
        ConfigurableApplicationContext context
                =new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator
                =context.getBean("numberGenerator",NumberGeneratorImpl.class);

        //Call method next to get() a random number.
        int number=numberGenerator.next();

        //Log generated number.
        log.info("Number = {}",number);

        //Close context (container)
        context.close();
    }
}
