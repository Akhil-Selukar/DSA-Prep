package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {-4,-2,0,3};
        int[] nums2 = {2,4};
        int k = 6;

        Solution solution = new Solution();
        System.out.println(solution.kthSmallestProduct(nums1, nums2, k));
    }
}