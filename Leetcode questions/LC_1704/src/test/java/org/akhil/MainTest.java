package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testHalvesAreAlike_Test1(){
        String s = "book";

        assertTrue(Main.halvesAreAlike(s));
    }

    @Test
    public void testHalvesAreAlike_Test2(){
        String s = "Textbook";

        assertFalse(Main.halvesAreAlike(s));
    }

    @Test
    public void testHalvesAreAlike_Test3(){
        String s = "Leetcode";

        assertTrue(Main.halvesAreAlike(s));
    }
}