package main.java.Operations;

import main.java.Errors.FileNotLoaded;
import main.java.Errors.WrongNumOfParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Save implements Operation {
    private static final Logger logger = LogManager.getLogger(Save.class);
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, FileNotLoaded {
        if (args.size() != 2) {
            logger.error(new WrongNumOfParams("SAVE"));
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
            logger.error(new FileNotLoaded("SAVE"));
            throw new FileNotLoaded("SAVE");
        }
        finally {
            if (null != writer) {
                writer.close();
            }
        }
        logger.info("Operation SAVE done");
    }
}
