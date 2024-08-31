package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMergeAlternately_Test1(){
        String word1 = "abc";
        String word2 = "pqr";

        assertEquals("apbqcr", Main.mergeAlternately(word1, word2));
    }

    @Test
    public void testMergeAlternately_Test2(){
        String word1 = "ab";
        String word2 = "pqrs";

        assertEquals("apbqrs", Main.mergeAlternately(word1, word2));
    }

    @Test
    public void testMergeAlternately_Test3(){
        String word1 = "abcd";
        String word2 = "pq";

        assertEquals("apbqcd", Main.mergeAlternately(word1, word2));
    }

    @Test
    public void testMergeAlternately_Test4(){
        String word1 = "";
        String word2 = "pqrs";

        assertEquals("pqrs", Main.mergeAlternately(word1, word2));
    }

    @Test
    public void testMergeAlternately_Test5(){
        String word1 = "abcd";
        String word2 = "";

        assertEquals("abcd", Main.mergeAlternately(word1, word2));
    }
}