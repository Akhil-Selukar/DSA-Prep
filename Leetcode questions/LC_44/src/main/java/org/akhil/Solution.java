package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Simple recursion
//    public boolean isMatch(String s, String p) {
//        int p1 = s.length()-1;
//        int p2 = p.length()-1;
//
//        return helper(s, p, p1, p2);
//    }
//
//    private boolean helper(String s, String p, int p1, int p2) {
//
//        if(p1 < 0 && p2 < 0){
//            return true;
//        }
//        if(p2 < 0){
//            return false;
//        }
//        if(p1<0){
//            for(int i=0; i<=p2; i++){
//                if(p.charAt(i) != '*'){
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        if(p.charAt(p2) == '?' || s.charAt(p1) == p.charAt(p2)){
//            return helper(s, p, p1-1, p2-1);
//        }
//        if(p.charAt(p2) == '*'){
//            return helper(s, p, p1-1, p2) || helper(s, p, p1, p2-1);
//        }
//        return false;
//    }

    // Solution 2 - Memoization
//    public boolean isMatch(String s, String p) {
//        int p1 = s.length()-1;
//        int p2 = p.length()-1;
//
//        Integer[][] dp = new Integer[s.length()][p.length()];
//
//        return helper(s, p, p1, p2, dp);
//    }
//
//    private boolean helper(String s, String p, int p1, int p2, Integer[][] dp) {
//
//        if(p1 < 0 && p2 < 0){
//            return true;
//        }
//        if(p2 < 0){
//            return false;
//        }
//        if(p1<0){
//            for(int i=0; i<=p2; i++){
//                if(p.charAt(i) != '*'){
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        if(dp[p1][p2] != null){
//            return dp[p1][p2] == 1;
//        }
//
//        if(p.charAt(p2) == '?' || s.charAt(p1) == p.charAt(p2)){
//            if(helper(s, p, p1-1, p2-1, dp)){
//                dp[p1][p2] = 1;
//                return true;
//            } else {
//                dp[p1][p2] = 0;
//                return false;
//            }
//        }
//        if(p.charAt(p2) == '*'){
//            if(helper(s, p, p1-1, p2, dp) || helper(s, p, p1, p2-1, dp)){
//                dp[p1][p2] = 1;
//                return true;
//            } else {
//                dp[p1][p2] = 0;
//                return false;
//            }
//        }
//        return false;
//    }

    public boolean isMatch(String s, String p) {
        int p1 = s.length()-1;
        int p2 = p.length()-1;

        int[][] dp = new int[s.length()][p.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(s, p, p1, p2, dp);
    }

    private boolean helper(String s, String p, int p1, int p2, int[][] dp) {

        if(p1 < 0 && p2 < 0){
            return true;
        }
        if(p2 < 0){
            return false;
        }
        if(p1<0){
            for(int i=0; i<=p2; i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2] == 1;
        }

        if(p.charAt(p2) == '?' || s.charAt(p1) == p.charAt(p2)){
            dp[p1][p2] = helper(s, p, p1-1, p2-1, dp) ? 1 : 0;
        }
        if(p.charAt(p2) == '*'){
            dp[p1][p2] = (helper(s, p, p1-1, p2, dp) || helper(s, p, p1, p2-1, dp)) ? 1 : 0;
        }
        return dp[p1][p2] == 1;
    }
}
