package org.dsaprep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSearchMatrix_Test1(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 1;

        int[] ans = Main.search(matrix, target);
        assertEquals(0, ans[0]);
        assertEquals(0, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test2(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 2;

        int[] ans = Main.search(matrix, target);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test3(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 3;

        int[] ans = Main.search(matrix, target);
        assertEquals(0, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test4(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 4;

        int[] ans = Main.search(matrix, target);
        assertEquals(0, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test5(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 5;

        int[] ans = Main.search(matrix, target);
        assertEquals(1, ans[0]);
        assertEquals(0, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test6(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 6;

        int[] ans = Main.search(matrix, target);
        assertEquals(1, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test7(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 7;

        int[] ans = Main.search(matrix, target);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test8(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 8;

        int[] ans = Main.search(matrix, target);
        assertEquals(1, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test9(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 9;

        int[] ans = Main.search(matrix, target);
        assertEquals(2, ans[0]);
        assertEquals(0, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test10(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 10;

        int[] ans = Main.search(matrix, target);
        assertEquals(2, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test11(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 11;

        int[] ans = Main.search(matrix, target);
        assertEquals(2, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test12(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 12;

        int[] ans = Main.search(matrix, target);
        assertEquals(2, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testSearchMatrix_Test13(){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int target = 55;

        int[] ans = Main.search(matrix, target);
        assertEquals(-1, ans[0]);
        assertEquals(-1, ans[1]);
    }
}