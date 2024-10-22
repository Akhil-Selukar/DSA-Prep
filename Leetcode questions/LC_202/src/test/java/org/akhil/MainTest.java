package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsHappy_Test1(){
        int n = 1;
        assertTrue(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test2(){
        int n = 2;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test3(){
        int n = 3;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test4(){
        int n = 4;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test5(){
        int n = 5;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test6(){
        int n = 6;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test7(){
        int n = 7;
        assertTrue(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test8(){
        int n = 8;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test9(){
        int n = 9;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test10(){
        int n = 10;
        assertTrue(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test11(){
        int n = 11;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test12(){
        int n = 12;
        assertFalse(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test13(){
        int n = 13;
        assertTrue(Main.isHappy(n));
    }

    @Test
    public void testIsHappy_Test14(){
        int n = 14;
        assertFalse(Main.isHappy(n));
    }
}