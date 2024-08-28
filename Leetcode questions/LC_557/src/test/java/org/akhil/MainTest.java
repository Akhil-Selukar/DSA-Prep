package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testReverseWords_Test1(){
        String s = "Let's take LeetCode contest";

        assertEquals("s'teL ekat edoCteeL tsetnoc", Main.reverseWords(s));
    }

    @Test
    public void testReverseWords_Test2(){
        String s = "Mr Ding";

        assertEquals("rM gniD", Main.reverseWords(s));
    }

    @Test
    public void testReverseWords_Test3(){
        String s = "A";

        assertEquals("A", Main.reverseWords(s));
    }

    @Test
    public void testReverseWords_Test4(){
        String s = "AbCdEfG";

        assertEquals("GfEdCbA", Main.reverseWords(s));
    }

    @Test
    public void testReverseWords_Test5(){
        String s = "Aa Bb Cc Dd EeFf";

        assertEquals("aA bB cC dD fFeE", Main.reverseWords(s));
    }

    @Test
    public void testReverseWords1_Test1(){
        String s = "Let's take LeetCode contest";

        assertEquals("s'teL ekat edoCteeL tsetnoc", Main.reverseWords1(s));
    }

    @Test
    public void testReverseWords1_Test2(){
        String s = "Mr Ding";

        assertEquals("rM gniD", Main.reverseWords1(s));
    }

    @Test
    public void testReverseWords1_Test3(){
        String s = "A";

        assertEquals("A", Main.reverseWords1(s));
    }

    @Test
    public void testReverseWords1_Test4(){
        String s = "AbCdEfG";

        assertEquals("GfEdCbA", Main.reverseWords1(s));
    }

    @Test
    public void testReverseWords1_Test5(){
        String s = "Aa Bb Cc Dd EeFf";

        assertEquals("aA bB cC dD fFeE", Main.reverseWords1(s));
    }
}