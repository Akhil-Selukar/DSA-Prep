package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Solution 1
    // O(N)/O(N)
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int count = 0;
        int[] result = new int[2];

        for(int val:nums){
            if(!set.add(val)){
                result[count] = val;
                count++;
                if(count == 2){
                    return result;
                }
            }
        }
        return result;
    }
}
