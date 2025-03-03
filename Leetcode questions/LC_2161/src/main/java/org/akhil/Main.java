package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {9,12,5,10,14,3,10};
//        int pivot = 10;

//        int[] nums = {};
//        int pivot = 10;

        int[] nums = {9,12,5,10,20,14,3,10};
        int pivot = 20;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.pivotArray(nums, pivot)));
    }
}