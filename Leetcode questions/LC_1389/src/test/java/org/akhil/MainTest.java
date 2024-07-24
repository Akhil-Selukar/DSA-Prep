package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testCreateTargetArray_Test1(){
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};

        int[] ans = Main.createTargetArray(nums, index);

        assertEquals(5, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(4, ans[1]);
        assertEquals(1, ans[2]);
        assertEquals(3, ans[3]);
        assertEquals(2, ans[4]);
    }

    @Test
    public void testCreateTargetArray_Test2(){
        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};

        int[] ans = Main.createTargetArray(nums, index);

        assertEquals(5, ans.length);
        assertEquals(0, ans[0]);
        assertEquals(1, ans[1]);
        assertEquals(2, ans[2]);
        assertEquals(3, ans[3]);
        assertEquals(4, ans[4]);
    }

    @Test
    public void testCreateTargetArray_Test3(){
        int[] nums = {1};
        int[] index = {0};

        int[] ans = Main.createTargetArray(nums, index);

        assertEquals(1, ans.length);
        assertEquals(1, ans[0]);
    }
}