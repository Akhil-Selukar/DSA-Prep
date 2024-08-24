package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSortArrayByParity_Test1(){
        int[] nums = {1,4,3,2};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(4, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(4, ans[1]);
        assertEquals(3, ans[2]);
        assertEquals(1, ans[3]);
    }

    @Test
    public void testSortArrayByParity_Test2(){
        int[] nums = {1};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(1, ans.length);
        assertEquals(1, ans[0]);
    }

    @Test
    public void testSortArrayByParity_Test3(){
        int[] nums = {2};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(1, ans.length);
        assertEquals(2, ans[0]);
    }

    @Test
    public void testSortArrayByParity_Test4(){
        int[] nums = {4,1};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(2, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void testSortArrayByParity_Test5(){
        int[] nums = {1,4};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(2, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void testSortArrayByParity_Test6(){
        int[] nums = {};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(0, ans.length);
    }

    @Test
    public void testSortArrayByParity_Test7(){
        int[] nums = {2,4,6,8,12,10,14,16,20,18};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(10, ans.length);
        assertEquals(2, ans[0]);
        assertEquals(4, ans[1]);
        assertEquals(6, ans[2]);
        assertEquals(8, ans[3]);
        assertEquals(12, ans[4]);
        assertEquals(10, ans[5]);
        assertEquals(14, ans[6]);
        assertEquals(16, ans[7]);
        assertEquals(20, ans[8]);
        assertEquals(18, ans[9]);
    }

    @Test
    public void testSortArrayByParity_Test8(){
        int[] nums = {1,3,9,7,5,11,17,15};

        int[] ans = Main.sortArrayByParity(nums);

        assertEquals(8, ans.length);
        assertEquals(3, ans[0]);
        assertEquals(9, ans[1]);
        assertEquals(7, ans[2]);
        assertEquals(5, ans[3]);
        assertEquals(11, ans[4]);
        assertEquals(17, ans[5]);
        assertEquals(15, ans[6]);
        assertEquals(1, ans[7]);
    }
}