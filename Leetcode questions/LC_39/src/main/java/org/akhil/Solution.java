package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(candidates);

        backTrackHelper(candidates, list, new ArrayList(), target, 0);

        return list;
    }

    private void backTrackHelper(int[] candidates, List<List<Integer>> answer, List<Integer> tempList, int target, int startIndex) {
        if(target < 0){
            return;
        } else if(target == 0){
            answer.add(new ArrayList<>(tempList));
        } else {
            for(int i=startIndex; i<candidates.length; i++){
                tempList.add(candidates[i]);
                backTrackHelper(candidates, answer, tempList, target-candidates[i], i); // startIndex is again i as we can reuse same element multiple times.
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
