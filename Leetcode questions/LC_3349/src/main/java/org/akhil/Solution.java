package org.akhil;

import java.util.List;

public class Solution {
    // O(N)/O(1)
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if(k==1){
            return true;
        }

        int count = 0;
        for(int i=1; i<nums.size()-k; i++){
            if(nums.get(i-1) < nums.get(i) && nums.get(i+k-1) < nums.get(i+k)){
                count++;
                if(count == k-1){       // k-1 because 2 consecutive pairs = 3 values (k=3 then a<b<c)
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
