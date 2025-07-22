package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // Solution 1 - Using set
    // O(N)/O(N)
//    public int maximumUniqueSubarray(int[] nums) {
//      int maxSum = 0;
//      int runningSum = 0;
//      Set<Integer> set = new HashSet<>();
//
//      int p1 = 0;
//      int p2 = 0;
//      while(p2 < nums.length){
//          while(set.contains(nums[p2])){
//              runningSum = runningSum - nums[p1];
//              set.remove(nums[p1]);
//              p1++;
//          }
//
//          runningSum = runningSum + nums[p2];
//          maxSum = Math.max(maxSum, runningSum);
//          set.add(nums[p2]);
//          p2++;
//      }
//
//      return maxSum;
//    }


    // Solution 2 - Using map and prefixSum
    // O(N)/O(N) but much efficient because we dont have to move start/p1 one by one, here we are directly jumping to next start
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxSum = 0;
        Map<Integer, Integer> map = new HashMap<>();    // to store <val, index>

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int start = 0;

        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                start = Math.max(start, map.get(nums[i])+1);
            }
            int sum = prefixSum[i] - (start == 0 ? 0 : prefixSum[start-1]);
            maxSum = Math.max(maxSum, sum);
            map.put(nums[i], i);
        }
        return maxSum;
    }
}
