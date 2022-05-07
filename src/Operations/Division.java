package Operations;

import Errors.DivByZero;
import Errors.NotEnoughValuesInStack;

import java.util.List;

public class Division implements Operation{
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack, DivByZero {
        if(ctx.size()<2) {
            throw new NotEnoughValuesInStack("/");
        }
        if(ctx.peek() == 0) {
            throw new DivByZero();
        }
        double v1 = ctx.pop();
        double v2 = ctx.pop();
        ctx.push(v2/v1);
    }
}
