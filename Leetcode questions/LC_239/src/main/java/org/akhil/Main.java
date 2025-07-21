package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

        int[] nums = {1};
        int k = 1;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }
}