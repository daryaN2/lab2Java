package Operations;

import Errors.FileNotLoaded;
import Errors.WrongNumOfParams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Save implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, FileNotLoaded {
        if (args.size() != 2) {
            throw new WrongNumOfParams("SAVE");
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(args.get(1))));
            int size = ctx.size();
            for (int i = 0; i < size; ++i) {
                writer.println(ctx.pop());
            }
        } catch (IOException e) {
            throw new FileNotLoaded("for saving");
        }
        finally {
            if (null != writer) {
                writer.close();
            }
        }
    }
}
