package Operations;

import Errors.WrongArg;
import Errors.WrongNumOfParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Push implements Operation {
    private static final Logger logger = LogManager.getLogger(Push.class);
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, WrongArg {
        if(args.size() != 2) {
            logger.error(new WrongNumOfParams("PUSH"));
            throw new WrongNumOfParams("PUSH");
        }
        if ((!Character.isDigit(args.get(1).charAt(0))) && ('-' != args.get(1).charAt(0))) {
            ctx.pushDefinedToStack(args.get(1));
        } else {
            double x;
            try {
                x = Double.parseDouble(args.get(1));
            } catch (NumberFormatException e) {
                logger.error(new WrongArg("PUSH"));
                throw new WrongArg("PUSH");
            }
            ctx.push(x);
        }
        logger.info("Operation PUSH done");
    }
}
