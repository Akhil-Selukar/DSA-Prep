package org.akhil;

public class Solution {
    // O(N)/O(1)
    public long countSubarrays(int[] nums, int k) {
        // find the max element
        int maxVal = Integer.MIN_VALUE;
        for(int num:nums){
            maxVal = Math.max(maxVal, num);
        }

        // two pointers
        int start = 0;
        int end = 0;
        int maxCount = 0;
        long result = 0;

        while(end < nums.length){
            if(nums[end] == maxVal){
                maxCount++;
            }

            while(maxCount >= k){
                if(nums[start] == maxVal){
                    maxCount--;
                }
                start++;
            }
            // this result calculation is important part
            result = result + start;        // this is outside while and hence will always execute ([1,2,3,1,2,3,2,1,3]
                                            // even when our start is at index 3 and end is at index 6 or 7.(at this moment maxCount will be < k
                                            // but there are some sub arrays starting from index = 0 and 1 which can contribute
                                            // to result hence we  are adding those elements here)
            end++;
        }

        return result;
    }
}
