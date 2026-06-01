package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N)/O(1)
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int minCost = 0;
        int boughtCount = 0;

        for(int i=n-1; i>=0; i--){
            if(boughtCount != 2){
                boughtCount++;
                minCost = minCost + cost[i];
            } else {
                boughtCount = 0;
            }
        }
        return minCost;
    }
}
