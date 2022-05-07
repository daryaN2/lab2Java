package Operations;

import Errors.*;

import java.io.FileNotFoundException;
import java.util.List;

public interface Operation {
    void execute(Context ctx, List<String> args) throws NotEnoughValuesInStack, DivByZero, WrongNumOfParams, WrongArg, FileNotFoundException, FileNotLoaded;

}
