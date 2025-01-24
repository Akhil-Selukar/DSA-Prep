package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> answer = new ArrayList<>();
//        Arrays.sort(nums); //To handle duplicate first we sort the array.
//
//        helper(0, nums, new ArrayList(), answer);
//        return answer;
//    }
//
//    public void helper(int index, int[] nums, List<Integer> temp, List<List<Integer>> answer) {
//
//        answer.add(new ArrayList(temp));
//
//        for (int i = index; i < nums.length; i++) {
//            if (i != index && nums[i] == nums[i - 1])         //skip the duplicates, except for the first time
//                continue;
//            temp.add(nums[i]);                                //include
//            helper(i + 1, nums, temp, answer);          //explore
//            temp.remove(temp.size() - 1);               //backtrack, remove the element
//        }
//    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, answer, new ArrayList<Integer>());

        return answer;
    }

    private void helper(int[] nums, int i, List<List<Integer>> answer, List<Integer> temp){
        if(i >= nums.length){
            List<Integer> pair = new ArrayList(temp);
            if(!answer.contains(pair)) {
                answer.add(pair);
            }
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
