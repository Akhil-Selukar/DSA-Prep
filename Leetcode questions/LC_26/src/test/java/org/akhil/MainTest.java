package org.akhil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testRemoveDuplicates_Test1(){
        int[] nums = {1,1,2};

        int duplicate = Main.removeDuplicates(nums);
        assertEquals(2, duplicate);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    public void testRemoveDuplicates_Test2(){
        int[] nums = {1,2,3,4};

        int duplicate = Main.removeDuplicates(nums);
        assertEquals(4, duplicate);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
    }

    @Test
    public void testRemoveDuplicates_Test3(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int duplicate = Main.removeDuplicates(nums);
        assertEquals(5, duplicate);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    public void testRemoveDuplicates_Test4(){
        int[] nums = {1,1,1,1,1,1,1};

        int duplicate = Main.removeDuplicates(nums);
        assertEquals(1, duplicate);
        assertEquals(1, nums[0]);
    }

    @Test
    public void testRemoveDuplicates2_Test1(){
        int[] nums = {1,1,2};

        int duplicate = Main.removeDuplicates2(nums);
        assertEquals(2, duplicate);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    public void testRemoveDuplicates2_Test2(){
        int[] nums = {1,2,3,4};

        int duplicate = Main.removeDuplicates2(nums);
        assertEquals(4, duplicate);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
        assertEquals(4, nums[3]);
    }

    @Test
    public void testRemoveDuplicates2_Test3(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int duplicate = Main.removeDuplicates2(nums);
        assertEquals(5, duplicate);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }

    @Test
    public void testRemoveDuplicates2_Test4(){
        int[] nums = {1,1,1,1,1,1,1};

        int duplicate = Main.removeDuplicates2(nums);
        assertEquals(1, duplicate);
        assertEquals(1, nums[0]);
    }
}