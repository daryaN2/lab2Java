package Operations;

import Errors.WrongNumOfParams;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Load implements Operation {
    @Override
    public void execute(Context ctx, List<String> args) throws WrongNumOfParams, FileNotFoundException {
        if (args.size() != 2) {
            throw new WrongNumOfParams("LOAD");
        }
        try {
            File file_name = new File(args.get(1));
            Scanner scanner = new Scanner(file_name);
            while (scanner.hasNextDouble()) {
                ctx.push(scanner.nextDouble());
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }

    }
}
