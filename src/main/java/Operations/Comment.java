package main.java.Operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Comment implements Operation {
    private static final Logger logger = LogManager.getLogger(Comment.class);
    @Override
    public void execute(Context ctx, List<String> args) {
        logger.info("Operation # done");
    }
}
