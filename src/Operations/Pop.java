package Operations;

import Errors.NotEnoughValuesInStack;

import java.util.List;

public class Pop implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack {
        if(ctx.size()==0) {
            throw new NotEnoughValuesInStack("pop");
        }
        ctx.pop();
    }
}
