import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main (String[] args) {
        logger.info("Program started.");
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
            logger.error("Cannot open file", e);
            e.printStackTrace();
        }

    }
}
