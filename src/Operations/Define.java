package Operations;

import Errors.WrongArg;
import Errors.WrongNumOfParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Define implements Operation {
    private static final Logger logger = LogManager.getLogger(Define.class);
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, WrongArg {
        if(args.size() != 3) {
            logger.error(new WrongNumOfParams("DEFINE"));
            throw new WrongNumOfParams("DEFINE");
        }
        if (args.get(1).matches("^[a-zA-Z]+$")) {
            ctx.define(args.get(1), Double.parseDouble(args.get(2)));
        } else {
            logger.error(new WrongArg("DEFINE"));
            throw new WrongArg("DEFINE");
        }
        logger.info("Operation DEFINE done");

    }
}
