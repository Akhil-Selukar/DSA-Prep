package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        int mink = 1;
        int maxk = 5;

        Solution solution = new Solution();

        System.out.println(solution.countSubarrays(nums, mink, maxk));
    }
}