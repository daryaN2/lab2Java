package main.java.Errors;

public class WrongNumOfParams extends Exception{
    public WrongNumOfParams(String s) {
        super("Can't do operation " + s + " because invalid number of arguments specified!");
    }
}
