package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Normal recursion
//    public int minInsertions(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        String rev = sb.reverse().toString();
//
//        return s.length() - helper(s, rev, s.length()-1, s.length()-1);
//    }
//
//    private int helper(String s, String rev, int p1, int p2) {
//        if(p1 < 0 || p2 < 0){
//            return 0;
//        }
//
//        if(s.charAt(p1) == rev.charAt(p2)){
//            return 1+helper(s, rev, p1-1, p2-1);
//        }
//
//        int left = helper(s, rev, p1-1, p2);
//        int right = helper(s, rev, p1, p2-1);
//
//        return Math.max(left, right);
//    }

    // Solution 2 - Memoization
//    public int minInsertions(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        String rev = sb.reverse().toString();
//        int[][] dp = new int[s.length()][s.length()];
//
//        for(int[] temp:dp){
//            Arrays.fill(temp, -1);
//        }
//
//        return s.length() - helper(s, rev, s.length()-1, s.length()-1, dp);
//    }
//
//    private int helper(String s, String rev, int p1, int p2, int[][] dp) {
//        if(p1 < 0 || p2 < 0){
//            return 0;
//        }
//
//        if(dp[p1][p2] != -1){
//            return dp[p1][p2];
//        }
//
//        if(s.charAt(p1) == rev.charAt(p2)){
//            return 1+helper(s, rev, p1-1, p2-1, dp);
//        }
//
//        int left = helper(s, rev, p1-1, p2, dp);
//        int right = helper(s, rev, p1, p2-1, dp);
//
//        return Math.max(left, right);
//    }

    // Solution 3 - Tabulation
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int[][] dp = new int[s.length()+1][s.length()+1];

        for(int i=0; i<=s.length(); i++){
            for(int j=0; j<=rev.length(); j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    if(s.charAt(i-1) == rev.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return s.length()- dp[sb.length()][sb.length()];
    }
}
