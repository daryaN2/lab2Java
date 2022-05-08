package Operations;

import Errors.NotEnoughValuesInStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Module implements Operation{
    private static final Logger logger = LogManager.getLogger(Module.class);
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack {
        if(ctx.size()<1) {
            logger.error(new NotEnoughValuesInStack("ABS"));
            throw new NotEnoughValuesInStack("ABS");
        }
        ctx.push(Math.abs(ctx.pop()));
        logger.info("Operation ABS done");
    }
}
