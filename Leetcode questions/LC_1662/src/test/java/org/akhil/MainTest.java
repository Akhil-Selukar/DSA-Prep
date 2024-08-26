package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testArrayStringsAreEqual_Test1(){
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        assertTrue(Main.arrayStringsAreEqual(word1, word2));
    }

    @Test
    public void testArrayStringsAreEqual_Test2(){
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "c"};

        assertFalse(Main.arrayStringsAreEqual(word1, word2));
    }

    @Test
    public void testArrayStringsAreEqual_Test3(){
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};

        assertTrue(Main.arrayStringsAreEqual(word1, word2));
    }
}