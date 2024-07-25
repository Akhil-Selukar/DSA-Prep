package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void tesOddCells_Test1(){
        int m = 2;
        int n = 3;
        int[][] indices = {{0,1},{1,1}};

        assertEquals(6, Main.oddCells(m,n,indices));
    }

    @Test
    public void tesOddCells_Test2(){
        int m = 2;
        int n = 2;
        int[][] indices = {{1,1},{0,0}};

        assertEquals(0, Main.oddCells(m,n,indices));
    }
}