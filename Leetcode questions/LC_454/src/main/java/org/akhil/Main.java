package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};

        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
    }
}