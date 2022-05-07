package Operations;

import Errors.NotEnoughValuesInStack;
import java.util.List;

public class Plus implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack {
        if(ctx.size()<2) {
            throw new NotEnoughValuesInStack("+");
        }
        ctx.push(ctx.pop()+ctx.pop());
    }
}
