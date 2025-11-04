package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findXSum(nums, k, x)));
    }
}