package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        // if values we have are not divisible by k then we cant form k groups with given conditions. (some elements will remain)
        if(n % k != 0){
            return false;
        }

        // number of groups we need for form
        int numOfGroups = n/k;

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num:nums){
            int newCount = freq.getOrDefault(num, 0) + 1;
            // if any value has frequency greater than k then that means atleast 1 group has to have a duplicate element which is not allowed
            if(newCount > numOfGroups){
                return false;
            }
            freq.put(num, newCount);
        }

        return true;
    }
}
