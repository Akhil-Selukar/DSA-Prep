package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 4;

        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }
}