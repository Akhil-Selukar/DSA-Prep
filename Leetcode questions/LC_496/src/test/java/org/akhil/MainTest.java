package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void textNextGreaterElement_test1(){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = Main.nextGreaterElement(nums1, nums2);

        assertEquals(-1, ans[0]);
        assertEquals(3, ans[1]);
        assertEquals(-1, ans[2]);
    }

    @Test
    public void textNextGreaterElement_test2(){
        int[] nums1 = {2, 4};
        int[] nums2 = {1,2,3,4};

        int[] ans = Main.nextGreaterElement(nums1, nums2);

        assertEquals(3, ans[0]);
        assertEquals(-1, ans[1]);
    }

    @Test
    public void textNextGreaterElement_test3(){
        int[] nums1 = {4,3,1,6,2};
        int[] nums2 = {9,5,4,1,2,3,7,8,6};

        int[] ans = Main.nextGreaterElement(nums1, nums2);

        assertEquals(7, ans[0]);
        assertEquals(7, ans[1]);
        assertEquals(2, ans[2]);
        assertEquals(-1, ans[3]);
        assertEquals(3, ans[4]);
    }
}