package Operations;

import Errors.WrongArg;
import Errors.WrongNumOfParams;

import java.util.List;

public class Define implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, WrongArg {
        if(args.size() != 3) {
            throw new WrongNumOfParams("DEFINE");
        }
        if (args.get(1).matches("^[a-zA-Z]+$")) {
            ctx.define(args.get(1), Double.parseDouble(args.get(2)));
        } else {
            throw new WrongArg("DEFINE");
        }

    }
}
