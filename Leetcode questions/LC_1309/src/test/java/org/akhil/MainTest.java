package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFreqAlphabets_Test1(){
        String s = "10#11#125";

        assertEquals("jkabe", Main.freqAlphabets(s));
    }

    @Test
    public void testFreqAlphabets_Test2(){
        String s = "12121212";

        assertEquals("abababab", Main.freqAlphabets(s));
    }

    @Test
    public void testFreqAlphabets_Test3(){
        String s = "1326#";

        assertEquals("acz", Main.freqAlphabets(s));
    }

    @Test
    public void testFreqAlphabets_Test4(){
        String s = "26#26#26#26#";

        assertEquals("zzzz", Main.freqAlphabets(s));
    }
}