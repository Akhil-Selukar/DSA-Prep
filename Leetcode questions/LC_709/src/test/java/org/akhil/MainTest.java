package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testToLowerCase_Test1(){
        String s = "Hello";

        assertEquals("hello", Main.toLowerCase(s));
    }

    @Test
    public void testToLowerCase_Test2(){
        String s = "Leetcode";

        assertEquals("leetcode", Main.toLowerCase(s));
    }

    @Test
    public void testToLowerCase_Test3(){
        String s = "JAVA";

        assertEquals("java", Main.toLowerCase(s));
    }

    @Test
    public void testToLowerCase_Test4(){
        String s = "PrOgRamMiNG";

        assertEquals("programming", Main.toLowerCase(s));
    }

    @Test
    public void testToLowerCase_Test5(){
        String s = "Jack & Jill";

        assertEquals("jack & jill", Main.toLowerCase(s));
    }
}