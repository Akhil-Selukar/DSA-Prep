package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testNQueensSolution_Test1(){
        int n = 1;
        boolean[][] board = new boolean[n][n];

        assertEquals(1, Main.nQueensSolution(board,0));
    }

    @Test
    public void testNQueensSolution_Test2(){
        int n = 2;
        boolean[][] board = new boolean[n][n];

        assertEquals(0, Main.nQueensSolution(board,0));
    }

    @Test
    public void testNQueensSolution_Test3(){
        int n = 3;
        boolean[][] board = new boolean[n][n];

        assertEquals(0, Main.nQueensSolution(board,0));
    }

    @Test
    public void testNQueensSolution_Test4(){
        int n = 4;
        boolean[][] board = new boolean[n][n];

        assertEquals(2, Main.nQueensSolution(board,0));
    }

    @Test
    public void testNQueensSolution_Test5(){
        int n = 5;
        boolean[][] board = new boolean[n][n];

        assertEquals(10, Main.nQueensSolution(board,0));
    }
}