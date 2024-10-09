package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindPower_Test1(){
        int a = 1;
        int b = 6;

        assertEquals(1, Main.findPower(a,b));
    }

    @Test
    public void testFindPower_Test2(){
        int a = 2;
        int b = 5;

        assertEquals(32, Main.findPower(a,b));
    }

    @Test
    public void testFindPower_Test3(){
        int a = 3;
        int b = 2;

        assertEquals(9, Main.findPower(a,b));
    }

    @Test
    public void testFindPower_Test4(){
        int a = 3;
        int b = 0;

        assertEquals(1, Main.findPower(a,b));
    }

    @Test
    public void testFindPower_Test5(){
        int a = 3;
        int b = 3;

        assertEquals(27, Main.findPower(a,b));
    }

    @Test
    public void testFindPower_Test6(){
        int a = 3;
        int b = 4;

        assertEquals(81, Main.findPower(a,b));
    }
}