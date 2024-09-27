package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class MainTest {

    @Test
    public void testPrintCombinations_Test1(){
        String str = "abc";

        List<String> ans = Main.printCombinations(str);

        assertTrue(ans.contains("abc"));
        assertTrue(ans.contains("ab"));
        assertTrue(ans.contains("ac"));
        assertTrue(ans.contains("bc"));
        assertTrue(ans.contains("a"));
        assertTrue(ans.contains("b"));
        assertTrue(ans.contains("c"));
    }

    @Test
    public void testPrintCombinations_Test2(){
        String str = "ab";

        List<String> ans = Main.printCombinations(str);

        assertTrue(ans.contains("ab"));
        assertTrue(ans.contains("a"));
        assertTrue(ans.contains("b"));
    }

    @Test
    public void testPrintCombinations_Test3(){
        String str = "aBcD";

        List<String> ans = Main.printCombinations(str);

        assertTrue(ans.contains("aBcD"));
        assertTrue(ans.contains("aBc"));
        assertTrue(ans.contains("aBD"));
        assertTrue(ans.contains("BcD"));
        assertTrue(ans.contains("acD"));
        assertTrue(ans.contains("aB"));
        assertTrue(ans.contains("ac"));
        assertTrue(ans.contains("aD"));
        assertTrue(ans.contains("Bc"));
        assertTrue(ans.contains("BD"));
        assertTrue(ans.contains("cD"));
        assertTrue(ans.contains("a"));
        assertTrue(ans.contains("B"));
        assertTrue(ans.contains("c"));
        assertTrue(ans.contains("D"));
    }
}