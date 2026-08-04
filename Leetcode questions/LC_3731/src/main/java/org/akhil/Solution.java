package org.akhil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // O(N)/O(N)
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int val:nums){
            set.add(val);
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        for(int i=min; i<=max; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;
    }
}
