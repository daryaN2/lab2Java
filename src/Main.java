import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main (String[] args) {
        logger.debug("Hello from Log4j 2");
        logger.debug("This is a Debug Message!");
        logger.info("This is an Info Message!");
        logger.error("And here comes the Error Message!", new RuntimeException("RunRunRun"));
        try {
            BufferedReader reader;
            if (args.length == 1) {
                reader = new BufferedReader(new FileReader(args[0]));
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
            Calculator calculator = new Calculator();
            calculator.calculate(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
