package Operations;

import main.java.Operations.Context;
import main.java.Operations.Minus;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MinusTest {
    @org.junit.jupiter.api.Test
    void twoMinus3Minus100Point25EqualsMinus101Point25() {
        var context = new Context();
        var minus = new Minus();
        var args = new ArrayList<String>();
        context.push(2.0);
        context.push(3.0);
        assertDoesNotThrow( () -> {
            minus.execute(context,args);
        });
        context.push(100.25);
        assertDoesNotThrow( () -> {
            minus.execute(context,args);
        });
        assertDoesNotThrow(() -> {
            assertEquals(-101.25,context.pop());
        });
    }


}