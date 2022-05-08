package Operations;

import Errors.WrongNumOfParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Load implements Operation {
    private static final Logger logger = LogManager.getLogger(Load.class);
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, FileNotFoundException {
        if (args.size() != 2) {
            logger.error(new WrongNumOfParams("LOAD"));
            throw new WrongNumOfParams("LOAD");
        }
        try {
            File file_name = new File(args.get(1));
            Scanner scanner = new Scanner(file_name);
            while (scanner.hasNextDouble()) {
                ctx.push(scanner.nextDouble());
            }
        } catch (IOException e) {
            logger.error(e);
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
        logger.info("Operation LOAD done");

    }
}
