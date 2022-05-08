package Operations;

import main.java.Operations.Context;
import main.java.Operations.Load;
import main.java.Operations.Save;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveLoadTest {
    @org.junit.jupiter.api.Test
    void saveAndLoad() {
        var context = new Context();
        var load = new Load();
        var save = new Save();
        var args = new ArrayList<String>();
        args.add("save");
        args.add("src\\test\\java\\saveAndLoadTestFile");
        context.push(-1.0);
        context.push(2.0);
        context.push(-3.3232);
        assertDoesNotThrow(() ->{
            save.execute(context,args);
        });
        assertEquals(0,context.size());
        assertDoesNotThrow(() ->{
            load.execute(context,args);
        });
        assertEquals(3,context.size());
        assertDoesNotThrow(() -> {
            assertEquals(-1,context.pop());
        });
        assertDoesNotThrow(() -> {
            assertEquals(2,context.pop());
        });
        assertDoesNotThrow(() -> {
            assertEquals(-3.3232,context.pop());
        });
    }


}