package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testTwoSum_Test1(){
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] ans = Main.twoSum(nums, target);

        assertEquals(2, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
    }

    @Test
    public void testTwoSum_Test2(){
        int[] nums = {3,2,4};
        int target = 6;

        int[] ans = Main.twoSum(nums, target);

        assertEquals(2, ans.length);
        assertEquals(1, ans[0]);
        assertEquals(2, ans[1]);
    }

    @Test
    public void testTwoSum_Test3(){
        int[] nums = {3,3};
        int target = 6;

        int[] ans = Main.twoSum(nums, target);

        assertEquals(2, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
    }
}