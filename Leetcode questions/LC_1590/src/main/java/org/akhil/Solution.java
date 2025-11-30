package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // O(N)/O(1)
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }

        int target = sum % p;
        if (target == 0){
            return 0;
        }

        Map<Integer , Integer> mp = new HashMap<>();
        mp.put(0 , -1);

        int result = Integer.MAX_VALUE;
        int curr = 0;

        for (int j = 0; j < n; j++) {
            curr = (curr + nums[j]) % p;

            int rem = (curr - target + p) % p;
            if (mp.containsKey(rem)){
                result = Math.min(result , j - mp.get(rem));
            }

            mp.put(curr , j);
        }
        return result == n ? -1 : result;
    }
}
