package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(NLogN) / O(logN)
    public long maxAlternatingSum(int[] nums) {

        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                nums[i] = -1 * nums[i];
            }
        }

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;
        long result = 0;

        int turn = 0;

        while(turn < nums.length){
            if(start > end){
                break;
            }

            if(turn%2 == 0){
                result = result + (nums[end] * nums[end]);
                end--;
            } else {
                result = result - (nums[start] * nums[start]);
                start++;
            }
            turn++;
        }

        return result;
    }
}
