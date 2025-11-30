package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {6,3,5,2};
        int p = 9;

        Solution solution = new Solution();
        System.out.println(solution.minSubarray(nums, p));
    }
}