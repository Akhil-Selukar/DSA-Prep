package org.akhil;

import java.util.Arrays;

public class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)     // every char will be a non overlapping palindromic substring
            return n;

        int[][] dp = new int[n][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(s, k, 0, k - 1, dp);
    }

    private int solve(String s, int k, int start, int end, int[][] dp){ // here end is index of minimum chars we need to have in substring
        if (start >= s.length() || end >= s.length()) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // if palindrome then try three things
        // 1. try to grow the current window i.e. find bigger substring
        // 2. consider this substring as answer and start new substring from next index
        // 3. skip current index and try from next index
        if (isPalindrome(s, start, end)) {
            int growWindow = solve(s, k, start, end + 1, dp);  // if found palindromic then try to find longer string
            int take = 1 + solve(s, k, end + 1, end + k, dp);       // consider current window as answer and start new window
            int skipCurrStart = solve(s, k, start + 1, end + 1, dp);  // skip current start index and search from next one

            return dp[start][end] = Math.max(growWindow, Math.max(take, skipCurrStart));
        }

        // try growing the window (i.e. bigger substring)
        // or try starting new string from next index
        int slideWindow = solve(s, k, start + 1, end + 1, dp);
        int growWindow  = solve(s, k, start, end + 1, dp);

        return dp[start][end] = Math.max(slideWindow, growWindow);
    }

    private boolean isPalindrome(String s, int start, int end){
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
