package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsPowerOfTwo_Test1(){
        int n = 1;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test2(){
        int n = 2;

        assertTrue(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test3(){
        int n =3;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test4(){
        int n = 4;

        assertTrue(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test5(){
        int n = 5;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test6(){
        int n = 6;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test7(){
        int n = 7;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test8(){
        int n = 8;

        assertTrue(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test9(){
        int n = 9;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test10(){
        int n = 10;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test11(){
        int n = 11;

        assertFalse(Main.isPowerOfTwo(n));
    }

    @Test
    public void testIsPowerOfTwo_Test12(){
        int n = 12;

        assertFalse(Main.isPowerOfTwo(n));
    }
}