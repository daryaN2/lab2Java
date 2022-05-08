package Operations;

import main.java.Operations.Context;
import main.java.Operations.Pop;
import main.java.Operations.Push;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DefinePushPopTest {
    @org.junit.jupiter.api.Test
    void pushThreePopThree() {
        var context = new Context();
        var args = new ArrayList<String>();
        var push = new Push();
        var pop = new Pop();
        assertEquals(0,context.size());
        args.add("push");
        args.add("-2.5");
        assertDoesNotThrow(() -> {
            push.execute(context,args);
        });
        assertEquals(1,context.size());
        assertDoesNotThrow( () -> {
            assertEquals(-2.5, context.peek());
        });
        assertDoesNotThrow(() -> {
            pop.execute(context,args);
        });
        args.set(1,"7.25");
        assertDoesNotThrow(() -> {
            push.execute(context,args);
        });
        assertEquals(1,context.size());
        assertDoesNotThrow( () -> {
            assertEquals(7.25, context.peek());
        });
        args.set(1,"6");
        assertDoesNotThrow(() -> {
            push.execute(context,args);
        });
        assertEquals(2,context.size());
        assertDoesNotThrow( () -> {
            assertEquals(6, context.peek());
        });
        assertDoesNotThrow(() -> {
            pop.execute(context,args);
        });
        assertEquals(1,context.size());
        assertDoesNotThrow( () -> {
            assertEquals(7.25, context.peek());
        });
        assertDoesNotThrow(() -> {
            pop.execute(context,args);
        });
        assertEquals(0,context.size());
    }



}