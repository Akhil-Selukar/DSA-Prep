package org.dsaprep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {
    @Test
    public void testPermutations_Test1(){
        String str = "abc";
        List<String> ans = Main.permutations(str);

        assertEquals(6, ans.size());
        assertTrue(ans.contains("cba"));
        assertTrue(ans.contains("bca"));
        assertTrue(ans.contains("bac"));
        assertTrue(ans.contains("cab"));
        assertTrue(ans.contains("acb"));
        assertTrue(ans.contains("abc"));
        assertEquals("cba", ans.get(0));
        assertEquals("bca", ans.get(1));
        assertEquals("bac", ans.get(2));
        assertEquals("cab", ans.get(3));
        assertEquals("acb", ans.get(4));
        assertEquals("abc", ans.get(5));
    }

    @Test
    public void testPermutations_Test2(){
        String str = "abcd";
        List<String> ans = Main.permutations(str);

        assertEquals(24, ans.size());
        assertEquals("dcba", ans.get(0));
        assertEquals("cdba", ans.get(1));
        assertEquals("cbda", ans.get(2));
        assertEquals("cbad", ans.get(3));
        assertEquals("dbca", ans.get(4));
        assertEquals("bdca", ans.get(5));
        assertEquals("bcda", ans.get(6));
        assertEquals("bcad", ans.get(7));
        assertEquals("dbac", ans.get(8));
        assertEquals("bdac", ans.get(9));
        assertEquals("badc", ans.get(10));
        assertEquals("bacd", ans.get(11));
        assertEquals("dcab", ans.get(12));
        assertEquals("cdab", ans.get(13));
        assertEquals("cadb", ans.get(14));
        assertEquals("cabd", ans.get(15));
        assertEquals("dacb", ans.get(16));
        assertEquals("adcb", ans.get(17));
        assertEquals("acdb", ans.get(18));
        assertEquals("acbd", ans.get(19));
        assertEquals("dabc", ans.get(20));
        assertEquals("adbc", ans.get(21));
        assertEquals("abdc", ans.get(22));
        assertEquals("abcd", ans.get(23));
    }
}