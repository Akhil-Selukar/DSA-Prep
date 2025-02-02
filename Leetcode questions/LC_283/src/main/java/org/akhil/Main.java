package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {2,1,8,3,12};
//        int[] nums = {0,1};
//        int[] nums = {1,0,0};
//        int[] nums = {0,0};
//        int[] nums = {0,1,0,-8,3,5,0,12,-52};
//        int[] nums = {};
//        int[] nums = {0};
//        int[] nums = {1};
        int[] nums = {0,0,1};

        Solution solution = new Solution();
        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}