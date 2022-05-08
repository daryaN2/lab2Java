package Operations;

import Errors.NotEnoughValuesInStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Plus implements Operation {
    private static final Logger logger = LogManager.getLogger(Plus.class);
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack {
        if(ctx.size()<2) {
            logger.error(new NotEnoughValuesInStack("+"));
            throw new NotEnoughValuesInStack("+");
        }
        ctx.push(ctx.pop()+ctx.pop());
        logger.info("Operation + done");
    }
}
