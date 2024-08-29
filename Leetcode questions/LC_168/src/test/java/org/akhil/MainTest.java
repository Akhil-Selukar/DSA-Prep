package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testConvertToTitle_Test1(){
        int columnNumber = 701; // ZY

        assertEquals("ZY", Main.convertToTitle(columnNumber));
    }

    @Test
    public void testConvertToTitle_Test2(){
        int columnNumber = 1; // A

        assertEquals("A", Main.convertToTitle(columnNumber));
    }

    @Test
    public void testConvertToTitle_Test3(){
        int columnNumber = 25; // ZY

        assertEquals("Y", Main.convertToTitle(columnNumber));
    }

    @Test
    public void testConvertToTitle_Test4(){
        int columnNumber = 27; // ZY

        assertEquals("AA", Main.convertToTitle(columnNumber));
    }

    @Test
    public void testConvertToTitle_Test5(){
        int columnNumber = 28; // ZY

        assertEquals("AB", Main.convertToTitle(columnNumber));
    }

    @Test
    public void testConvertToTitle_Test6(){
        int columnNumber = 2002; // ZY

        assertEquals("BXZ", Main.convertToTitle(columnNumber));
    }
}