package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1 - Gives TLE
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> answer = new ArrayList<>();
//        Arrays.sort(candidates);
//
//        backtrackingHelper(candidates, target, answer, new ArrayList<>(), 0);
//
//        return answer;
//    }
//
//    private void backtrackingHelper(int[] candidates, int target, List<List<Integer>> answer, ArrayList<Object> temp, int startIndex) {
//        if(target < 0){
//            return;
//        } else if(target == 0){
//            List<Integer> pair = new ArrayList(temp);
//            if(!answer.contains(pair)){
//                answer.add(pair);
//            }
//        } else {
//            for(int i=startIndex; i<candidates.length; i++){
//                temp.add(candidates[i]);
//                backtrackingHelper(candidates, target-candidates[i], answer, temp, i+1);
//                temp.remove(temp.size()-1);
//            }
//        }
//    }


    // Solution 2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);

        backtrackingHelper(candidates, target, answer, new ArrayList<>(), 0);

        return answer;
    }

    private void backtrackingHelper(int[] candidates, int target, List<List<Integer>> answer, ArrayList<Object> temp, int startIndex) {
        if (target == 0) {
            answer.add(new ArrayList(temp));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(i>startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] > target){
                break;
            }

            temp.add(candidates[i]);
            backtrackingHelper(candidates, target - candidates[i], answer, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
