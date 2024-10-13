package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testEuclidGCD_Test1(){
        int a = 10;
        int b = 20;

        assertEquals(10, Main.euclidGcd(a,b));
        assertEquals(20, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test2(){
        int a = 2;
        int b = 20;

        assertEquals(2, Main.euclidGcd(a,b));
        assertEquals(20, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test3(){
        int a = 9;
        int b = 36;

        assertEquals(9, Main.euclidGcd(a,b));
        assertEquals(36, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test4(){
        int a = 9;
        int b = 48;

        assertEquals(3, Main.euclidGcd(a,b));
        assertEquals(144, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test5(){
        int a = 2;
        int b = 4;

        assertEquals(2, Main.euclidGcd(a,b));
        assertEquals(4, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test6(){
        int a = 11;
        int b = 17;

        assertEquals(1, Main.euclidGcd(a,b));
        assertEquals(187, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test7(){
        int a = 11;
        int b = 11;

        assertEquals(11, Main.euclidGcd(a,b));
        assertEquals(11, Main.lcm(a,b));
    }

    @Test
    public void testEuclidGCD_Test8(){
        int a = 22;
        int b = 55;

        assertEquals(11, Main.euclidGcd(a,b));
        assertEquals(110, Main.lcm(a,b));
    }
}