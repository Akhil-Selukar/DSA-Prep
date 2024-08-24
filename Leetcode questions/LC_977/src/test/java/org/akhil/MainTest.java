package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSortedSquares_Test1(){
        int[] nums = {-4,-1,0,3,10};

        int[] ans = Main.sortedSquares(nums);

        assertEquals(5, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(9, ans[2]);
        assertEquals(16, ans[3]);
        assertEquals(100, ans[4]);
    }

    @Test
    public void testSortedSquares_Test2(){
        int[] nums = {};

        int[] ans = Main.sortedSquares(nums);

        assertEquals(0, ans.length);
    }

    @Test
    public void testSortedSquares_Test3(){
        int[] nums = {-4,-1,0,-3,-10};

        int[] ans = Main.sortedSquares(nums);

        assertEquals(5, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(9, ans[2]);
        assertEquals(16, ans[3]);
        assertEquals(100, ans[4]);
    }

    @Test
    public void testSortedSquares_Test4(){
        int[] nums = {4,1,0,3,10};

        int[] ans = Main.sortedSquares(nums);

        assertEquals(5, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(9, ans[2]);
        assertEquals(16, ans[3]);
        assertEquals(100, ans[4]);
    }
}