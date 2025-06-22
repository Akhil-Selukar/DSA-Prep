package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - bruteforce
    // O(N)/O(N) where N is size of nums
//    public int findFinalValue(int[] nums, int original) {
//        Set<Integer> set = new HashSet<>();
//        int result = original;
//
//        for(int num:nums){
//            set.add(num);
//        }
//        while(set.contains(result)){
//            result = result*2;
//        }
//
//        return result;
//    }


    // Solution 2 - as here it is very clear that we have to find doubled number in given array so we are repeating same process again and again so recursion
    // O(N)/recursive stack space.
    public int findFinalValue(int[] nums, int original) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] == original){
                return findFinalValue(nums, original * 2);
            }
        }
        return original;
    }
}
