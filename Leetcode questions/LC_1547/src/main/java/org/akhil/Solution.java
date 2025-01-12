package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Solution 1 - Normal recursion
//    public int minCost(int n, int[] arr) {
//        List<Integer> cuts = new ArrayList<>();
//        for(int num:arr){
//            cuts.add(num);
//        }
//        cuts.add(0,0);
//        cuts.add(n);
//        Collections.sort(cuts);
//
//        return helper(1, arr.length, cuts);
//    }
//
//    private int helper(int i, int j, List<Integer> cuts) {
//
//        if(i>j){
//            return 0;
//        }
//
//        int minimum = Integer.MAX_VALUE;
//        for(int k=i; k<=j; k++){
//            int ans = cuts.get(j+1) - cuts.get(i-1)       // current stick length
//                    + helper(i, k-1, cuts)              // check in left portion of stick (cut at cuts[k])
//                    + helper(k+1, j, cuts);             // check in right portion of stick (cut at cuts[k])
//
//            minimum = Math.min(minimum, ans);
//        }
//        return minimum;
//    }

    // Solution 2 - Memoization
//    public int minCost(int n, int[] arr) {
//        List<Integer> cuts = new ArrayList<>();
//        for(int num:arr){
//            cuts.add(num);
//        }
//        cuts.add(0,0);
//        cuts.add(n);
//        Collections.sort(cuts);
//        int[][] dp = new int[n][n];
//        for(int[] row:dp){
//            Arrays.fill(row, -1);
//        }
//        return helper(1, arr.length, cuts, dp);
//    }
//
//    private int helper(int i, int j, List<Integer> cuts, int[][] dp) {
//
//        if(i>j){
//            return 0;
//        }
//
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
//
//        int minimum = Integer.MAX_VALUE;
//        for(int k=i; k<=j; k++){
//            int ans = cuts.get(j+1) - cuts.get(i-1)       // current stick length
//                    + helper(i, k-1, cuts, dp)              // check in left portion of stick (cut at cuts[k])
//                    + helper(k+1, j, cuts, dp);             // check in right portion of stick (cut at cuts[k])
//
//            minimum = Math.min(minimum, ans);
//        }
//        return dp[i][j] = minimum;
//    }

    // Solution 3 - Tabulation
//    public int minCost(int n, int[] arr) {
//        List<Integer> cuts = new ArrayList<>();
//        for(int num:arr){
//            cuts.add(num);
//        }
//        cuts.add(0,0);
//        cuts.add(n);
//        Collections.sort(cuts);
//        int[][] dp = new int[n+2][n+2];
//
//        // As base case is initializing values to 0 and default value for int array is 0 only hence no need to handle base case here.
////        for(int[] row:dp){
////            Arrays.fill(row, 0);
////        }
//
//        for(int i=arr.length; i>=1; i--){
//            for(int j=1; j<=arr.length; j++){
//                if(i>j){
//                    continue;
//                }
//
//                int minimum = Integer.MAX_VALUE;
//                for(int k=i; k<=j; k++){
//                    int ans = cuts.get(j+1) - cuts.get(i-1)       // current stick length
//                            + dp[i][k-1]              // check in left portion of stick (cut at cuts[k])
//                            + dp[k+1][j];             // check in right portion of stick (cut at cuts[k])
//
//                    minimum = Math.min(minimum, ans);
//                }
//                dp[i][j] = minimum;
//            }
//        }
//
//        return dp[1][arr.length];
//    }

    // Solution 4 - All above approaches gives TLE hence we can use below simple approach using memoization.
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, n, cuts, 0, cuts.length-1, dp);
    }

    private int helper(int stickStart, int stickEnd, int[] cuts, int cutsStart, int cutsEnd, int[][] dp) {
        if (cutsStart > cutsEnd) {
            return 0;
        }

        if (dp[cutsStart][cutsEnd] != -1) {
            return dp[cutsStart][cutsEnd];
        }

        int cost = Integer.MAX_VALUE;

        for (int k = cutsStart; k <= cutsEnd; k++) {
            int leftCost = helper(stickStart, cuts[k], cuts, cutsStart, k - 1, dp);
            int rightCost = helper(cuts[k], stickEnd, cuts, k + 1, cutsEnd, dp);
            int currentTotalCost = (stickEnd - stickStart) + leftCost + rightCost;
            cost = Math.min(cost, currentTotalCost);
        }

        return dp[cutsStart][cutsEnd] = cost;
    }
}
