package main.java.Operations;

import main.java.Errors.NotEnoughValuesInStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Pop implements Operation {
    private static final Logger logger = LogManager.getLogger(Pop.class);
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack {
        if(ctx.size()==0) {
            logger.error(new NotEnoughValuesInStack("pop"));
            throw new NotEnoughValuesInStack("pop");
        }
        ctx.pop();
        logger.info("Operation POP done");
    }
}
