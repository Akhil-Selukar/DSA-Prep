package org.akhil;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLetterCombinations_Test1(){
        String digits = "23";
        List<String> ans = Main.letterCombinations(digits);

        assertEquals(9, ans.size());
        assertEquals("ad", ans.get(0));
        assertEquals("ae", ans.get(1));
        assertEquals("af", ans.get(2));
        assertEquals("bd", ans.get(3));
        assertEquals("be", ans.get(4));
        assertEquals("bf", ans.get(5));
        assertEquals("cd", ans.get(6));
        assertEquals("ce", ans.get(7));
        assertEquals("cf", ans.get(8));
    }

    @Test
    public void testLetterCombinations_Test2(){
        String digits = "2";
        List<String> ans = Main.letterCombinations(digits);

        assertEquals(3, ans.size());
        assertEquals("a", ans.get(0));
        assertEquals("b", ans.get(1));
        assertEquals("c", ans.get(2));
    }

    @Test
    public void testLetterCombinations_Test3(){
        String digits = "9";
        List<String> ans = Main.letterCombinations(digits);

        assertEquals(4, ans.size());
        assertEquals("w", ans.get(0));
        assertEquals("x", ans.get(1));
        assertEquals("y", ans.get(2));
        assertEquals("z", ans.get(3));
    }

    @Test
    public void testLetterCombinations_Test4(){
        String digits = "";
        List<String> ans = Main.letterCombinations(digits);

        assertEquals(0, ans.size());
    }

    @Test
    public void testLetterCombinations_Test5(){
        String digits = "234";
        List<String> ans = Main.letterCombinations(digits);

        assertEquals(27, ans.size());
        assertEquals("adg", ans.get(0));
        assertEquals("adh", ans.get(1));
        assertEquals("adi", ans.get(2));
        assertEquals("aeg", ans.get(3));
        assertEquals("aeh", ans.get(4));
        assertEquals("aei", ans.get(5));
        assertEquals("afg", ans.get(6));
        assertEquals("afh", ans.get(7));
        assertEquals("afi", ans.get(8));
        assertEquals("bdg", ans.get(9));
        assertEquals("bdh", ans.get(10));
        assertEquals("bdi", ans.get(11));
        assertEquals("beg", ans.get(12));
        assertEquals("beh", ans.get(13));
        assertEquals("bei", ans.get(14));
        assertEquals("bfg", ans.get(15));
        assertEquals("bfh", ans.get(16));
        assertEquals("bfi", ans.get(17));
        assertEquals("cdg", ans.get(18));
        assertEquals("cdh", ans.get(19));
        assertEquals("cdi", ans.get(20));
        assertEquals("ceg", ans.get(21));
        assertEquals("ceh", ans.get(22));
        assertEquals("cei", ans.get(23));
        assertEquals("cfg", ans.get(24));
        assertEquals("cfh", ans.get(25));
        assertEquals("cfi", ans.get(26));
    }
}