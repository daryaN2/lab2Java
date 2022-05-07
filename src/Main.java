import java.io.*;

public class Main {
    public static void main (String[] args) {
        try {
            BufferedReader reader;
            if (args.length == 1) {
                reader = new BufferedReader(new FileReader(args[0]));
            } else {
                reader = new BufferedReader(new InputStreamReader(System.in));
            }
            Calculator calculator = new Calculator();
            calculator.calculate(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
