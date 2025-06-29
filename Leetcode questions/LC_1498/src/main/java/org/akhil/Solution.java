package org.akhil;

import java.util.Arrays;

public class Solution {
    private final int MOD = (int)1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int p1 = 0;
        int p2 = nums.length-1;
        int[] powers = new int[nums.length];

        calculatePowers(powers);

        while(p1 <= p2){
            int min = nums[p1];
            int max = nums[p2];

            if(min+max <= target){
                int possibleCombinations = powers[p2-p1];
                count = (int) ((count + possibleCombinations) % MOD);
                p1++;
            } else {
                p2--;
            }
        }

        return count;
    }

    private void calculatePowers(int[] powers) {
        powers[0] = 1;

        for(int i=1; i<powers.length; i++){
            powers[i] = (powers[i-1] * 2)%MOD;
        }
    }
}
