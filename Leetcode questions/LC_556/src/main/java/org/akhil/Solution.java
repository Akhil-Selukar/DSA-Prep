package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - O(N Log(N))/O(N) where N is the number of digits in n (i.e. given number)
    public int nextGreaterElement(int n) {
        char[] nums = (n+"").toCharArray();

        int i=nums.length-1;
        while(i > 0){
            if(nums[i-1] < nums[i]){
                break;
            }
            i--;
        }

        if(i == 0){     // means all digits are in descending order
            return -1;
        }

        // find smallest digit to the right of [i-1]th digit which is greater than i-1th digit
        char val = nums[i-1];
        int smallest = i;

        for(int j = i+1; j<nums.length; j++){
            if(nums[j] > val && nums[j]<nums[smallest]){
                smallest = j;
            }
        }

        // swap
        nums[i-1] = nums[smallest];
        nums[smallest] = val;

        // sort
        Arrays.sort(nums, i, nums.length);

        long answer = Long.parseLong(new String(nums));

        return answer <= Integer.MAX_VALUE ? (int)answer : -1;
    }
}
