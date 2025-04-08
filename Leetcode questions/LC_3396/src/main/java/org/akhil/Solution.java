package org.akhil;

public class Solution {
    public int minimumOperations(int[] nums) {
        int[] freq = new int[101];

        for(int i=nums.length-1; i>=0; i--){
            freq[nums[i]]++;

            if(freq[nums[i]] > 1){
                return i/3 + 1;
            }
        }
        return 0;
    }
}
