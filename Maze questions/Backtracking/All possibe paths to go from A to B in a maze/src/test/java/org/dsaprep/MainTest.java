package org.dsaprep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testPrintAllPaths_Test1(){
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}};

        List<String> ans = Main.printAllPaths(maze);

        assertEquals("DDRR", ans.get(0));
        assertEquals("DDRURD", ans.get(1));
        assertEquals("DDRUURDD", ans.get(2));
        assertEquals("DRDR", ans.get(3));
        assertEquals("DRRD", ans.get(4));
        assertEquals("DRURDD", ans.get(5));
        assertEquals("RDDR", ans.get(6));
        assertEquals("RDRD", ans.get(7));
        assertEquals("RDLDRR", ans.get(8));
        assertEquals("RRDD", ans.get(9));
        assertEquals("RRDLDR", ans.get(10));
        assertEquals("RRDLLDRR", ans.get(11));
    }

    @Test
    public void testPrintAllPaths_Test2(){
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}};

        List<String> ans = Main.printAllPaths(maze);

        assertEquals("DDRR", ans.get(0));
        assertEquals("RRDD", ans.get(1));
    }

    @Test
    public void testPrintAllPaths_Test3(){
        boolean[][] maze = {
                {true, false, true},
                {true, true, true},
                {true, true, true}};

        List<String> ans = Main.printAllPaths(maze);

        assertEquals("DDRR", ans.get(0));
        assertEquals("DDRURD", ans.get(1));
        assertEquals("DRDR", ans.get(2));
        assertEquals("DRRD", ans.get(3));
    }
}