package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> list = new ArrayList<>();
////        Arrays.sort(candidates);
//
//        backTrackHelper(candidates, list, new ArrayList(), target, 0);
//
//        return list;
//    }
//
//    private void backTrackHelper(int[] candidates, List<List<Integer>> answer, List<Integer> tempList, int target, int startIndex) {
//        if(target < 0){
//            return;
//        } else if(target == 0){
//            answer.add(new ArrayList<>(tempList));
//        } else {
//            for(int i=startIndex; i<candidates.length; i++){
//                tempList.add(candidates[i]);
//                backTrackHelper(candidates, answer, tempList, target-candidates[i], i); // startIndex is again i as we can reuse same element multiple times.
//                tempList.remove(tempList.size()-1);
//            }
//        }
//    }


    // Solution 2 - Same concept just written differently (more intuitive)
    // Exact time complexity is difficult to find here as we are using backtracking and there can be a huge search space but roughly it will be
    // O(2^N) as we have 2 choices at each index (take and skip).
    // O(T/M) where T is target and M is smallest in given candidate array. (i.e. the recursive call stack in case of target is 7 and M is 1
    // so the answer will be [1,1,1,1,1,1,1] which will require 7 recursive call stack. all other answers will be of length less that this one
    // hence this is the worst case)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || index == candidates.length){
            return;
        }


        curr.add(candidates[index]);
        helper(candidates, target-candidates[index], index, curr, ans);
        curr.remove(curr.size()-1);
        helper(candidates, target, index+1, curr, ans);
    }
}
