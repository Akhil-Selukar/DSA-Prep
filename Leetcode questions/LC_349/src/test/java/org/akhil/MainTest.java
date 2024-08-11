package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testIntersection_Test1(){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] ans = Main.intersection(nums1, nums2);

        assertEquals(1, ans.length);
        assertEquals(2, ans[0]);
    }

    @Test
    public void testIntersection_Test2(){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] ans = Main.intersection(nums1, nums2);

        assertEquals(2, ans.length);
        assertEquals(4, ans[0]);
        assertEquals(9, ans[1]);
    }

    @Test
    public void testIntersection_Test3(){
        int[] nums1 = {1,2,3};
        int[] nums2 = {9,4,9,8,4};

        int[] ans = Main.intersection(nums1, nums2);

        assertEquals(0, ans.length);
    }
}