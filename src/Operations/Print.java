package Operations;

import Errors.NotEnoughValuesInStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Print implements Operation {
    private static final Logger logger = LogManager.getLogger(Print.class);
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack {
        if(ctx.size()<1) {
            logger.error(new NotEnoughValuesInStack("PRINT"));
            throw new NotEnoughValuesInStack("PRINT");
        }
        System.out.println(ctx.peek());
        logger.info("Operation PRINT done");
    }
}
