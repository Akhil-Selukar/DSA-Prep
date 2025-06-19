package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Greedy (O(NLogN)/O(1))
    public int partitionArray(int[] nums, int k) {
        int count = 1;
        Arrays.sort(nums);

        int min = nums[0];
        for(int i=1; i<nums.length; i++){
            int diff = nums[i] - min;
            if(diff > k){
                count++;
                min = nums[i];
            }
        }
        return count;
    }
}
