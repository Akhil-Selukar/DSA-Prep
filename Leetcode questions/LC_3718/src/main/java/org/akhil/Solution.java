package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // O(N)/O(N)
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            if(num%k == 0){
                set.add(num);
            }
        }

        int temp = k;
        while(temp != Integer.MAX_VALUE){
            if(!set.contains(temp)){
                return temp;
            }
            temp = temp+k;
        }
        return temp;
    }
}
