package org.akhil;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testFib_Test1(){
        int n = 0;
        assertEquals(0, Main.fib(n));
    }

    @Test
    public void testFib_Test2(){
        int n = 1;
        assertEquals(1, Main.fib(n));
    }

    @Test
    public void testFib_Test3(){
        int n = 2;
        assertEquals(1, Main.fib(n));
    }

    @Test
    public void testFib_Test4(){
        int n = 3;
        assertEquals(2, Main.fib(n));
    }

    @Test
    public void testFib_Test5(){
        int n = 4;
        assertEquals(3, Main.fib(n));
    }

    @Test
    public void testFib_Test6(){
        int n = 5;
        assertEquals(5, Main.fib(n));
    }

    @Test
    public void testFib_Test7(){
        int n = 6;
        assertEquals(8, Main.fib(n));
    }

    @Test
    public void testFib_Test8(){
        int n = 7;
        assertEquals(13, Main.fib(n));
    }

    @Test
    public void testFib_Test9(){
        int n = 8;
        assertEquals(21, Main.fib(n));
    }
}