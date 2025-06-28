package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1 - O(N! * N^2)/O(N! * N)
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> answer = new ArrayList<>();
//
//        backtrack(nums, answer, new ArrayList<Integer>());    // N! permutations are possible.
//        return answer;
//    }
//
//    private void backtrack(int[] nums, List<List<Integer>> answer, List<Integer> tempList) {
//        if(tempList.size() == nums.length){
//            answer.add(new ArrayList<>(tempList));        // O(N)
//            return;
//        }
//
//        for(int i=0; i<nums.length; i++){
//            if(tempList.contains(nums[i])){               // O(N)
//                continue;
//            }
//            tempList.add(nums[i]);
//            backtrack(nums, answer, tempList);
//            tempList.remove(tempList.size()-1);
//        }
//    }



    // Solution 2 - Same concept but slightly better approach which reduce contains operation
    // O(N! * N)/ O(N! * N)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] considered = new boolean[nums.length];

        helper(nums, new ArrayList<>(), result, considered);        // N! permutations are possible

        return result;
    }

    private void helper(int[] nums, List<Integer> curr, List<List<Integer>> result, boolean[] considered){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));          // O(N)
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(considered[i]){                          // O(1)
                continue;
            }

            curr.add(nums[i]);
            considered[i] = true;
            helper(nums, curr, result, considered);
            curr.remove(curr.size()-1);
            considered[i] = false;
        }
    }
}
