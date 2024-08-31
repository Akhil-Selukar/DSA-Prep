package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testCheckOnesSegment_Test1(){
        String s = "1100101";

        assertFalse(Main.checkOnesSegment(s));
    }

    @Test
    public void testCheckOnesSegment_Test2(){
        String s = "10000";

        assertTrue(Main.checkOnesSegment(s));
    }

    @Test
    public void testCheckOnesSegment_Test3(){
        String s = "1111000";

        assertTrue(Main.checkOnesSegment(s));
    }

    @Test
    public void testCheckOnesSegment_Test4(){
        String s = "10011011";

        assertFalse(Main.checkOnesSegment(s));
    }

    @Test
    public void testCheckOnesSegment_Test5(){
        String s = "10001";

        assertFalse(Main.checkOnesSegment(s));
    }

    @Test
    public void testCheckOnesSegment_Test6(){
        String s = "1";

        assertTrue(Main.checkOnesSegment(s));
    }
}