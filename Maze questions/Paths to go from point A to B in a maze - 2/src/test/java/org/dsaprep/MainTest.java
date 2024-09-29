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

        assertEquals("XX", ans.get(0));
        assertEquals("XDR", ans.get(1));
        assertEquals("XRD", ans.get(2));
        assertEquals("DXR", ans.get(3));
        assertEquals("DDRR", ans.get(4));
        assertEquals("DRX", ans.get(5));
        assertEquals("DRDR", ans.get(6));
        assertEquals("DRRD", ans.get(7));
        assertEquals("RXD", ans.get(8));
        assertEquals("RDX", ans.get(9));
        assertEquals("RDDR", ans.get(10));
        assertEquals("RDRD", ans.get(11));
        assertEquals("RRDD", ans.get(12));
    }

    @Test
    public void testTravelTheMaze_Test2(){
        int rows = 2;
        int columns = 2;

        List<String> ans = Main.travelPathsList("", rows, columns);
        assertEquals("X", ans.get(0));
        assertEquals("DR", ans.get(1));
        assertEquals("RD", ans.get(2));

    }

    @Test
    public void testTravelTheMaze_Test3(){
        int rows = 5;
        int columns = 2;

        List<String> ans = Main.travelPathsList("", rows, columns);

        assertEquals("XDDD", ans.get(0));
        assertEquals("DXDD", ans.get(1));
        assertEquals("DDXD", ans.get(2));
        assertEquals("DDDX", ans.get(3));
        assertEquals("DDDDR", ans.get(4));
        assertEquals("DDDRD", ans.get(5));
        assertEquals("DDRDD", ans.get(6));
        assertEquals("DRDDD", ans.get(7));
        assertEquals("RDDDD", ans.get(8));

    }

    @Test
    public void testTravelTheMaze_Test4(){
        int rows = 3;
        int columns = 4;

        List<String> ans = Main.travelPathsList("", rows, columns);

        assertEquals("XXR", ans.get(0));
        assertEquals("XDRR", ans.get(1));
        assertEquals("XRX", ans.get(2));
        assertEquals("XRDR", ans.get(3));
        assertEquals("XRRD", ans.get(4));
        assertEquals("DXRR", ans.get(5));
        assertEquals("DDRRR", ans.get(6));
        assertEquals("DRXR", ans.get(7));
        assertEquals("DRDRR", ans.get(8));
        assertEquals("DRRX", ans.get(9));
        assertEquals("DRRDR", ans.get(10));
        assertEquals("DRRRD", ans.get(11));
        assertEquals("RXX", ans.get(12));
        assertEquals("RXDR", ans.get(13));
        assertEquals("RXRD", ans.get(14));
        assertEquals("RDXR", ans.get(15));
        assertEquals("RDDRR", ans.get(16));
        assertEquals("RDRX", ans.get(17));
        assertEquals("RDRDR", ans.get(18));
        assertEquals("RDRRD", ans.get(19));
        assertEquals("RRXD", ans.get(20));
        assertEquals("RRDX", ans.get(21));
        assertEquals("RRDDR", ans.get(22));
        assertEquals("RRDRD", ans.get(23));
        assertEquals("RRRDD", ans.get(24));
    }
}