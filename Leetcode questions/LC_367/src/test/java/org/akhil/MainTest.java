package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsPerfectSquare_Test1(){
        int num = 1;

        assertTrue(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test2(){
        int num = 2;

        assertFalse(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test3(){
        int num = 3;

        assertFalse(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test4(){
        int num = 4;

        assertTrue(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test5(){
        int num = 6;

        assertFalse(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test6(){
        int num = 7;

        assertFalse(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test7(){
        int num = 9;

        assertTrue(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test8(){
        int num = 15;

        assertFalse(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test9(){
        int num = 25;

        assertTrue(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test10(){
        int num = 144;

        assertTrue(Main.isPerfectSquare(num));
    }

    @Test
    public void testIsPerfectSquare_Test11(){
        int num = 808201;

        assertTrue(Main.isPerfectSquare(num));
    }
}