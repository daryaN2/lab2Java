package Operations;

import main.java.Operations.Context;
import main.java.Operations.Multi;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MultiTest {
    @org.junit.jupiter.api.Test
    void twoMulMinus3Mul10Point5EqualsMinus63() {
        var context = new Context();
        var multiply = new Multi();
        var args = new ArrayList<String>();
        context.push(2.0);
        context.push(-3.0);
        context.push(10.5);
        assertDoesNotThrow( () -> {
            multiply.execute(context,args);
        });
        assertDoesNotThrow( () -> {
            multiply.execute(context,args);
        });
        assertDoesNotThrow(() -> {
            assertEquals(-63,context.pop());
        });
    }


}