package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Normal recursion
//    public int minCut(String str) {
//        int n = str.length();
//        if(n==1){
//            return 0;
//        }
//        return helper(0, n, str)-1;
//    }
//
//    private int helper(int startIndex, int endIndex, String str) {
//        int minCuts = Integer.MAX_VALUE;
//
//        if(startIndex == endIndex){     // only 1 letter string is remaining
//            return 0;
//        }
//
//        for(int i=startIndex; i<endIndex; i++){
//            if(isPalindrome(startIndex, i, str)){
//                int cuts = 1 + helper(i+1, endIndex, str);
//                minCuts = Math.min(minCuts, cuts);
//            }
//        }
//        return minCuts;
//    }
//
//    private boolean isPalindrome(int startIndex, int i, String str) {
//        while(startIndex<i){
//            if(str.charAt(startIndex) != str.charAt(i)){
//                return false;
//            }
//            startIndex++;
//            i--;
//        }
//        return true;
//    }

    // Solution 2 - Memoization
    public int minCut(String str) {
        int n = str.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        if(n==1){
            return 0;
        }
        return helper(0, n, str, dp)-1;
    }

    private int helper(int startIndex, int endIndex, String str, int[] dp) {
        int minCuts = Integer.MAX_VALUE;

        if(startIndex == endIndex){     // only 1 letter string is remaining
            return 0;
        }

        if(dp[startIndex] != -1){
            return dp[startIndex];
        }

        for(int i=startIndex; i<endIndex; i++){
            if(isPalindrome(startIndex, i, str)){
                int cuts = 1 + helper(i+1, endIndex, str, dp);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return dp[startIndex] = minCuts;
    }

    private boolean isPalindrome(int startIndex, int i, String str) {
        while(startIndex<i){
            if(str.charAt(startIndex) != str.charAt(i)){
                return false;
            }
            startIndex++;
            i--;
        }
        return true;
    }
}
