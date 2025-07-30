package org.akhil;

public class Solution {

    // Solution 1 - Go through testcase and simple common sense.
    // O(N)/O(1)
//    public int longestSubarray(int[] nums) {
//        int n = nums.length;
//        if(n == 1){
//            return 1;
//        }
//
//        int maxLength = 1;
//        int currLength = 1;
//        int maxAnd = 0;
//
//        for(int num:nums){
//            maxAnd = Math.max(maxAnd, num);
//        }
//
//        for(int i=1; i<n; i++){
//            if(nums[i-1] == nums[i] && nums[i] == maxAnd){
//                currLength++;
//                maxLength = Math.max(maxLength, currLength);
//            } else {
//                currLength = 1;
//            }
//        }
//
//        return maxLength;
//    }


    // Solution 2 - Simple modifications to avoid some conditions to make code faster
    // O(N)/O(1)
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }

        int maxLength = 1;
        int maxAnd = 0;

        for(int num:nums){
            maxAnd = Math.max(maxAnd, num);
        }

        for(int i=0; i<n; i++){
            if(nums[i] == maxAnd){
                int currCount = 0;
                while(i<n && nums[i] == maxAnd){
                    currCount++;
                    i++;
                }
                maxLength = Math.max(currCount, maxLength);
            }
        }

        return maxLength;
    }
}
