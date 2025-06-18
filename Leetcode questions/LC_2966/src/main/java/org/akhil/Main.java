package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,3,4,8,7,9,3,5,1};
//        int k = 2;

        int[] nums = {2,4,2,2,5,2};
        int k = 2;

        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.divideArray(nums, k)));
    }
}