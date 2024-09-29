package org.dsaprep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testFindMazePath_Test1(){
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}};

        List<String> ans = Main.findMazePath(maze);

        assertEquals(2, ans.size());
        assertEquals("DDRR", ans.get(0));
        assertEquals("RRDD", ans.get(1));
    }

    @Test
    public void testFindMazePath_Test2(){
        boolean[][] maze = {
                {true, true, true, true},
                {true, false, true, false},
                {true, false, false, true},
                {true, true, true, true}};

        List<String> ans = Main.findMazePath(maze);

        assertEquals(1, ans.size());
        assertEquals("DDDRRR", ans.get(0));
    }

    @Test
    public void testFindMazePath_Test3(){
        boolean[][] maze = {
                {true, true, false, true, true, true},
                {true, true, true, true, true, true},
                {true, true, true, true, true, true}};

        List<String> ans = Main.findMazePath(maze);

        assertEquals(11, ans.size());
        assertEquals("DDRRRRR", ans.get(0));
        assertEquals("DRDRRRR", ans.get(1));
        assertEquals("DRRDRRR", ans.get(2));
        assertEquals("DRRRDRR", ans.get(3));
        assertEquals("DRRRRDR", ans.get(4));
        assertEquals("DRRRRRD", ans.get(5));
        assertEquals("RDDRRRR", ans.get(6));
        assertEquals("RDRDRRR", ans.get(7));
        assertEquals("RDRRDRR", ans.get(8));
        assertEquals("RDRRRDR", ans.get(9));
        assertEquals("RDRRRRD", ans.get(10));
    }
}