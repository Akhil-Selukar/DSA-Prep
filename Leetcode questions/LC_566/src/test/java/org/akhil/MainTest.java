package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void TestMatrixReshape_Test1(){
        int[][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 4;

        int[][] ans = Main.matrixReshape(mat, r,c);

        assertEquals(1, ans[0][0]);
        assertEquals(2, ans[0][1]);
        assertEquals(3, ans[0][2]);
        assertEquals(4, ans[0][3]);
    }

    @Test
    public void TestMatrixReshape_Test2(){
        int[][] mat = {{1,2},{3,4}};
        int r = 4;
        int c = 1;

        int[][] ans = Main.matrixReshape(mat, r,c);

        assertEquals(1, ans[0][0]);
        assertEquals(2, ans[1][0]);
        assertEquals(3, ans[2][0]);
        assertEquals(4, ans[3][0]);
    }

    @Test
    public void TestMatrixReshape_Test3(){
        int[][] mat = {{1,2}};
        int r = 1;
        int c = 1;

        int[][] ans = Main.matrixReshape(mat, r,c);
        assertEquals(1, ans[0][0]);
    }

    @Test
    public void TestMatrixReshape_Test4(){
        int[][] mat = {{1,2},{3,4}};
        int r = 2;
        int c = 4;

        int[][] ans = Main.matrixReshape(mat, r,c);
        assertEquals(1, ans[0][0]);
        assertEquals(2, ans[0][1]);
        assertEquals(3, ans[1][0]);
        assertEquals(4, ans[1][1]);
    }
}