package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testStrStr_Test1(){
        String haystack = "sadbutsad";
        String needle = "sad";

        assertEquals(0, Main.strStr(haystack, needle));
    }

    @Test
    public void testStrStr_Test2(){
        String haystack = "Helloworld";
        String needle = "orld";

        assertEquals(6, Main.strStr(haystack, needle));
    }

    @Test
    public void testStrStr_Test3(){
        String haystack = "blueflue";
        String needle = "lue";

        assertEquals(1, Main.strStr(haystack, needle));
    }

    @Test
    public void testStrStr_Test4(){
        String haystack = "jackandjill";
        String needle = "king";

        assertEquals(-1, Main.strStr(haystack, needle));
    }
}