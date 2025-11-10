package org.akhil;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
//    // Solution 1 - Bruteforce (TLE)
//    // TC -> O(N*U) where N is number of elements in nums and U is number of unique elements in nums
//    // SC -> O(U) space for set
//    public int minOperations(int[] nums) {
//
//        // identify unique values we need to convert to 0
//        Set<Integer> set = new HashSet<>();
//        for(int num:nums){
//            set.add(num);
//        }
//
//        // check for each unique value
//        int result = 0;
//
//        for(int unique:set){
//            if(unique == 0){
//                continue;
//            }
//
//            boolean isInSegment = false;
//
//            for(int i=0; i<nums.length; i++){
//                if(nums[i] == unique){
//                    // first occurrence of unique value which we are trying to convert to 0
//                    // So start the segment from here
//                    if(!isInSegment){
//                        isInSegment = true;
//                        result++;
//                    }
//                } else if(nums[i] < unique) {       // as soon as any value smaller that unique value which we are converting
//                                                    // to 0 is observed it will break the segment as we can only convert smallest in segment to 0, so no value less than unique can be present in segment.
//                    isInSegment = false;
//                }
//            }
//        }
//
//        return result;
//    }


    // ---------------------
    // Solution 2 - Optimized using stack
    // TC -> O(N) where N is number of elements in nums
    // SC -> O(N)
    public int minOperations(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        // check for each unique value
        int result = 0;

        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && stack.peek() > nums[i]){
                stack.pop();
            }

            if(nums[i] == 0){
                continue;
            }

            if(stack.isEmpty() || stack.peek() < nums[i]){
                stack.push(nums[i]);
                result++;
            }
        }
        return result;
    }
}
