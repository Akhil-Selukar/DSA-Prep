package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // Solution 1 - Normal recursion
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int rows = triangle.size();
//
//        return minTotalHelper(rows, 0, 0, triangle);
//    }
//
//    private int minTotalHelper(int rows, int i, int j, List<List<Integer>> triangle) {
//        if(j <0 || j >= triangle.get(i).size()){
//            return (int)1e9;
//        }
//        if(i == rows-1){
//            return triangle.get(i).get(j);
//        }
//
//        return triangle.get(i).get(j) + Math.min(minTotalHelper(rows, i+1, j, triangle), minTotalHelper(rows, i+1, j+1, triangle));
//    }

    // Solution 2 - Memoization
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];
        for(int[] arr:dp){
            Arrays.fill(arr, (int)-1e9);
        }

        return minTotalHelper(rows, 0, 0, triangle, dp);
    }

    private int minTotalHelper(int rows, int i, int j, List<List<Integer>> triangle, int[][] dp) {
        // below condition will never occur
//        if(j <0 || j >= triangle.get(i).size()){
//            return (int)1e9;
//        }
        if(i == rows-1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != (int)-1e9){
            return dp[i][j];
        }

        return dp[i][j] = triangle.get(i).get(j) + Math.min(minTotalHelper(rows, i+1, j, triangle, dp), minTotalHelper(rows, i+1, j+1, triangle, dp));
    }

    // Solution 3 - Tabulation (This will reduce the use of recursion stack.)
    public int minimumTotal1(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] dp = new int[rows][rows];

        // Base condition in tabulation
        for(int j=0; j<rows; j++){
            dp[rows-1][j] = triangle.get(rows-1).get(j);
        }

        // recurrence
        for(int i=rows-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                dp[i][j] = Math.min(triangle.get(i).get(j)+dp[i+1][j], triangle.get(i).get(j)+dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
