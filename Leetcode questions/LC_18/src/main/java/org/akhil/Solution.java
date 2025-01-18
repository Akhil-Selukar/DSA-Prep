package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    // for some testcases this solution goes beyond int limit
//    private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
//        List<List<Integer>> answer = new ArrayList<>();
//        if(index >= nums.length){
//            return answer;
//        }
//
//        // problem boiled down to 2Sum (Simple 2-pointer)
//        if(k == 2){
//            int pointer1 = index;
//            int pointer2 = nums.length-1;
//
//            while(pointer1 < pointer2){
//                int sum = nums[pointer1] + nums[pointer2];
//                if(target == sum){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[pointer1]);
//                    temp.add(nums[pointer2]);
//                    answer.add(temp);
//
//                    // skip duplicates
//                    while(pointer1<pointer2 && nums[pointer1]==nums[pointer1+1]){
//                        pointer1++;
//                    }
//                    while(pointer1<pointer2 && nums[pointer2]==nums[pointer2-1]){
//                        pointer2--;
//                    }
//                    pointer1++;
//                    pointer2--;
//                } else if(0 < (target - sum)){
//                    pointer1++;
//                } else {
//                    pointer2--;
//                }
//            }
//        } else {    // means k != 2 (so problem is not boilded down to 2Sum)
//            // convert problem to 2Sum
//            for (int i = index; i < nums.length - k + 1; i++) {
//                //use current number to reduce ksum into k-1sum
//                List<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
//                //add previous results
//                for (List<Integer> t : temp) {
//                    t.add(0, nums[i]);
//                }
//                answer.addAll(temp);
//                while (i < nums.length-1 && nums[i] == nums[i+1]) {
//                    //skip duplicated numbers
//                    i++;
//                }
//            }
//        }
//        return answer;
//    }

    private List<List<Integer>> kSum(int[] nums, long target, int k, int index) {
        List<List<Integer>> answer = new ArrayList<>();
        if(index >= nums.length){
            return answer;
        }

        // problem boiled down to 2Sum (Simple 2-pointer)
        if(k == 2){
            int pointer1 = index;
            int pointer2 = nums.length-1;

            while(pointer1 < pointer2){
                if(target - nums[pointer1] == nums[pointer2]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[pointer1]);
                    temp.add(nums[pointer2]);
                    answer.add(temp);

                    // skip duplicates
                    while(pointer1<pointer2 && nums[pointer1]==nums[pointer1+1]){
                        pointer1++;
                    }
                    while(pointer1<pointer2 && nums[pointer2]==nums[pointer2-1]){
                        pointer2--;
                    }
                    pointer1++;
                    pointer2--;
                } else if(nums[pointer2] < (target - nums[pointer1])){
                    pointer1++;
                } else {
                    pointer2--;
                }
            }
        } else {    // means k != 2 (so problem is not boilded down to 2Sum)
            // convert problem to 2Sum
            for (int i = index; i < nums.length - k + 1; i++) {
                // use current number to reduce ksum into k-1sum
                List<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                //add previous results
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                answer.addAll(temp);
                while (i < nums.length-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return answer;
    }
}
