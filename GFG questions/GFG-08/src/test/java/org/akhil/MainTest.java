package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testIsPrime_Test1(){
        int num = 1;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test2(){
        int num = 2;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test3(){
        int num = 3;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test4(){
        int num = 4;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test5(){
        int num = 5;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test6(){
        int num = 6;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test7(){
        int num = 7;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test8(){
        int num = 8;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test9(){
        int num = 9;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test10(){
        int num = 10;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test11(){
        int num = 11;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test12(){
        int num = 12;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test13(){
        int num = 13;

        assertEquals("Yes", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test14(){
        int num = 14;

        assertEquals("No", Main.isPrime(num));
    }

    @Test
    public void testIsPrime_Test15(){
        int num = 15;

        assertEquals("No", Main.isPrime(num));
    }
}