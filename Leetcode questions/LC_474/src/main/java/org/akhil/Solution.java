package org.akhil;

public class Solution {

    // Solution 1 - Without memoization (TLE)
    // O(2^L)/O(L*S) where L is length of strs and S is the average length of strings in strs
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        int[][] counts = new int[len][2];
//
//        // calculating the counts of 0's and 1's in each string
//        for(int i=0; i<len; i++){
//            for(char ch:strs[i].toCharArray()){
//                if(ch == '0'){
//                    counts[i][0]++;
//                } else {
//                    counts[i][1]++;
//                }
//            }
//        }
//
//        return helper(counts, 0, 0, 0, m, n);
//    }
//
//    private int helper(int[][] counts, int index, int zeros, int ones, int maxZeros, int maxOnes) {
//        if(index >= counts.length){
//            return 0;
//        }
//
//        int[] currentCount = counts[index];
//
//        // take
//        int newZeros = zeros + currentCount[0];
//        int newOnes = ones + currentCount[1];
//        int takeLength = 0;
//        if(newZeros <= maxZeros && newOnes <= maxOnes){
//            takeLength = 1 + helper(counts, index+1, newZeros, newOnes, maxZeros, maxOnes);
//        }
//
//        // not take
//        int notTake = helper(counts, index+1, zeros, ones, maxZeros, maxOnes);
//
//        return Math.max(takeLength, notTake);
//    }


    //-----------------

    // Solution 2 - With memoization
    // O(L*M*N)/O(L*M*N) where L is length of strs.
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] counts = new int[len][2];

        Integer[][][] dp = new Integer[len][m+1][n+1];

        // calculating the counts of 0's and 1's in each string
        for(int i=0; i<len; i++){
            for(char ch:strs[i].toCharArray()){
                if(ch == '0'){
                    counts[i][0]++;
                } else {
                    counts[i][1]++;
                }
            }
        }

        return helper(counts, 0, 0, 0, m, n, dp);
    }

    private int helper(int[][] counts, int index, int zeros, int ones, int maxZeros, int maxOnes, Integer[][][] dp) {
        if(index >= counts.length){
            return 0;
        }

        if(dp[index][zeros][ones] != null){
            return dp[index][zeros][ones];
        }

        int[] currentCount = counts[index];

        // take
        int newZeros = zeros + currentCount[0];
        int newOnes = ones + currentCount[1];
        int takeLength = 0;
        if(newZeros <= maxZeros && newOnes <= maxOnes){
            takeLength = 1 + helper(counts, index+1, newZeros, newOnes, maxZeros, maxOnes, dp);
        }

        // not take
        int notTake = helper(counts, index+1, zeros, ones, maxZeros, maxOnes, dp);

        return dp[index][zeros][ones] = Math.max(takeLength, notTake);
    }
}
