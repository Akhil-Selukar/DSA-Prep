package org.dsaprep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testTravelTheMaze_Test1(){
        int rows = 3;
        int columns = 3;
        List<String> ans = Main.travelPathsList("", rows, columns);

        assertEquals("DDRR", ans.get(0));
        assertEquals("DRDR", ans.get(1));
        assertEquals("DRRD", ans.get(2));
        assertEquals("RDDR", ans.get(3));
        assertEquals("RDRD", ans.get(4));
        assertEquals("RRDD", ans.get(5));
    }

    @Test
    public void testTravelTheMaze_Test2(){
        int rows = 2;
        int columns = 2;

        List<String> ans = Main.travelPathsList("", rows, columns);
        assertEquals("DR", ans.get(0));
        assertEquals("RD", ans.get(1));

    }

    @Test
    public void testTravelTheMaze_Test3(){
        int rows = 4;
        int columns = 4;

        List<String> ans = Main.travelPathsList("", rows, columns);

        assertEquals("DDDRRR", ans.get(0));
        assertEquals("DDRDRR", ans.get(1));
        assertEquals("DDRRDR", ans.get(2));
        assertEquals("DDRRRD", ans.get(3));
        assertEquals("DRDDRR", ans.get(4));
        assertEquals("DRDRDR", ans.get(5));
        assertEquals("DRDRRD", ans.get(6));
        assertEquals("DRRDDR", ans.get(7));
        assertEquals("DRRDRD", ans.get(8));
        assertEquals("DRRRDD", ans.get(9));
        assertEquals("RDDDRR", ans.get(10));
        assertEquals("RDDRDR", ans.get(11));
        assertEquals("RDDRRD", ans.get(12));
        assertEquals("RDRDDR", ans.get(13));
        assertEquals("RDRDRD", ans.get(14));
        assertEquals("RDRRDD", ans.get(15));
        assertEquals("RRDDDR", ans.get(16));
        assertEquals("RRDDRD", ans.get(17));
        assertEquals("RRDRDD", ans.get(18));
        assertEquals("RRRDDD", ans.get(19));

    }

    @Test
    public void testTravelTheMaze_Test4(){
        int rows = 5;
        int columns = 2;

        List<String> ans = Main.travelPathsList("", rows, columns);

        assertEquals("DDDDR", ans.get(0));
        assertEquals("DDDRD", ans.get(1));
        assertEquals("DDRDD", ans.get(2));
        assertEquals("DRDDD", ans.get(3));
        assertEquals("RDDDD", ans.get(4));
    }

    @Test
    public void testTravelTheMaze_Test5(){
        int rows = 3;
        int columns = 4;

        List<String> ans = Main.travelPathsList("", rows, columns);

        assertEquals("DDRRR", ans.get(0));
        assertEquals("DRDRR", ans.get(1));
        assertEquals("DRRDR", ans.get(2));
        assertEquals("DRRRD", ans.get(3));
        assertEquals("RDDRR", ans.get(4));
        assertEquals("RDRDR", ans.get(5));
        assertEquals("RDRRD", ans.get(6));
        assertEquals("RRDDR", ans.get(7));
        assertEquals("RRDRD", ans.get(8));
        assertEquals("RRRDD", ans.get(9));
    }
}