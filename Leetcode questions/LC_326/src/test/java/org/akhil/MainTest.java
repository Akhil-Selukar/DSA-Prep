package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsPowerOfThree_Test1(){
        int n=1;

        assertTrue(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test2(){
        int n=2;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test3(){
        int n=3;

        assertTrue(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test4(){
        int n=4;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test5(){
        int n=6;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test6(){
        int n=7;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test7(){
        int n=12;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test8(){
        int n=9;

        assertTrue(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test9(){
        int n=21;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test10(){
        int n=21;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test11(){
        int n=30;

        assertFalse(Main.isPowerOfThree(n));
    }

    @Test
    public void testIsPowerOfThree_Test12(){
        int n=81;

        assertTrue(Main.isPowerOfThree(n));
    }
}