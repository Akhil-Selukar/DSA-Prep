package org.akhil;

public class Solution {

//    // Solution 1 - Without Memoization
//    public int minScoreTriangulation(int[] values) {
//        int n = values.length;
//
//        return helper(values, 0, n-1);
//    }
//
//    private int helper(int[] values, int start, int end){
//        // base case -  we are left with 2 or fewer vertices hence no triangle can be formed
//        if(end-start+1 < 3){
//            return 0;
//        }
//
//        int result = Integer.MAX_VALUE;
//
//        for(int i=start+1; i<end; i++){
//            int currentScore = helper(values, start, i)
//                    + (values[start] * values[i] * values[end])
//                    + helper(values, i, end);
//
//            result = Math.min(result, currentScore);
//        }
//
//        return result;
//    }

    // -------------------------
    // Solution 2 - With Memoization
    // O(N^2)/O(N^2)
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(values, 0, n-1, dp);
    }

    private int helper(int[] values, int start, int end, int[][] dp){
        // base case -  we are left with 2 or fewer vertices hence no triangle can be formed
        if(end-start+1 < 3){
            return 0;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        int result = Integer.MAX_VALUE;

        for(int i=start+1; i<end; i++){
            int currentScore = helper(values, start, i, dp)
                    + (values[start] * values[i] * values[end])
                    + helper(values, i, end, dp);

            result = Math.min(result, currentScore);
        }

        return dp[start][end] = result;
    }
}
