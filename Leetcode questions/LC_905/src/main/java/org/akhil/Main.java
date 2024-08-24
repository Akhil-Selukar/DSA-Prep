package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};

        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        if(end<1){
            return nums;
        }

        while(start<end){
            if(nums[start]%2 == 0){
                start++;
            } else {
                swap(nums, start, end);
                end--;
            }
        }

        return nums;
    }

    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}