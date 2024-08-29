package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testValidPalindrome_Test1(){
        String s = "abca";

        assertTrue(Main.validPalindrome(s));
    }

    @Test
    public void testValidPalindrome_Test2(){
        String s = "aba";

        assertTrue(Main.validPalindrome(s));
    }

    @Test
    public void testValidPalindrome_Test3(){
        String s = "abc";

        assertFalse(Main.validPalindrome(s));
    }

    @Test
    public void testValidPalindrome_Test4(){
        String s = "dodo";

        assertTrue(Main.validPalindrome(s));
    }

    @Test
    public void testValidPalindrome_Test5(){
        String s = "a";

        assertTrue(Main.validPalindrome(s));
    }

    @Test
    public void testValidPalindrome_Test6(){
        String s = "abababa";

        assertTrue(Main.validPalindrome(s));
    }

    @Test
    public void testValidPalindrome_Test7(){
        String s = "abdb";

        assertTrue(Main.validPalindrome(s));
    }

//    ---------------------

    @Test
    public void testValidPalindrome1_Test1(){
        String s = "abca";

        assertTrue(Main.validPalindrome1(s));
    }

    @Test
    public void testValidPalindrome1_Test2(){
        String s = "aba";

        assertTrue(Main.validPalindrome1(s));
    }

    @Test
    public void testValidPalindrome1_Test3(){
        String s = "abc";

        assertFalse(Main.validPalindrome1(s));
    }

    @Test
    public void testValidPalindrome1_Test4(){
        String s = "dodo";

        assertTrue(Main.validPalindrome1(s));
    }

    @Test
    public void testValidPalindrome1_Test5(){
        String s = "a";

        assertTrue(Main.validPalindrome1(s));
    }

    @Test
    public void testValidPalindrome1_Test6(){
        String s = "abababa";

        assertTrue(Main.validPalindrome1(s));
    }

    @Test
    public void testValidPalindrome1_Test7(){
        String s = "abdb";

        assertTrue(Main.validPalindrome1(s));
    }
}