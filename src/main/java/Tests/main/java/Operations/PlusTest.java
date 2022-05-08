package main.java.Operations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlusTest {
    @org.junit.jupiter.api.Test
    void twoPlus3Plus10Equals15() {
        var context = new Context();
        var plus = new Plus();
        var args = new ArrayList<String>();
        context.push(2.0);
        context.push(3.0);
        context.push(10.0);
        assertDoesNotThrow( () -> {
            plus.execute(context,args);
        });
        assertDoesNotThrow( () -> {
            plus.execute(context,args);
        });
        assertDoesNotThrow(() -> {
            assertEquals(15,context.pop());
        });
    }


}