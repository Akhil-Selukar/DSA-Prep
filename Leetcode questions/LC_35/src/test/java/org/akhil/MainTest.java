package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSearchInsert_Test1(){
        int[] nums = {1,3,5,6};
        int target = 5;

        assertEquals(2, Main.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsert_Test2(){
        int[] nums = {1,3,5,6};
        int target = 2;

        assertEquals(1, Main.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsert_Test3(){
        int[] nums = {1,3,5,6};
        int target = 7;

        assertEquals(4, Main.searchInsert(nums, target));
    }

    @Test
    public void testSearchInsert_Test4(){
        int[] nums = {1,2,3,4,5,6};
        int target = 100;

        assertEquals(6, Main.searchInsert(nums, target));
    }
}