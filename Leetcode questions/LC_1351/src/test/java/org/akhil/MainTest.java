package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCountNegatives_Test1(){
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        assertEquals(8, Main.countNegatives(grid));
    }

    @Test
    public void testCountNegatives_Test2(){
        int[][] grid = {{3,2},{1,0}};

        assertEquals(0, Main.countNegatives(grid));
    }

    @Test
    public void testCountNegatives_Test3(){
        int[][] grid = {{}};

        assertEquals(0, Main.countNegatives(grid));
    }

    @Test
    public void testCountNegatives_Test4(){
        int[][] grid = {{0,-1,-2,-2}};

        assertEquals(3, Main.countNegatives(grid));
    }

    @Test
    public void testCountNegatives_Test5(){
        int[][] grid = {{0},{-1},{-2},{-3}};

        assertEquals(3, Main.countNegatives(grid));
    }
}