package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - TLE
    // TC -> O(N^2) where N = s.length()
    // SC -> O(N)   recursive call stack
//    public int numDistinct(String s, String t) {
//        if(s.equals(t)) {
//            return 1;
//        }
//
//        return helper(0, 0, s, t);
//    }
//
//    private int helper(int p1, int p2, String s, String t) {
//        if(p2 >= t.length()){       // we are able to construct t using s.
//            return 1;
//        }
//
//        if(p1 >= s.length()){       // s is completely consumed but still we are not able to construct t.
//            return 0;
//        }
//
//        int notConsider = helper(p1+1, p2, s, t);
//
//        int consider = 0;
//        // we can consider the char at p1 from s only if it matches to char at p2 in t.
//        if(s.charAt(p1) == t.charAt(p2)){
//            consider = helper(p1+1, p2+1, s, t);
//        }
//
//        return notConsider + consider;
//    }


    // Solution 2 - using memoization
    // TC -> O(M*N) where N = s.length() and M = t.length();
    // SC -> O(M*N) where N = s.length() and M = t.length();
    public int numDistinct(String s, String t) {
        if(s.equals(t)) {
            return 1;
        }

        int[][] dp = new int[s.length()][t.length()];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(0, 0, s, t, dp);
    }

    private int helper(int p1, int p2, String s, String t, int[][] dp) {
        if(p2 >= t.length()){       // we are able to construct t using s.
            return 1;
        }

        if(p1 >= s.length()){       // s is completely consumed but still we are not able to construct t.
            return 0;
        }

        if(dp[p1][p2] != -1){
            return dp[p1][p2];
        }

        int notConsider = helper(p1+1, p2, s, t, dp);

        int consider = 0;
        // we can consider the char at p1 from s only if it matches to char at p2 in t.
        if(s.charAt(p1) == t.charAt(p2)){
            consider = helper(p1+1, p2+1, s, t, dp);
        }

        return dp[p1][p2] = (notConsider + consider);
    }
}
