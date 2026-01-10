package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - Without Memoization normal recursion (TLE)
    // In worst case when none of the character matches and we need to delete both S1 and S2 completely then the total recursion calls will be
    // length of S1 + length of S2 and at each index we have 2 choices either to keep the char or delete it so overall TC will be O(2^(M+N))
    // and for each recursive call we will need call stack which can grow till O(M+N) hence this will be SC.
//    public int minimumDeleteSum(String s1, String s2) {
//        return helper(s1, s2, 0, 0);
//    }
//
//    private int helper(String s1, String s2, int s1Index, int s2Index){
//        if(s1Index >= s1.length() || s2Index >= s2.length()){
//            // in case any of the string is exhausted we need to delete entire remaining part of other string as we have to make strings equal
//            // Hence return sum of ASCII values of all remaining chars of another string
//            return getSumOfRemainingChars(s1, s1Index) + getSumOfRemainingChars(s2, s2Index);
//        }
//
//        int ans = 0;
//        if(s1.charAt(s1Index) == s2.charAt(s2Index)){
//            ans = helper(s1, s2, s1Index+1, s2Index+1);
//        } else {
//            ans = Math.min(s1.charAt(s1Index) + helper(s1, s2, s1Index+1, s2Index),
//                    s2.charAt(s2Index) + helper(s1, s2, s1Index, s2Index+1));
//        }
//
//        return ans;
//    }
//
//    private int getSumOfRemainingChars(String s, int index){
//        int sum = 0;
//        for(int i=index; i<s.length(); i++){
//            sum = sum + s.charAt(i);
//        }
//        return sum;
//    }

    // ---------------------
//    // Solution 2 - With memoization
//    // O(M*N)/O(M*N)
//    public int minimumDeleteSum(String s1, String s2) {
//        int[][] dp = new int[s1.length()][s2.length()];
//        for(int[] row:dp){
//            Arrays.fill(row, -1);
//        }
//
//        return helper(s1, s2, 0, 0, dp);
//    }
//
//    private int helper(String s1, String s2, int s1Index, int s2Index, int[][] dp){
//        if(s1Index >= s1.length() || s2Index >= s2.length()){
//            // in case any of the string is exhausted we need to delete entire remaining part of other string as we have to make strings equal
//            // Hence return sum of ASCII values of all remaining chars of another string
//            return getSumOfRemainingChars(s1, s1Index) + getSumOfRemainingChars(s2, s2Index);
//        }
//
//        if(dp[s1Index][s2Index] != -1){
//            return dp[s1Index][s2Index];
//        }
//
//        int ans = 0;
//        if(s1.charAt(s1Index) == s2.charAt(s2Index)){
//            ans = helper(s1, s2, s1Index+1, s2Index+1, dp);
//        } else {
//            ans = Math.min(s1.charAt(s1Index) + helper(s1, s2, s1Index+1, s2Index, dp),
//                    s2.charAt(s2Index) + helper(s1, s2, s1Index, s2Index+1, dp));
//        }
//
//        return dp[s1Index][s2Index] = ans;
//    }
//
//    private int getSumOfRemainingChars(String s, int index){
//        int sum = 0;
//        for(int i=index; i<s.length(); i++){
//            sum = sum + s.charAt(i);
//        }
//        return sum;
//    }

    // --------------------
    // Solution 3 - Bottoms up
    // O(M*N)/O(M*N)
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int s1Index=m-1; s1Index>=0; s1Index--){
            dp[s1Index][n] = dp[s1Index+1][n] + s1.charAt(s1Index);
        }

        for(int s2Index=n-1; s2Index>=0; s2Index--){
            dp[m][s2Index] = dp[n][s2Index+1] + s2.charAt(s2Index);
        }

        for(int s1Index=m-1; s1Index>=0; s1Index--){
            for(int s2Index=n-1; s2Index>=0; s2Index--){
                if(s1.charAt(s1Index) == s2.charAt(s2Index)){
                    dp[s1Index][s2Index] = dp[s1Index+1][s2Index+1];
                } else {
                    dp[s1Index][s2Index] = Math.min(s1.charAt(s1Index) + dp[s1Index+1][s2Index], s2.charAt(s2Index) + dp[s1Index][s2Index+1]);
                }
            }
        }

        return dp[0][0];
    }
}
