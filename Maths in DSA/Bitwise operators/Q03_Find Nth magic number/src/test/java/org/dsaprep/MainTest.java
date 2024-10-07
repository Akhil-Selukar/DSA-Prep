package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testGetMagicNumber_Test1(){
        int n = 1;

        assertEquals(5, Main.getMagicNumber(n));
    }

    @Test
    public void testGetMagicNumber_Test2(){
        int n = 2;

        assertEquals(25, Main.getMagicNumber(n));
    }

    @Test
    public void testGetMagicNumber_Test3(){
        int n = 3;

        assertEquals(30, Main.getMagicNumber(n));
    }

    @Test
    public void testGetMagicNumber_Test4(){
        int n = 4;

        assertEquals(125, Main.getMagicNumber(n));
    }

    @Test
    public void testGetMagicNumber_Test5(){
        int n = 5;

        assertEquals(130, Main.getMagicNumber(n));
    }

    @Test
    public void testGetMagicNumber_Test6(){
        int n = 6;

        assertEquals(150, Main.getMagicNumber(n));
    }

    @Test
    public void testGetMagicNumber_Test7(){
        int n = 7;

        assertEquals(155, Main.getMagicNumber(n));
    }
}