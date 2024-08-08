package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMySqrt_Test0(){
        int num = 0;
        assertEquals(0, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test1(){
        int num = 1;
        assertEquals(1, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test2(){
        int num = 2;
        assertEquals(1, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test3(){
        int num = 3;
        assertEquals(1, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test4(){
        int num = 4;
        assertEquals(2, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test5(){
        int num = 5;
        assertEquals(2, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test6(){
        int num = 6;
        assertEquals(2, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test7(){
        int num = 9;
        assertEquals(3, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test8(){
        int num = 10;
        assertEquals(3, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test9(){
        int num = 13;
        assertEquals(3, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test10(){
        int num = 15;
        assertEquals(3, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Tes11(){
        int num = 16;
        assertEquals(4, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test12(){
        int num = 18;
        assertEquals(4, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test13(){
        int num = 22;
        assertEquals(4, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test14(){
        int num = 27;
        assertEquals(5, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test15(){
        int num = 246;
        assertEquals(15, Main.mySqrt(num));
    }

    @Test
    public void testMySqrt_Test16(){
        int num = 2147395599;
        assertEquals(46339, Main.mySqrt(num));
    }
}