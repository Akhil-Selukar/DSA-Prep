package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSortSentence_Test1(){
        String s = "is2 sentence4 This1 a3";

        assertEquals("This is a sentence", Main.sortSentence(s));
        assertEquals("This is a sentence", Main.sortSentence1(s));
    }

    @Test
    public void testSortSentence_Test2(){
        String s = "Myself2 Me1 I4 and3";

        assertEquals("Me Myself and I", Main.sortSentence(s));
        assertEquals("Me Myself and I", Main.sortSentence1(s));
    }

    @Test
    public void testSortSentence_Test3(){
        String s = "Let's1 party3 go2";

        assertEquals("Let's go party", Main.sortSentence(s));
        assertEquals("Let's go party", Main.sortSentence1(s));
    }
}