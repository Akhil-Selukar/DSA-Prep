package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindSqrt_Test1(){
        int n = 36;

        assertEquals(6, Main.findSqrt(n));
    }

    @Test
    public void testFindSqrt_Test2(){
        int n = 9;

        assertEquals(3, Main.findSqrt(n));
    }

    @Test
    public void testFindSqrt_Test3(){
        int n = 4;

        assertEquals(2, Main.findSqrt(n));
    }

    @Test
    public void testFindSqrt_Test4(){
        int n = 1;

        assertEquals(1, Main.findSqrt(n));
    }

    @Test
    public void testFindSqrt_Test5(){
        int n = 100;

        assertEquals(10, Main.findSqrt(n));
    }

    @Test
    public void testFindSqrt_Test6(){
        int n = 81;

        assertEquals(9, Main.findSqrt(n));
    }
}