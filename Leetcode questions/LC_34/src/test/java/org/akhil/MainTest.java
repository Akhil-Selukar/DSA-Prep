package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSearchRange_RangeAtTheStart(){
        int[] nums = {7,7,7,8,8,10};
        int target = 7;

        int[] ans = Main.searchRange(nums, target);
        assertEquals(0, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testSearchRange_RangeAtTheEnd(){
        int[] nums = {5,7,7,8,8,10,10,10,10};
        int target = 10;

        int[] ans = Main.searchRange(nums, target);
        assertEquals(5, ans[0]);
        assertEquals(8, ans[1]);
    }

    @Test
    public void testSearchRange_RangeInMiddle(){
        int[] nums = {5,7,7,8,8,10,10,10,10};
        int target = 8;

        int[] ans = Main.searchRange(nums, target);
        assertEquals(3, ans[0]);
        assertEquals(4, ans[1]);
    }

    @Test
    public void testSearchRange_OnlyOneTargetElement(){
        int[] nums = {5,7,7,8,10,10,10,10};
        int target = 8;

        int[] ans = Main.searchRange(nums, target);
        assertEquals(3, ans[0]);
        assertEquals(3, ans[1]);
    }

    @Test
    public void testSearchRange_NoTargetPresent(){
        int[] nums = {5,7,7,8,10,10,10,10};
        int target = 6;

        int[] ans = Main.searchRange(nums, target);
        assertEquals(-1, ans[0]);
        assertEquals(-1, ans[1]);
    }
}