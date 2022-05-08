import Errors.*;
import Factory.OperationFactory;
import Operations.Context;
import Operations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public  void calculate(BufferedReader reader) {
        logger.info("Calculator is creating");
        CommandParser parser = new CommandParser();
        try {
            List<List<String>> commands = parser.parse(reader);
            Context context = new Context();
            for (List<String> c : commands) {
                Operation operation = OperationFactory.getInstance().getOperation(c.get(0));
                operation.execute(context, c);
            }
        } catch (IOException | FileNotLoaded | UnableToCreateOperation | OperationNotSupported | NotEnoughValuesInStack | DivByZero | WrongNumOfParams | WrongArg e) {
            logger.error("Error ", e);
            e.printStackTrace();
        }
    }
}
