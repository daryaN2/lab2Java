package main.java.Errors;

public class NotEnoughValuesInStack extends Exception {
    public NotEnoughValuesInStack(String s) {
        super("Can't do operation " + s + " because of lack of parameters!");
    }
}
