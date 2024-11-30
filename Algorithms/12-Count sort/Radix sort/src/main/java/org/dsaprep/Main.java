package org.dsaprep;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {26, 458, 103, 73, 846, 5};
        radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void radixSort(int[] nums) {
        if(nums== null || nums.length <=1){
            return;
        }
        // get max from the nums
        int max = Arrays.stream(nums).max().getAsInt();

        // run loop number of digits in max times.
        int place = 1;
        while(max/place > 0){
            countSort(nums, place);
            place *=10;
        }
    }

    private static void countSort(int[] nums, int place) {
        int[] output = new int[nums.length];

        // create frequency array
        int[] frequency = new int[10];

        // populate frequency array
        for(int num:nums){
            int index = (num/place)%10;
            frequency[index]++;
        }

        // prefix sum array
        for(int i=1; i<frequency.length; i++){
            frequency[i] += frequency[i-1];
        }

        // populate sorted output array
        for(int i=nums.length-1; i>=0; i--){
            int index = frequency[(nums[i]/place)%10]-1;
            output[index] = nums[i];
            frequency[(nums[i]/place)%10]--;
        }

        // copy output array to nums (i.e. modify nums)
        System.arraycopy(output,0, nums, 0, output.length);
    }
}