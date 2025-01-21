package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        backtrack(nums, answer, new ArrayList<Integer>());
        return answer;
    }

    private void backtrack(int[] nums, List<List<Integer>> answer, List<Integer> tempList) {
        if(tempList.size() == nums.length){
            answer.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(tempList.contains(nums[i])){
                continue;
            }
            tempList.add(nums[i]);
            backtrack(nums, answer, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
