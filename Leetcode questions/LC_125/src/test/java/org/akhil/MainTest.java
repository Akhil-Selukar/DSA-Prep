package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class MainTest {

    @Test
    public void testIsPalindrome_Test1(){
        String s = "A man, a plan, a canal: Panama";

        assertTrue(Main.isPalindrome(s));
    }

    @Test
    public void testIsPalindrome_Test2(){
        String s = "race a car";

        assertFalse(Main.isPalindrome(s));
    }

    @Test
    public void testIsPalindrome_Test3(){
        String s = " ";

        assertTrue(Main.isPalindrome(s));
    }

    @Test
    public void testIsPalindrome_Test4(){
        String s = "1234321";

        assertTrue(Main.isPalindrome(s));
    }

    @Test
    public void testIsPalindrome_Test5(){
        String s = "!@#$%^&*()abc123*&^%$";

        assertFalse(Main.isPalindrome(s));
    }

    @Test
    public void testIsPalindrome_Test6(){
        String s = "ababa";

        assertTrue(Main.isPalindrome(s));
    }
}