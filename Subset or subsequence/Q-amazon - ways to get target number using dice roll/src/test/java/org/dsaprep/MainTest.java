package org.dsaprep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testDice_Test1(){
        int target = 4;

        List<String> ans = Main.dice(target);

        assertEquals("1111", ans.get(0));
        assertEquals("112", ans.get(1));
        assertEquals("121", ans.get(2));
        assertEquals("13", ans.get(3));
        assertEquals("211", ans.get(4));
        assertEquals("22", ans.get(5));
        assertEquals("31", ans.get(6));
        assertEquals("4", ans.get(7));
    }

    @Test
    public void testDice_Test2(){
        int target = 1;

        List<String> ans = Main.dice(target);

        assertEquals("1", ans.get(0));
    }

    @Test
    public void testDice_Test3(){
        int target = 2;

        List<String> ans = Main.dice(target);

        assertEquals("11", ans.get(0));
        assertEquals("2", ans.get(1));
    }

    @Test
    public void testDice_Test4(){
        int target = 5;

        List<String> ans = Main.dice(target);

        assertEquals("11111", ans.get(0));
        assertEquals("1112", ans.get(1));
        assertEquals("1121", ans.get(2));
        assertEquals("113", ans.get(3));
        assertEquals("1211", ans.get(4));
        assertEquals("122", ans.get(5));
        assertEquals("131", ans.get(6));
        assertEquals("14", ans.get(7));
        assertEquals("2111", ans.get(8));
        assertEquals("212", ans.get(9));
        assertEquals("221", ans.get(10));
        assertEquals("23", ans.get(11));
        assertEquals("311", ans.get(12));
        assertEquals("32", ans.get(13));
        assertEquals("41", ans.get(14));
        assertEquals("5", ans.get(15));
    }

    @Test
    public void testDice_Test5(){
        int target = 3;

        List<String> ans = Main.dice(target);

        assertEquals("111", ans.get(0));
        assertEquals("12", ans.get(1));
        assertEquals("21", ans.get(2));
        assertEquals("3", ans.get(3));
    }
}