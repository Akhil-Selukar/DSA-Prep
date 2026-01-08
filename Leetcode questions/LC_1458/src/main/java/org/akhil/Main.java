package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};

        Solution solution = new Solution();
        System.out.println(solution.maxDotProduct(nums1, nums2));
    }
}