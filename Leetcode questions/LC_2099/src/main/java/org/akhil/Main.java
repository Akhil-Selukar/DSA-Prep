package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {-1,-2,3,4};
//        int k = 3;

        int[] nums = {-1,-2,3,3,4,2,5};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSubsequence(nums, k)));
    }
}