package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testDiagonalSum_Test1(){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

        assertEquals(25, Main.diagonalSum(mat));
    }

    @Test
    public void testDiagonalSum_Test2(){
        int[][] mat = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};

        assertEquals(8, Main.diagonalSum(mat));
    }

    @Test
    public void testDiagonalSum_Test3(){
        int[][] mat = {{1}};

        assertEquals(1, Main.diagonalSum(mat));
    }

    @Test
    public void testDiagonalSum_Test4(){
        int[][] mat = {{1,2},{3,4}};

        assertEquals(10, Main.diagonalSum(mat));
    }
}