package org.akhil;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testMerge_Test1(){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        Main.merge(nums1, m, nums2, n);

        assertEquals((m+n), nums1.length);
        assertEquals(1, nums1[0]);
        assertEquals(2, nums1[1]);
        assertEquals(2, nums1[2]);
        assertEquals(3, nums1[3]);
        assertEquals(5, nums1[4]);
        assertEquals(6, nums1[5]);
    }

    @Test
    public void testMerge_Test2(){
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;

        Main.merge(nums1, m, nums2, n);

        assertEquals((m+n), nums1.length);
        assertEquals(1, nums1[0]);
    }

    @Test
    public void testMerge_Test3(){
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {2};
        int n = 1;

        Main.merge(nums1, m, nums2, n);

        assertEquals((m+n), nums1.length);
        assertEquals(2, nums1[0]);
    }

    @Test
    public void testMerge_Test4(){
        int[] nums1 = {2, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;

        Main.merge(nums1, m, nums2, n);

        assertEquals((m+n), nums1.length);
        assertEquals(1, nums1[0]);
        assertEquals(2, nums1[1]);
        assertEquals(2, nums1[2]);
        assertEquals(3, nums1[3]);
        assertEquals(5, nums1[4]);
        assertEquals(6, nums1[5]);
    }
}