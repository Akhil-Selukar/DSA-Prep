package org.akhil;

import java.util.Arrays;

public class Solution {
    // Here the line 'Assuming Alice and Bob play optimally' suggest that the problem is of optimal game strategy/theory
    // Obviously both players are playing optimally hence they will try to win.
    // O/P of our code depends on Alice hence we will write code to check alice's scenarios
    // As per optimal game strategy if the turn is yours then select maximum and if its opponants turn then expect worst (i.e. minimum).

    // without memoization
    // O(2^N)/O(N)
    // public boolean stoneGame(int[] piles) {
    //     int n = piles.length;
    //     int totalScore = Arrays.stream(piles).sum();

    //     int aliceScore = helper(piles, 0, n-1);
    //     int bobScore = totalScore-aliceScore;

    //     return aliceScore > bobScore;

    // }

    // private int helper(int[] arr, int start, int end){
    //     if(start > end){
    //         return 0;
    //     }

    //     if(start == end){
    //         return arr[start];
    //     }

    //     // option 1: select start element and expect worst case from two options for bob
    //     int option1 = arr[start] + Math.min(helper(arr, start+2, end), helper(arr, start+1, end-1));
    //     // option 2: select end element and expect worst from tow options for bob
    //     int option2 = arr[end] + Math.min(helper(arr, start+1, end-1), helper(arr, start, end-2));

    //     // select best for alice
    //     return Math.max(option1, option2);

    // }


    // ---------------------
    // With memoization
    // O(N^2)/O(N^2)
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int totalScore = Arrays.stream(piles).sum();
        int[][] dp = new int[n][n];

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int aliceScore = helper(piles, 0, n-1, dp);
        int bobScore = totalScore-aliceScore;

        return aliceScore > bobScore;

    }

    private int helper(int[] arr, int start, int end, int[][] dp){
        if(start > end){
            return 0;
        }

        if(start == end){
            return arr[start];
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }
        // option 1: select start element and expect worst case from two options for bob
        int option1 = arr[start] + Math.min(helper(arr, start+2, end, dp), helper(arr, start+1, end-1, dp));
        // option 2: select end element and expect worst from tow options for bob
        int option2 = arr[end] + Math.min(helper(arr, start+1, end-1, dp), helper(arr, start, end-2, dp));

        // select best for alice
        return dp[start][end] = Math.max(option1, option2);

    }
}
