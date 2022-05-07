import Errors.*;
import Factory.OperationFactory;
import Operations.Context;
import Operations.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Calculator {
    public  void calculate(BufferedReader reader) {
        CommandParser parser = new CommandParser();
        try {
            List<List<String>> commands = parser.parse(reader);
            Context context = new Context();
            for (List<String> c : commands) {
                Operation operation = OperationFactory.getInstance().getOperation(c.get(0));
                operation.execute(context, c);
            }
        } catch (IOException | FileNotLoaded | UnableToCreateOperation | OperationNotSupported | NotEnoughValuesInStack | DivByZero | WrongNumOfParams | WrongArg e) {
            e.printStackTrace();
        }
    }
}
