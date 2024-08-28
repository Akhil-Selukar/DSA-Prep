package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testNumOfStrings_Test1(){
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";

        assertEquals(3, Main.numOfStrings(patterns, word));
    }

    @Test
    public void testNumOfStrings_Test2(){
        String[] patterns = {"a","b","c"};
        String word = "aaaaabbbbb";

        assertEquals(2, Main.numOfStrings(patterns, word));
    }

    @Test
    public void testNumOfStrings_Test3(){
        String[] patterns = {"a","a","a"};
        String word = "ab";

        assertEquals(3, Main.numOfStrings(patterns, word));
    }

    @Test
    public void testNumOfStrings_Test4(){
        String[] patterns = {"a","a","a"};
        String word = "bcd";

        assertEquals(0, Main.numOfStrings(patterns, word));
    }

    @Test
    public void testNumOfStrings_Test5(){
        String[] patterns = {"a","abc","a"};
        String word = "bcda";

        assertEquals(2, Main.numOfStrings(patterns, word));
    }
}