package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsValid_Test1(){
        String s = "()[]{}";

        assertTrue(Main.isValid(s));
    }

    @Test
    public void testIsValid_Test2(){
        String s = "[({})]";

        assertTrue(Main.isValid(s));
    }

    @Test
    public void testIsValid_Test3(){
        String s = "[({])]";

        assertFalse(Main.isValid(s));
    }

    @Test
    public void testIsValid_Test4(){
        String s = "[{}]()[][[";

        assertFalse(Main.isValid(s));
    }

    @Test
    public void testIsValid_Test5(){
        String s = "[{}]()[]";

        assertTrue(Main.isValid(s));
    }
}