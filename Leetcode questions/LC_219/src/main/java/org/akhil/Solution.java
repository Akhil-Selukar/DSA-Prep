package org.akhil;

import java.util.HashMap;

public class Solution {
    // Solution 1 - TLE
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int n = nums.length;
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j<n; j++){
//                if(nums[i] == nums[j] && Math.abs(i-j)<=k){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // Solution 2 - But not a good solution
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        int n = nums.length;
//        for(int i=0; i<n-1; i++){
//            int j = i+1;
//            while(Math.abs(i-j) <= k){
//                if(j < n && nums[i] == nums[j]){
//                    return true;
//                }
//                j++;
//            }
//        }
//        return false;
//    }

    // Solution 3 - Optimized (O(N)/O(N))
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int value = nums[i];

            if(map.containsKey(value) && Math.abs(map.get(value) - i) <= k){
                return true;
            }
            map.put(value, i);
        }
        return false;
    }
}
