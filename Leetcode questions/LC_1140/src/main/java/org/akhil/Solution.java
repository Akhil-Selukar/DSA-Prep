package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N^3)/O(2*N^2)
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][][] dp = new int[2][n+1][n+1];        // [person, index, m] -> person can be 0 or 1, index can go till n and m can go till n.

        for(int[][] sub:dp){
            for(int[] row:sub){
                Arrays.fill(row, -1);
            }
        }

        return solveForAlice(piles, 0, 0, 1, dp);   // (piles, index, person, M) person is 0 for alice and 1 for bob.
    }

    private int solveForAlice(int[] piles, int index, int person, int m, int[][][] dp){
        if(index >= piles.length){
            return 0;
        }

        if(dp[person][index][m] != -1){
            return dp[person][index][m];
        }

        int result = person == 0 ? -1 : Integer.MAX_VALUE;  // we will be taking best for alice and expecting worst from BOB hence bob need to take min and alice need to take max so set value as per.
        int stones = 0;

        for(int x=1; x<=Math.min(2*m, piles.length-index); x++){    // range of piles which can be picked
            stones = stones + piles[index+x-1];     // pick the stones from x piles (this is cumulative sum inside for loop so if we are taking stones from 3rd pile then we just need to add 3rd pile 1st and 2nd are already picked and added in stones during earlier iteration of loop
            if(person == 0){        // Alice's turn
                result = Math.max(result, stones + solveForAlice(piles, index+x, 1, Math.max(x, m), dp));
            } else {        // Bob's turn
                // we don't need count of Bob's stones hence not adding in stone
                result = Math.min(result, solveForAlice(piles, index+x, 0, Math.max(x, m), dp));   // expect worst (bob pick what is best for him and left worst case for Alice)
            }
        }

        return dp[person][index][m] = result;
    }
}
