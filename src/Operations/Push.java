package Operations;

import Errors.WrongArg;
import Errors.WrongNumOfParams;

import java.util.List;

public class Push implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, WrongArg {
        if(args.size() != 2) {
            throw new WrongNumOfParams("PUSH");
        }
        double x = 0;
        try {
            x = Double.parseDouble(args.get(1));
        } catch (NumberFormatException e) {
            throw new WrongArg("PUSH");
        }
        ctx.push(x);
    }
}
