package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void test_LongestCommonPrefix_Test1(){
        String[] strs = {"flower", "flow", "flight"};

        assertEquals("fl", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test2(){
        String[] strs = {"dog","racecar","car"};

        assertEquals("", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test3(){
        String[] strs = {"book","boot"};

        assertEquals("boo", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test4(){
        String[] strs = {"book","boot", "bat"};

        assertEquals("b", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test5(){
        String[] strs = {"bat","boot", "basket"};

        assertEquals("b", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test6(){
        String[] strs = {"door","dog","dot","dodo"};

        assertEquals("do", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test7(){
        String[] strs = {"door"};

        assertEquals("door", Main.longestCommonPrefix(strs));
    }

    @Test
    public void test_LongestCommonPrefix_Test8(){
        String[] strs = {"abbc","bbbc","cbbc"};

        assertEquals("", Main.longestCommonPrefix(strs));
    }
}