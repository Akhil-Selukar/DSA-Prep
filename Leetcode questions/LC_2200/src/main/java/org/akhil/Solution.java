package org.akhil;

import java.util.*;

public class Solution {
    // Without using stack or queue (using sorting) Accepted but not optimal
    // TC - > roughly O(N+NlogN)
    // SC -> O(N)
//    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
//        Set<Integer> set = new HashSet<>();
//        List<Integer> js = new ArrayList<>();
//
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] == key){
//                js.add(i);
//            }
//        }
//
//        for(int j:js){
//            int start = Math.max(j-k, 0);
//            int end = Math.min(j+k, nums.length-1);
//
//            for(int i=start; i<=end; i++){
//                set.add(i);
//            }
//        }
//
//        js = new ArrayList<>(set);
//        Collections.sort(js);
//
//        return js;
//    }


    // Solution 2 - Two pointers
    // O(N)/O(N)
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> answer = new ArrayList<>();
        int left = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == key){
                left = Math.max(left, i-k);
                int right = Math.min(nums.length-1, i+k);

                for(int j=left; j<=right; j++){
                    answer.add(j);
                }
                left = right+1;
            }
        }
        return answer;
    }
}
