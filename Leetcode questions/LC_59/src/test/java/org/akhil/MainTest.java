package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testGenerateMatrix_Test1(){
        int n=3;

        int[][] ans = Main.generateMatrix(n);

        assertEquals(1, ans[0][0]);
        assertEquals(2, ans[0][1]);
        assertEquals(3, ans[0][2]);
        assertEquals(8, ans[1][0]);
        assertEquals(9, ans[1][1]);
        assertEquals(4, ans[1][2]);
        assertEquals(7, ans[2][0]);
        assertEquals(6, ans[2][1]);
        assertEquals(5, ans[2][2]);
    }

    @Test
    public void testGenerateMatrix_Test2(){
        int n=2;

        int[][] ans = Main.generateMatrix(n);

        assertEquals(1, ans[0][0]);
        assertEquals(2, ans[0][1]);
        assertEquals(4, ans[1][0]);
        assertEquals(3, ans[1][1]);
    }

    @Test
    public void testGenerateMatrix_Test3(){
        int n=4;

        int[][] ans = Main.generateMatrix(n);

        assertEquals(1, ans[0][0]);
        assertEquals(2, ans[0][1]);
        assertEquals(3, ans[0][2]);
        assertEquals(4, ans[0][3]);
        assertEquals(12, ans[1][0]);
        assertEquals(13, ans[1][1]);
        assertEquals(14, ans[1][2]);
        assertEquals(5, ans[1][3]);
        assertEquals(11, ans[2][0]);
        assertEquals(16, ans[2][1]);
        assertEquals(15, ans[2][2]);
        assertEquals(6, ans[2][3]);
        assertEquals(10, ans[3][0]);
        assertEquals(9, ans[3][1]);
        assertEquals(8, ans[3][2]);
        assertEquals(7, ans[3][3]);
    }
}