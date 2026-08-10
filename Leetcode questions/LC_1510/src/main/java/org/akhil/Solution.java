package org.akhil;

import java.util.Arrays;

public class Solution {
//    public boolean winnerSquareGame(int n) {
//        Boolean[] dp = new Boolean[n+1];
//
//        helper(n, dp);
//
//        return dp[n];
//    }
//
//    private boolean helper(int stonesInPile, Boolean[] dp){
//        // if we know the answer for these many stones then return it
//        if(dp[stonesInPile] != null){
//            return dp[stonesInPile];
//        }
//
//        boolean result = false;     // can player who started the game win
//        for(int i=1; (i*i)<=stonesInPile; i++){   // players will pick till they can pick (i.e. at least sq of i stones are present in pile)
//            if(stonesInPile == (i*i)){  // i.e. can pick all stones leaving 0 in pile
//                result = true;
//                break;  // found the winning scenario for player who started the game
//            } else {
//                result = result | !helper(stonesInPile - (i*i), dp);
//            }
//        }
//        return dp[stonesInPile] = result;
//    }


    // ------------------------------
    // Solution 2
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];

        // All perfect sq -> Alice can win (she can simply pick all stones in 1st turn itself)
        for(int i=1; i*i<=n; i++){
            dp[i*i] = true;
        }

        // All places where after bob's turn 1 stone is left -> Alice can pick that stone and win
        for(int i=1; i<=n; i++){
            if(!dp[i]){     // After alice's first there are stones left which can be picked by bob here
                for(int j=1; i+(j*j)<=n; j++){  // (j*j) are stones which bob picks
                    dp[i+(j*j)] = true;
                }
            }
        }
        return dp[n];
    }
}
