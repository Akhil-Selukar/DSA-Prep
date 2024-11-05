package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMinAddToMakeValid_test1(){
        String s = "())";

        assertEquals(1, Main.minAddToMakeValid(s));
    }

    @Test
    public void testMinAddToMakeValid_test2(){
        String s = "(((";

        assertEquals(3, Main.minAddToMakeValid(s));
    }

    @Test
    public void testMinAddToMakeValid_test3(){
        String s = "(()()(()))";

        assertEquals(0, Main.minAddToMakeValid(s));
    }

    @Test
    public void testMinAddToMakeValid_test4(){
        String s = "(())(((())))";

        assertEquals(0, Main.minAddToMakeValid(s));
    }

    @Test
    public void testMinAddToMakeValid_test5(){
        String s = "";

        assertEquals(0, Main.minAddToMakeValid(s));
    }

    @Test
    public void testMinAddToMakeValid_test6(){
        String s = "()))((";

        assertEquals(4, Main.minAddToMakeValid(s));
    }
}