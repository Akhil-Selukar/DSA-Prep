package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        int lower = 3;
        int upper = 6;

        Solution solution = new Solution();
        System.out.println(solution.countFairPairs(nums, lower, upper));
    }
}