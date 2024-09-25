package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSumOfDigits_Test1(){
        int n = 12345;

        assertEquals(15, Main.sumOfDigits(n));
    }

    @Test
    public void testSumOfDigits_Test2(){
        int n = 2;

        assertEquals(2, Main.sumOfDigits(n));
    }

    @Test
    public void testSumOfDigits_Test3(){
        int n = 111;

        assertEquals(3, Main.sumOfDigits(n));
    }

    @Test
    public void testSumOfDigits_Test4(){
        int n = 0;

        assertEquals(0, Main.sumOfDigits(n));
    }

    @Test
    public void testSumOfDigits_Test5(){
        int n = 2456389;

        assertEquals(37, Main.sumOfDigits(n));
    }
}