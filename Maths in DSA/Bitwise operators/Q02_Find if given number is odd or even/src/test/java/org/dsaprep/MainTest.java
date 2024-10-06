package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsEven_Test1(){
        int num = 31;
        assertFalse(Main.isEven(num));
    }

    @Test
    public void testIsEven_Test2(){
        int num = 2;
        assertTrue(Main.isEven(num));
    }

    @Test
    public void testIsEven_Test3(){
        int num = 39;
        assertFalse(Main.isEven(num));
    }

    @Test
    public void testIsEven_Test4(){
        int num = 315684954;
        assertTrue(Main.isEven(num));
    }

    @Test
    public void testIsEven_Test5(){
        int num = 31315687;
        assertFalse(Main.isEven(num));
    }
}