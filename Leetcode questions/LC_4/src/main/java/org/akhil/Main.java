package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums1 = {1,3};
//        int[] nums2 = {2};

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}