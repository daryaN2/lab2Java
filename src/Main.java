import Errors.FileNotLoaded;
import Errors.OperationNotSupported;
import Errors.UnableToCreateOperation;
import Factory.OperationFactory;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        try {
            if (args.length == 1) {
                Scanner scanner = new Scanner(new FileReader(args[0]));
            } else {
                Scanner scanner = new Scanner(System.in);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
