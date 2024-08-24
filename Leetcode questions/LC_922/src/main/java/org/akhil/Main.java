package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,2,5,7};

        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 1 && nums[i]%2 == 0){
                while(nums[j]%2 == 0){
                    j+=2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}