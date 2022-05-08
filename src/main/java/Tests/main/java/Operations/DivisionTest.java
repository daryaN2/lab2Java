package main.java.Operations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    @org.junit.jupiter.api.Test
    void OneDivide0Point25DivideMinus4EqualsMinus1() {
        var context = new Context();
        var divide = new Division();
        var args = new ArrayList<String>();
        context.push(1.0);
        context.push(0.25);
        assertDoesNotThrow( () -> {
            divide.execute(context,args);
        });
        context.push(-4.0);
        assertDoesNotThrow( () -> {
            divide.execute(context,args);
        });
        assertDoesNotThrow(() -> {
            assertEquals(-1,context.pop());
        });
    }


}