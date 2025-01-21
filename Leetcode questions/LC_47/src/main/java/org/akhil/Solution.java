package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1 - Gives TLE
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> answer = new ArrayList<>();
//
//        backtrack(nums, answer, new ArrayList<Integer>());
//
//        return answer;
//    }
//
//    private void backtrack(int[] nums, List<List<Integer>> answer, List<Integer> temp){
//        if(nums.length == temp.size()){
//            List<Integer> current = new ArrayList<Integer>(temp);
//            if(!answer.contains(current)){
//                answer.add(current);
//            }
//            return;
//        }
//
//        for(int i=0; i<nums.length; i++){
//            int num = nums[i];
//            if(temp.contains(nums[i]) && Arrays.stream(nums).filter(n -> n == num).count() == temp.stream().filter(n -> n == num).count()){
//                continue;
//            }
//
//            temp.add(nums[i]);
//            backtrack(nums, answer, temp);
//            temp.remove(temp.size()-1);
//        }
//    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backtrack(nums, answer, new ArrayList<Integer>(), used);

        return answer;
    }

    private void backtrack(int[] nums, List<List<Integer>> answer, List<Integer> temp, boolean[] used) {
        if (nums.length == temp.size()) {
            answer.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums, answer, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
