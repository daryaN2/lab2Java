package Operations;

import Errors.DivByZero;
import Errors.NotEnoughValuesInStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Division implements Operation{
    private static final Logger logger = LogManager.getLogger(Division.class);
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack, DivByZero {
        if(ctx.size()<2) {
            logger.error(new NotEnoughValuesInStack("/"));
            throw new NotEnoughValuesInStack("/");
        }
        if(ctx.peek() == 0) {
            logger.error(new DivByZero());
            throw new DivByZero();
        }
        double v1 = ctx.pop();
        double v2 = ctx.pop();
        ctx.push(v2/v1);
        logger.info("Operation / done");
    }
}
