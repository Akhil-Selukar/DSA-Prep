package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

// In this question it is important to focus on word "concatenated" in first sentence.
// "For a string sequence, a string word is k-repeating if word ****concatenated**** k times is a substring of sequence."
public class MainTest {

    @Test
    public void testMaxRepeating_Test1(){
        String sequence = "ababc";
        String word = "ab";

        assertEquals(2, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test2(){
        String sequence = "ababc";
        String word = "b";

        assertEquals(1, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test3(){
        String sequence = "ababc";
        String word = "ba";

        assertEquals(1, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test4(){
        String sequence = "ababc";
        String word = "ac";

        assertEquals(0, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test5(){
        String sequence = "ababc";
        String word = "aba";

        assertEquals(1, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test6(){
        String sequence = "ababc";
        String word = "ababc";

        assertEquals(1, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test7(){
        String sequence = "ababc";
        String word = "aab";

        assertEquals(0, Main.maxRepeating(sequence,word));
    }

    @Test
    public void testMaxRepeating_Test8(){
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";

        assertEquals(5, Main.maxRepeating(sequence,word));
    }
}