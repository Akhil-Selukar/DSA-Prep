package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testReversePrefix_Test1(){
        String word = "abcdefd";
        char ch = 'd';

        assertEquals("dcbaefd", Main.reversePrefix(word, ch));
    }

    @Test
    public void testReversePrefix_Test2(){
        String word = "abcdefd";
        char ch = 'z';

        assertEquals("abcdefd", Main.reversePrefix(word, ch));
    }

    @Test
    public void testReversePrefix_Test3(){
        String word = "abcdefd";
        char ch = 'c';

        assertEquals("cbadefd", Main.reversePrefix(word, ch));
    }

    @Test
    public void testReversePrefix_Test4(){
        String word = "abcdefd";
        char ch = 'b';

        assertEquals("bacdefd", Main.reversePrefix(word, ch));
    }
}