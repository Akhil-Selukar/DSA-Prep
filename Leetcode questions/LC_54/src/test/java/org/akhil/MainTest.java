package org.akhil;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSpiralOrder_Test1(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(9, ans.size());
        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
        assertEquals(6, (int)ans.get(3));
        assertEquals(9, (int)ans.get(4));
        assertEquals(8, (int)ans.get(5));
        assertEquals(7, (int)ans.get(6));
        assertEquals(4, (int)ans.get(7));
        assertEquals(5, (int)ans.get(8));
    }

    @Test
    public void testSpiralOrder_Test2(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(12, ans.size());
        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
        assertEquals(4, (int)ans.get(3));
        assertEquals(8, (int)ans.get(4));
        assertEquals(12, (int)ans.get(5));
        assertEquals(11, (int)ans.get(6));
        assertEquals(10, (int)ans.get(7));
        assertEquals(9, (int)ans.get(8));
        assertEquals(5, (int)ans.get(9));
        assertEquals(6, (int)ans.get(10));
        assertEquals(7, (int)ans.get(11));
    }

    @Test
    public void testSpiralOrder_Test3(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(12, ans.size());
        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
        assertEquals(6, (int)ans.get(3));
        assertEquals(9, (int)ans.get(4));
        assertEquals(12, (int)ans.get(5));
        assertEquals(11, (int)ans.get(6));
        assertEquals(10, (int)ans.get(7));
        assertEquals(7, (int)ans.get(8));
        assertEquals(4, (int)ans.get(9));
        assertEquals(5, (int)ans.get(10));
        assertEquals(8, (int)ans.get(11));
    }

    @Test
    public void testSpiralOrder_Test4(){
        int[][] matrix = {{1,2,3},{4,5,6}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(6, ans.size());
        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
        assertEquals(6, (int)ans.get(3));
        assertEquals(5, (int)ans.get(4));
        assertEquals(4, (int)ans.get(5));
    }

    @Test
    public void testSpiralOrder_Test5(){
        int[][] matrix = {{1,2,3}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(3, ans.size());
        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
    }

    @Test
    public void testSpiralOrder_Test6(){
        int[][] matrix = {{1}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(1, ans.size());
        assertEquals(1, (int)ans.get(0));
    }

    @Test
    public void testSpiralOrder_Test7(){
        int[][] matrix = {{1},{2},{3},{4}};

        List<Integer> ans = Main.spiralOrder(matrix);

        assertEquals(4, ans.size());
        assertEquals(1, (int)ans.get(0));
        assertEquals(2, (int)ans.get(1));
        assertEquals(3, (int)ans.get(2));
        assertEquals(4, (int)ans.get(3));
    }
}