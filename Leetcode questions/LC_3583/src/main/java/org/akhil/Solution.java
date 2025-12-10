package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Bruteforce (TLE)
    // O(N^3)/O(1)
//    final int MOD = (int)(7+1e9);
//    public int specialTriplets(int[] nums) {
//        int n = nums.length;
//        int result = 0;
//
//        for(int i=0; i<n; i++){
//            for(int k=i+2; k<n; k++){
//                if(nums[i] == nums[k]){
//                    for(int j=i+1; j<k; j++){
//                        if(nums[i] == 2 * nums[j]){
//                            result = (result + 1)%MOD;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }

    // ----------------
//    // Solution 2 - optimized solution
//    // O(N)/O(N)
//    final int MOD = (int)(7+1e9);
//    public int specialTriplets(int[] nums) {
//        int n = nums.length;
//        int result = 0;
//
//        Map<Integer, Integer> leftCount = new HashMap<>();
//        Map<Integer, Integer> rightCount = new HashMap<>();
//
//        // initially out j will start from 0th index so everything will be on RHS
//        for(int num:nums){      // O(N)
//            rightCount.put(num, rightCount.getOrDefault(num,0)+1);
//        }
//
//        for(int j=0; j<n; j++){     // O(N)
//            int jthVal = nums[j];
//            // jthVal is now the middle value hence it is not on right side
//            rightCount.put(jthVal, rightCount.get(jthVal)-1);
//            if(rightCount.get(jthVal) == 0){
//                rightCount.remove(jthVal);
//            }
//
//            int ithCount = 0;       // valid i such that nums[i] = 2*nums[j]
//            if(!leftCount.isEmpty() && leftCount.containsKey(2 * jthVal)){
//                ithCount = leftCount.get(2 * jthVal);
//            }
//
//            int kthCount = 0;
//            if(!rightCount.isEmpty() && rightCount.containsKey(2 * jthVal)){
//                kthCount = rightCount.get(2 * jthVal);
//            }
//
//            long newPairs = (1L * ithCount * kthCount)%MOD;       //(i * k) because there can be multiple values present at either side satisfying nums[i] = nums[k] = 2*nums[j] so each value will create a separate pair.
//            result = (int)(result + newPairs)%MOD;
//            leftCount.put(jthVal, leftCount.getOrDefault(jthVal, 0)+1);
//        }
//        return result;
//    }

    // ------------------------------
    // Solution 2.1 - Same as that of above but a bit cleaned code
    // O(N)/O(N)
    final int MOD = (int)(7+1e9);
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int result = 0;

        Map<Integer, Integer> leftCount = new HashMap<>();
        Map<Integer, Integer> rightCount = new HashMap<>();

        // initially out j will start from 0th index so everything will be on RHS
        for(int num:nums){      // O(N)
            rightCount.put(num, rightCount.getOrDefault(num,0)+1);
        }

        for(int j=0; j<n; j++){     // O(N)
            int jthVal = nums[j];
            // jthVal is now the middle value hence it is not on right side
            rightCount.put(jthVal, rightCount.get(jthVal)-1);


            int ithCount = leftCount.getOrDefault(2 * jthVal, 0);

            int kthCount = rightCount.getOrDefault(2 * jthVal, 0);

            long newPairs = (1L * ithCount * kthCount)%MOD;       //(i * k) because there can be multiple values present at either side satisfying nums[i] = nums[k] = 2*nums[j] so each value will create a separate pair.
            result = (int)(result + newPairs)%MOD;

            leftCount.put(jthVal, leftCount.getOrDefault(jthVal, 0)+1);
        }
        return result;
    }
}
