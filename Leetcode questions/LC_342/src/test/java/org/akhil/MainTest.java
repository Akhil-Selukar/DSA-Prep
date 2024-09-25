package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsPowerOfFour_Test1(){
        int n = 1;

        assertTrue(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test2(){
        int n = 2;

        assertFalse(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test3(){
        int n = 3;

        assertFalse(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test4(){
        int n = 4;

        assertTrue(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test5(){
        int n = 8;

        assertFalse(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test6(){
        int n = 12;

        assertFalse(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test7(){
        int n = 16;

        assertTrue(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test8(){
        int n = 32;

        assertFalse(Main.isPowerOfFour(n));
    }

    @Test
    public void testIsPowerOfFour_Test9(){
        int n = 64;

        assertTrue(Main.isPowerOfFour(n));
    }
}