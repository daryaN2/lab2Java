import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private static final Logger logger = LogManager.getLogger(CommandParser.class);
    public List<List<String>> parse(BufferedReader reader) throws IOException {
        logger.info("Parsing commands");
        List<List<String>> commands = new ArrayList<>();
        String line;
        List<String> nameAndArgs;
        int start;
        while (((line = reader.readLine()) != null) && (0 != line.length())) {
            start = 0;
            nameAndArgs = new ArrayList<>();
            int i = 0;
            while (i != line.length()) {
                if (Character.isWhitespace(line.charAt(i))) {
                    nameAndArgs.add(line.substring(start, i));
                    start = i + 1;
                }
                ++i;
            }
            if (start != i)
                nameAndArgs.add(line.substring(start));
            commands.add(nameAndArgs);
        }
        return commands;

    }
}
