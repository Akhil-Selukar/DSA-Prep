package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMinInsertions_test1(){
        String s = "(()))";

        assertEquals(1, Main.minInsertions(s));
    }

    @Test
    public void testMinInsertions_test2(){
        String s = "())";

        assertEquals(0, Main.minInsertions(s));
    }

    @Test
    public void testMinInsertions_test3(){
        String s = "))())(";

        assertEquals(3, Main.minInsertions(s));
    }

    @Test
    public void testMinInsertions_test4(){
        String s = ")())(";

        assertEquals(4, Main.minInsertions(s));
    }

    @Test
    public void testMinInsertions_test5(){
        String s = "())(";

        assertEquals(2, Main.minInsertions(s));
    }

    @Test
    public void testMinInsertions_test6(){
        String s = "))())";

        assertEquals(1, Main.minInsertions(s));
    }

    @Test
    public void testMinInsertions_test7(){
        String s = ")())((";

        assertEquals(6, Main.minInsertions(s));
    }
}