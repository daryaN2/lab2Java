package Operations;

import Errors.NotEnoughValuesInStack;
import Errors.WrongArg;
import Errors.WrongNumOfParams;

import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

public class Average implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, NotEnoughValuesInStack, WrongArg {
        if (args.size() != 2) {
            throw new WrongNumOfParams("AVG");
        }
        int x;
        try {
            x = Integer.parseInt(args.get(1));
        } catch (NumberFormatException e) {
            throw new WrongArg("AVG");
        }
        if (ctx.size()<x) {
            throw new NotEnoughValuesInStack("AVG");
        }
        double sum = 0;
        for (int i = 0; i < x; ++i) {
            sum += ctx.pop();
        }
        ctx.push(sum/x);

    }
}
