package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest{

    @Test
    public void testShuffle_Test_1(){
        int[] arr = {2,5,1,3,4,7};
        int n = 3;
        int[] ans = Main.shuffle(arr,n);
        assertEquals(6, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(3, ans[1]);
        assertEquals(5, ans[2]);
        assertEquals(4, ans[3]);
        assertEquals(1, ans[4]);
        assertEquals(7, ans[5]);
    }

    @Test
    public void testShuffle_Test_2(){
        int[] arr = {1,1,2,2};
        int n = 2;
        int[] ans = Main.shuffle(arr,n);
        assertEquals(4, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
        assertEquals(1, ans[2]);
        assertEquals(2, ans[3]);
    }

    @Test
    public void testShuffle_Test_3(){
        int[] arr = {1,2};
        int n = 1;
        int[] ans = Main.shuffle(arr,n);
        assertEquals(2, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }
}