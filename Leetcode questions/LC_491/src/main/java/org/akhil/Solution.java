package org.akhil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    // Solution 1 - using recursion (TLE)
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        recursion(nums, 0, result, new ArrayList<Integer>());
//
//        return result;
//    }
//
//    public void recursion(int[] nums,  int index, List<List<Integer>> result, List<Integer> curr){
//        if(curr.size()>=2) {
//            if(!result.contains(curr)) {
//                result.add(new ArrayList<>(curr));
//            }
//        }
//
//        for(int i = index;i<nums.length;i++){
//            if(curr.size() == 0 || nums[i] >= curr.get(curr.size()-1)){
//                curr.add(nums[i]);
//                recursion(nums, i+1, result, curr);
//                curr.remove(curr.size()-1);
//            }
//        }
//    }


    // Solution 2 - same concept just few modification
    // above solution gives TLE because in that solution for every curr.size() > 2 we have to check the entire list
    // if curr is duplicate or not this we will be removing in below solution.

    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> hashSet = new HashSet<>();

        recursion(nums, 0, new ArrayList<>(), hashSet);

        List<List<Integer>> result = new ArrayList<>(hashSet);

        return result;
    }

    public void recursion(int[] nums, int index, List<Integer> curr, HashSet<List<Integer>> hashSet){
        if(curr.size()>=2) {
            hashSet.add(new ArrayList<>(curr));
        }

        for(int i = index; i<nums.length; i++){
            if(curr.size() == 0 || nums[i]>= curr.get(curr.size()-1)){
                curr.add(nums[i]);
                recursion(nums, i+1, curr, hashSet);
                curr.remove(curr.size()-1);
            }
        }
    }
}
