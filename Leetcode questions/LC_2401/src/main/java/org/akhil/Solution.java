package org.akhil;

public class Solution {

    // Solution 1 - O(N)/O(1)
//    public int longestNiceSubarray(int[] nums) {
//        int n = nums.length;
//        if(n == 1){
//            return 1;
//        }
//
//        int left = 0;
//        int right;
//        int max = 0;
//        int usedNums = 0;
//
//        for(right = 0; right<n; right++){
//            while((usedNums & nums[right]) != 0){
//                usedNums = usedNums - nums[left];
//                left++;
//            }
//
//            usedNums = usedNums + nums[right];
//            max = Math.max(max, right-left+1);
//        }
//
//        return max;
//    }


    // Solution 1.1 - Same solution using only bitwise operators (O(N)/O(1))
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }

        int left = 0;
        int right;
        int max = 0;
        int usedNums = 0;

        for(right = 0; right<n; right++){
            while((usedNums & nums[right]) != 0){
                usedNums = usedNums ^ nums[left];
                left++;
            }

            usedNums = usedNums | nums[right];
            max = Math.max(max, right-left+1);
        }

        return max;
    }
}
