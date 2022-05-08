package main.java.Errors;

public class WrongArg extends Exception {
    public WrongArg(String s) {
        super("Can't do operation " + s + " because arguments are wrong!");
    }
}
