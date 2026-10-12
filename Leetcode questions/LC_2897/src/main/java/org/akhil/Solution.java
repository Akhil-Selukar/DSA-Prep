package org.akhil;

import java.util.List;

public class Solution {

    int MOD = (int)(1e9+7);
    public int maxSum(List<Integer> nums, int k) {
        long result = 0;
        int[] bitCounts = new int[32];

        // compute bits at each place
        for (int num : nums) {
            for(int i=0; i<32; i++) {
                if((num & (1<<i)) != 0){
                    bitCounts[i]++;
                }
            }
        }

        while(k > 0){
            long currNo = 0;

            for(int i=0; i<32; i++){
                // if we have a bit available at this place then use it
                if(bitCounts[i] > 0){
                    currNo = currNo | (1 << i);
                    bitCounts[i]--;     // this bit is used;
                }
            }
            result = (result + (currNo * currNo)) % MOD;
            k--;
        }

        return (int)result;
    }
}
