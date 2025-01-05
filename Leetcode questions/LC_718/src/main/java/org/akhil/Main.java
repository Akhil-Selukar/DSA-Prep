package org.akhil;

public class Main {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,2,1};
//        int[] nums2 = {3,2,1,4,7};

        int[] nums1 = {0,1,1,1,1};
        int[] nums2 = {1,0,1,0,1};

        Solution solution = new Solution();
        System.out.println(solution.findLength(nums1, nums2));
    }
}