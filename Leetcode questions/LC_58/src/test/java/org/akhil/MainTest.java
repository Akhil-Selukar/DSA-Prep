package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLengthOfLastWord_Test1(){
        String s = "   fly me   to   the moon  ";

        assertEquals(4, Main.lengthOfLastWord(s));
    }

    @Test
    public void testLengthOfLastWord_Test2(){
        String s = "Hello World";

        assertEquals(5, Main.lengthOfLastWord(s));
    }

    @Test
    public void testLengthOfLastWord_Test3(){
        String s = "Hii";

        assertEquals(3, Main.lengthOfLastWord(s));
    }

    @Test
    public void testLengthOfLastWord_Test4(){
        String s = "abcd abcdefg    ";

        assertEquals(7, Main.lengthOfLastWord(s));
    }
}