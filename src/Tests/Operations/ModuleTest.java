package Operations;

import main.java.Operations.Context;
import main.java.Operations.Module;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModuleTest {

    @org.junit.jupiter.api.Test
    void absolute2AndMinus2() {
        var context = new Context();
        var abs = new Module();
        var args = new ArrayList<String>();
        context.push(2.0);
        assertDoesNotThrow( () -> {
            abs.execute(context,args);
        });
        assertDoesNotThrow(() -> {
            assertEquals(2,context.pop());
        });
        context.push(-2.0);
        assertDoesNotThrow( () -> {
            abs.execute(context,args);
        });
        assertDoesNotThrow(() -> {
            assertEquals(2,context.pop());
        });
    }


}