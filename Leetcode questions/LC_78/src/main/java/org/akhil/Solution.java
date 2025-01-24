package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(nums, 0, answer, new ArrayList<Integer>());

        return answer;
    }

    private void helper(int[] nums, int i, List<List<Integer>> answer, List<Integer> temp) {
        if(nums.length <= i){
            answer.add(new ArrayList<>(temp));
            return;
        }

        // not take
        helper(nums, i+1, answer, temp);

        // take
        temp.add(nums[i]);
        helper(nums, i+1, answer, temp);
        temp.remove(temp.size()-1);
    }
}
