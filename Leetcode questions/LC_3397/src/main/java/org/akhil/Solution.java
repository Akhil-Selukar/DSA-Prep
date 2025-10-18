package org.akhil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - Bruteforce (TLE)
    // O(N*k + NlogN)/O(N)
//    public int maxDistinctElements(int[] nums, int k) {
//        Arrays.sort(nums);
//        Set<Integer> set = new HashSet<>();
//
//        for (int val : nums) {
//            for (int i = -k; i <= k; i++) {
//                if (!set.contains(val + i)) {
//                    set.add(val + i);
//                    break;
//                }
//            }
//        }
//        return set.size();
//    }

    // --------------------
    // Solution 2 - Optimized
    // O(N*NlogN)/O(N)

    // If we try some testcases, it is very obvious that we need to sort the array because we need duplicate values together.
    // Now greedily we will take the smallest possible value for first element i.e. nums[0]-k will be the smallest.
    // Now as we have sorted the array and taking the smallest possible UNIQUE that means whatever value we need at the 1st index
    // has to be smallest possible greater than the one at index 0 (because as the nums is sorted hence result will also be sorted
    // because nums[i] < nums[i+1] so nums[i]-k will also be less than nums[i+1]-k.
    // so if result[i] = x then result[i+1] has to be at least x+1, but it is not necessary that nums[i+1] is always next number of nums[i]
    // nums[i] can be 5 and nums[i+1] can be 500 in that case if k is 2 then ans[i] will be 3 (i.e. 5-2) but ans[i+1] will not be 4 (i.e. ans[i]+1)
    // it will be nums[i+1]-k i.e. 498. So we can conclude that the next elements answer will be either x+1 or nums[i+1]-k whichever is greater.
    // So from above logic we need to keep track of what is the previous element.
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int previous = (int)(-1e9);
        int uniqueCount = 0;

        for (int val : nums) {
            int currValue = Math.max(previous + 1, val-k);
            if(currValue <= val+k){      // currValue must not go beyond upper limit of val+k
                uniqueCount++;
                previous = currValue;
            }
        }
        return uniqueCount;
    }
}
