package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 5, 3, 1, 3, 5};
        countSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void countSort(int nums[]){
        if(nums == null || nums.length <=1){
            return;
        }

        // finding the maximum value in given array.
        int max = Arrays.stream(nums).max().getAsInt();
        int[] output = new int[nums.length];

        // creation of frequency array.
        int[] frequency = new int[max+1];

        // populating frequency array
        for(int num:nums){
            frequency[num]++;
        }

        // converting frequency array to prefix sum array
        for(int i=1; i<frequency.length; i++){
            frequency[i] += frequency[i-1];
        }

        // sort nums array
        for(int i=nums.length-1; i>=0; i--){
            int index = frequency[nums[i]]-1;
            output[index] = nums[i];
            frequency[nums[i]]--;
        }

        // copy sorted array to nums
        for(int i=0; i<nums.length; i++){
            nums[i]= output[i];
        }
    }
}
