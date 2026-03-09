package org.akhil;

import java.util.Arrays;

public class Solution {

//    // Solution 1 - Normal recursion
//    // O(Zero * One * Limit)/O(Zero*One)
//    private final int MOD = (int)(7+1e9);
//    public int numberOfStableArrays(int zero, int one, int limit) {
//
//        int startWithZero = helper(zero, one, true, limit);
//        int startWithOne = helper(zero, one, false, limit);
//
//        return (startWithZero + startWithOne)%MOD;
//    }
//
//    private int helper(int zerosLeft, int onesLeft, boolean isLastOne, int limit){
//
//        // if we use all available zeros and ones then that means we have created a valid substring
//        if(zerosLeft == 0 && onesLeft == 0){
//            return 1;
//        }
//
//        int result = 0;
//
//        // if last digit was 1 then this has to be zero
//        if(isLastOne){
//            for(int i=1; i<=Math.min(limit, zerosLeft); i++){
//                result = (result + helper(zerosLeft - i, onesLeft, false, limit)) % MOD;
//            }
//        } else {
//            for(int i=1; i<=Math.min(limit, onesLeft); i++){
//                result = (result + helper(zerosLeft, onesLeft-i, true, limit)) % MOD;
//            }
//        }
//
//        return result;
//    }

    // ---------------------
    // Solution 2 - WIth memoization
    // O(Zero * One * Limit)/O(Zero * One * Limit)
    private final int MOD = (int)(7+1e9);
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero+1][one+1][2];

        for(int[][] subArr:dp){
            for(int[] row:subArr){
                Arrays.fill(row, -1);
            }
        }

        int startWithZero = helper(zero, one, 1, limit, dp);
        int startWithOne = helper(zero, one, 0, limit, dp);

        return (startWithZero + startWithOne)%MOD;
    }

    private int helper(int zerosLeft, int onesLeft, int lastDigit, int limit, int[][][] dp){

        // if we use all available zeros and ones then that means we have created a valid substring
        if(zerosLeft == 0 && onesLeft == 0){
            return 1;
        }

        if(dp[zerosLeft][onesLeft][lastDigit] != -1){
            return dp[zerosLeft][onesLeft][lastDigit];
        }

        int result = 0;

        // if last digit was 1 then this has to be zero
        if(lastDigit == 1){
            for(int i=1; i<=Math.min(limit, zerosLeft); i++){
                result = (result + helper(zerosLeft - i, onesLeft, 0, limit, dp)) % MOD;
            }
        } else {
            for(int i=1; i<=Math.min(limit, onesLeft); i++){
                result = (result + helper(zerosLeft, onesLeft-i, 1, limit, dp)) % MOD;
            }
        }

        return dp[zerosLeft][onesLeft][lastDigit] = result;
    }
}
