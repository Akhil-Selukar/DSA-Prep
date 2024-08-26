package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testInterpret_Test1(){
        String command = "G()()()()(al)";

        assertEquals("Gooooal", Main.interpret(command));
    }

    @Test
    public void testInterpret_Test2(){
        String command = "G()(al)";

        assertEquals("Goal", Main.interpret(command));
    }

    @Test
    public void testInterpret_Test3(){
        String command = "(al)G(al)()()G";

        assertEquals("alGalooG", Main.interpret(command));
    }
}