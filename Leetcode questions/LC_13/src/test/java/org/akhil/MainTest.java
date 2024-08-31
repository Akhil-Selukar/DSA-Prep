package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testRomanToInt_Test1(){
        String s = "MCMXCIV";

        assertEquals(1994, Main.romanToInt(s));
    }

    @Test
    public void testRomanToInt_Test2(){
        String s = "IV";

        assertEquals(4, Main.romanToInt(s));
    }

    @Test
    public void testRomanToInt_Test3(){
        String s = "III";

        assertEquals(3, Main.romanToInt(s));
    }

    @Test
    public void testRomanToInt_Test4(){
        String s = "MIX";

        assertEquals(1009, Main.romanToInt(s));
    }

    @Test
    public void testRomanToInt1_Test1(){
        String s = "MCMXCIV";

        assertEquals(1994, Main.romanToInt1(s));
    }

    @Test
    public void testRomanToInt1_Test2(){
        String s = "IV";

        assertEquals(4, Main.romanToInt1(s));
    }

    @Test
    public void testRomanToInt1_Test3(){
        String s = "III";

        assertEquals(3, Main.romanToInt1(s));
    }

    @Test
    public void testRomanToInt1_Test4(){
        String s = "MIX";

        assertEquals(1009, Main.romanToInt1(s));
    }
}