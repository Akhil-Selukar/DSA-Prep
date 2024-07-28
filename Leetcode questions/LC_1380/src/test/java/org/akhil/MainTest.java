package org.akhil;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testLuckyNumbers_Test1(){
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};

        List<Integer> ans = Main.luckyNumbers(matrix);

        assertEquals(1, ans.size());
        assertEquals(15, (int)ans.get(0));
    }

    @Test
    public void testLuckyNumbers_Test2(){
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};

        List<Integer> ans = Main.luckyNumbers(matrix);

        assertEquals(1, ans.size());
        assertEquals(12, (int)ans.get(0));
    }

    @Test
    public void testLuckyNumbers_Test3(){
        int[][] matrix = {{7,8},{1,2}};

        List<Integer> ans = Main.luckyNumbers(matrix);

        assertEquals(1, ans.size());
        assertEquals(7, (int)ans.get(0));
    }
}