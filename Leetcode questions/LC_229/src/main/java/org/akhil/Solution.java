package org.akhil;

import java.util.*;

public class Solution {

    // solution 1 - (O(N)/O(N))
//    public List<Integer> majorityElement(int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        int n = nums.length;
//        if(n<3){
//            for(int num:nums){
//                if(!ans.contains(num)) {
//                    ans.add(num);
//                }
//            }
//            return ans;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<nums.length; i++){
//            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
//        }
//
//        for(Map.Entry entry:map.entrySet()){
//            if((int)entry.getValue() > n/3){
//                ans.add((int)entry.getKey());
//            }
//        }
//
//        return ans;
//    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue() > n/3){
                ans.add((int)entry.getKey());
            }
        }

        return ans;
    }
}
