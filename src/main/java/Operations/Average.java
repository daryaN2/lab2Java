package main.java.Operations;

import main.java.Errors.NotEnoughValuesInStack;
import main.java.Errors.WrongArg;
import main.java.Errors.WrongNumOfParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Average implements Operation {
    private static final Logger logger = LogManager.getLogger(Average.class);
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, NotEnoughValuesInStack, WrongArg {
        if (args.size() != 2) {
            logger.error(new WrongNumOfParams("AVG"));
            throw new WrongNumOfParams("AVG");
        }
        int x;
        try {
            x = Integer.parseInt(args.get(1));
        } catch (NumberFormatException e) {
            logger.error(new WrongArg("AVG"));
            throw new WrongArg("AVG");
        }
        if (ctx.size()<x) {
            logger.error(new NotEnoughValuesInStack("AVG"));
            throw new NotEnoughValuesInStack("AVG");
        }
        double sum = 0;
        for (int i = 0; i < x; ++i) {
            sum += ctx.pop();
        }
        ctx.push(sum/x);
        logger.info("Operation AVG done");
    }

}
