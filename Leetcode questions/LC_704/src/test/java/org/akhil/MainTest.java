package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSearch_Test1(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        assertEquals(4, Main.search(nums, target));
    }

    @Test
    public void testSearch_Test2(){
        int[] nums = {-1,0,3,5,9,12};
        int target = -1;

        assertEquals(0, Main.search(nums, target));
    }

    @Test
    public void testSearch_Test3(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 0;

        assertEquals(1, Main.search(nums, target));
    }

    @Test
    public void testSearch_Test4(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 5;

        assertEquals(3, Main.search(nums, target));
    }

    @Test
    public void testSearch_Test5(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;

        assertEquals(5, Main.search(nums, target));
    }

    @Test
    public void testSearch_Test6(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;

        assertEquals(-1, Main.search(nums, target));
    }

    @Test
    public void testSearch_Test7(){
        int[] nums = {-1,0,3,5,9,12};
        int target = -5;

        assertEquals(-1, Main.search(nums, target));
    }

    @Test
    public void testSearch_Tes8(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 22;

        assertEquals(-1, Main.search(nums, target));
    }
}