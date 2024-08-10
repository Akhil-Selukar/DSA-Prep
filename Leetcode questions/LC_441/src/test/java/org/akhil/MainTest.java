package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testArrangeCoins_Test1(){
        int n=8;

        assertEquals(3, Main.arrangeCoins(n));
    }

    @Test
    public void testArrangeCoins_Test2(){
        int n=5;

        assertEquals(2, Main.arrangeCoins(n));
    }

    @Test
    public void testArrangeCoins_Test3(){
        int n=1;

        assertEquals(1, Main.arrangeCoins(n));
    }

    @Test
    public void testArrangeCoins_Test4(){
        int n=10;

        assertEquals(4, Main.arrangeCoins(n));
    }

//    -----------------------

    @Test
    public void testArrangeCoins2_Test1(){
        int n=8;

        assertEquals(3, Main.arrangeCoins2(n));
    }

    @Test
    public void testArrangeCoins2_Test2(){
        int n=5;

        assertEquals(2, Main.arrangeCoins2(n));
    }

    @Test
    public void testArrangeCoins2_Test3(){
        int n=1;

        assertEquals(1, Main.arrangeCoins2(n));
    }

    @Test
    public void testArrangeCoins2_Test4(){
        int n=10;

        assertEquals(4, Main.arrangeCoins2(n));
    }

    //-------------------------

    @Test
    public void testArrangeCoins3_Test1(){
        int n=8;

        assertEquals(3, Main.arrangeCoins3(n));
    }

    @Test
    public void testArrangeCoins3_Test2(){
        int n=5;

        assertEquals(2, Main.arrangeCoins3(n));
    }

    @Test
    public void testArrangeCoins3_Test3(){
        int n=1;

        assertEquals(1, Main.arrangeCoins3(n));
    }

    @Test
    public void testArrangeCoins3_Test4(){
        int n=10;

        assertEquals(4, Main.arrangeCoins3(n));
    }

    @Test
    public void testArrangeCoins3_Test5(){
        int n=1804289383;

        assertEquals(60070, Main.arrangeCoins3(n));
    }
}