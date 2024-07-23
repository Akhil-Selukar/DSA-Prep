package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testRunningSum_TestCase_1(){
        int[] arr = {1,2,3,4};
        int [] ans = Main.runningSum(arr);

        assertEquals(4, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(3, ans[1]);
        assertEquals(6, ans[2]);
        assertEquals(10, ans[3]);
    }

    @Test
    public void testRunningSum_TestCase_2(){
        int[] arr = {0,0,3,4,0,6};
        int [] ans = Main.runningSum(arr);

        assertEquals(6, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(7, ans[3]);
        assertEquals(7, ans[4]);
        assertEquals(13, ans[5]);
    }

    @Test
    public void testRunningSum_TestCase_3(){
        int[] arr = {1,-1,2,4,-3};
        int [] ans = Main.runningSum(arr);

        assertEquals(5, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(0, ans[1]);
        assertEquals(2, ans[2]);
        assertEquals(6, ans[3]);
        assertEquals(3, ans[4]);
    }

}