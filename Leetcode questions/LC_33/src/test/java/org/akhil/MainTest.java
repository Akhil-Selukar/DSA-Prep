package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSearch_ElementAtTheStart(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4;

        assertEquals(0, Main.search(nums, target));
    }

    @Test
    public void testSearch_ElementAtTheEnd(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 2;

        assertEquals(6, Main.search(nums, target));
    }

    @Test
    public void testSearch_ElementAtTheFirstHalf(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;

        assertEquals(1, Main.search(nums, target));
    }

    @Test
    public void testSearch_ElementAtTheSecondHalf(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;

        assertEquals(5, Main.search(nums, target));
    }

    @Test
    public void testSearch_ElementAtPivotIndex(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 7;

        assertEquals(3, Main.search(nums, target));
    }

    @Test
    public void testSearch_ElementDoesNotExist(){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 14;

        assertEquals(-1, Main.search(nums, target));
    }

    @Test
    public void testSearch_ArrayOfLengthOne(){
        int[] nums = {1};
        int target = 1;

        assertEquals(0, Main.search(nums, target));
    }

    @Test
    public void testSearch_ArrayOfLengthTwo(){
        int[] nums = {1,3};
        int target = 1;

        assertEquals(0, Main.search(nums, target));
    }

    @Test
    public void testSearch_ArrayOfLengthTwo2(){
        int[] nums = {1,3};
        int target = 3;

        assertEquals(1, Main.search(nums, target));
    }
}