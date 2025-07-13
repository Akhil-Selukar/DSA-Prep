package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - using builtin sort method
    // O(NlogN)/O(1)
//    public int maximumGap(int[] nums) {
//        if(nums.length < 2){
//            return 0;
//        }
//
//        // use radix sort here
//        Arrays.sort(nums);
//        int max = Integer.MIN_VALUE;
//
//        for(int i=1; i<nums.length; i++){
//            max = Math.max(max, nums[i]-nums[i-1]);
//        }
//        return max;
//    }


    // Solution 2 - Using radix sort (normal count sort will give memory limit exceeds)
    // O(N)/O(N)
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        // radix sort here
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int place = 1;
        int max = 0;

        while(maxValue/place > 0){
            countSort(nums, place);
            place = place*10;
        }

        for(int i=1; i<nums.length; i++){
            max = Math.max(max, nums[i]-nums[i-1]);
        }
        return max;
    }

    private void countSort(int[] nums, int place){
        int[] output = new int[nums.length];

        int[] freq = new int[10];

        for(int num:nums){
            int index = (num/place)%10;
            freq[index]++;
        }

        // build prefixSum array
        for(int i=1; i<freq.length; i++){
            freq[i] = freq[i]+freq[i-1];
        }

        // populate the output array
        for(int i=nums.length-1; i>=0; i--){
            int index = freq[(nums[i]/place)%10]-1;
            output[index] = nums[i];
            freq[(nums[i]/place)%10]--;
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = output[i];
        }
    }
}
