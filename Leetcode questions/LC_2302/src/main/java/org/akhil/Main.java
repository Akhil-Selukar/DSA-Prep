package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,1,4,3,5};
        int k = 10;

        Solution solution = new Solution();
        System.out.println(solution.countSubarrays(nums, k));
    }
}