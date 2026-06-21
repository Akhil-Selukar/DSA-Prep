package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N+K)/O(K) where K is the maximum value in costs.
    public int maxIceCream(int[] costs, int coins) {
        int maxVal = Arrays.stream(costs).max().getAsInt();

        int[] count = new int[maxVal+1];

        for(int val:costs){
            count[val]++;
        }

        int bars = 0;
        for(int index = 1; index<=maxVal; index++){
            while(count[index] > 0){
                bars++;
                coins -= index;
                if(coins < 0){
                    bars--;
                    return bars;
                }
                if(coins == 0){
                    return bars;
                }
                count[index]--;
            }
        }
        return bars;
    }
}
