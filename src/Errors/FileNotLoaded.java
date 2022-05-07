package Errors;

public class FileNotLoaded extends Exception{
    public FileNotLoaded(String s) {
        super("Can't open " + s + " file!");
    }
}
