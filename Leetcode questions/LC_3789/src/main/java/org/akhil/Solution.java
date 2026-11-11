package org.akhil;

public class Solution {
    // README.md 1 - Bruteforce (TLE)
    // O(Min(need1, need2))/O(1)
    // public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
    //     int min = Math.min(need1, need2);
    //     long cost = 0;

    //     boolean buyBoth = cost1+cost2 > costBoth;

    //     for(int i=0; i<min; i++){
    //         if(buyBoth){
    //             cost = cost + costBoth;
    //         } else {
    //             cost = cost + cost1 + cost2;
    //         }
    //         need1--;
    //         need2--;
    //     }

    //     if(need1 > 0){
    //         if(cost1 > costBoth){
    //             cost = cost + ((long)need1 * costBoth);
    //         } else {
    //             cost = cost + ((long)cost1 * need1);
    //         }
    //     }

    //     if(need2 > 0){
    //         if(cost2 > costBoth){
    //             cost = cost + ((long)need2 * costBoth);
    //         } else {
    //             cost = cost + ((long)cost2 * need2);
    //         }
    //     }

    //     return cost;
    // }

    // --------------------------------------------
    // README.md 2 - Optimized
    // O(1)/O(1)
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int min = Math.min(need1, need2);
        long cost = 0;

        cost = min * (long)(Math.min((cost1+cost2), costBoth));

        need1 = need1 - min;
        need2 = need2 - min;

        if(need1 > 0){
            if(cost1 > costBoth){
                cost = cost + ((long)need1 * costBoth);
            } else {
                cost = cost + ((long)cost1 * need1);
            }
        }

        if(need2 > 0){
            if(cost2 > costBoth){
                cost = cost + ((long)need2 * costBoth);
            } else {
                cost = cost + ((long)cost2 * need2);
            }
        }

        return cost;
    }
}
