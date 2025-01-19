package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};         // [1,3,2]
//        int[] nums = {3,2,1};           // [1,2,3]
//        int[] nums = {1,1,5};           // [1,5,1]
//        int[] nums = {1,3,2};         // [2,1,3]
//        int[] nums = {2,3,1};         // [3,1,2]
        int[] nums = {2,3,1,3,3};         // [2,3,3,1,3]

        Solution solution = new Solution();
        solution.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}