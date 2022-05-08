package Operations;

import main.java.Operations.Average;
import main.java.Operations.Context;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    @org.junit.jupiter.api.Test
    void averageOf5Values() {
        var context = new Context();
        var avg = new Average();
        var args = new ArrayList<String>();
        args.add("average");
        args.add("5");
        context.push(5.5);
        context.push(6.5);
        context.push(3.0);
        context.push(5.0);
        context.push(10.0);
        assertDoesNotThrow( () -> {
            avg.execute(context,args);
        });
        assertEquals(1,context.size());
        assertDoesNotThrow(() -> {
            assertEquals(6,context.pop());
        });
    }



}