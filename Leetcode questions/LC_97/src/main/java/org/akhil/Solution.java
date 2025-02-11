package org.akhil;

public class Solution {
    // Solution 1 - Normal recursion (O(2^(M+N))/ recursive stack space i.e. O(M+N))
//    public boolean isInterleave(String s1, String s2, String s3) {
//        int s1Length = s1.length();
//        int s2Length = s2.length();
//        int s3Length = s3.length();
//
//        if(s3Length != (s1Length + s2Length)){
//            return false;
//        }
//
//        return solve(0, 0, s1, s2, s3);
//    }
//
//    private boolean solve(int s1Index, int s2Index, String s1, String s2, String s3) {
//        // base condition 1 - if all strings are exhausted at once that means all chars are consumed from both S1 and S2 and S3 is also completely formed.
//        if(s1Index >= s1.length() && s2Index >= s2.length() && (s1Index + s2Index) >= s3.length()){
//            return true;
//        }
//
//        // base condition 2 - if S3 index (i.e. s1Index+s2Index) is out of bounds or exhausted and not either s1Index or
//        // s2Index that means String S3 is formed without consuming all chars from S1 or S2 which is not allowed hence return false;
//        if((s1Index + s2Index) >= s3.length()){
//            return false;
//        }
//
//        boolean resultOne = false;
//        boolean resultTwo = false;
//        // case 1 - we take char from S1 to form S3
//        if(s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s1Index + s2Index)){
//            resultOne = solve(s1Index+1, s2Index, s1, s2, s3);
//        }
//
//        // case 2 - we take char from S2 to form S3
//        if(s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s1Index + s2Index)){
//            resultTwo = solve(s1Index, s2Index+1, s1, s2, s3);
//        }
//        return resultOne || resultTwo;
//    }

    // Solution 2 - Memoization (O(M*N) as we are evaluating each sub-problem only once/ O(M*N) DP array)
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();

        if(s3Length != (s1Length + s2Length)){
            return false;
        }

        Boolean[][] dp = new Boolean[s1Length+1][s2Length+1];

        return solve(0, 0, s1, s2, s3, dp);
    }

    private boolean solve(int s1Index, int s2Index, String s1, String s2, String s3, Boolean[][] dp) {
        if(s1Index >= s1.length() && s2Index >= s2.length() && (s1Index + s2Index) >= s3.length()){
            return true;
        }

        if((s1Index + s2Index) >= s3.length()){
            return false;
        }

        if(dp[s1Index][s2Index] != null){
            return dp[s1Index][s2Index];
        }
        boolean result = false;

        if(s1Index < s1.length() && s1.charAt(s1Index) == s3.charAt(s1Index + s2Index)){
            result = solve(s1Index+1, s2Index, s1, s2, s3, dp);
        }

        if(result){
            dp[s1Index][s2Index] = result;
            return true;
        }

        if(s2Index < s2.length() && s2.charAt(s2Index) == s3.charAt(s1Index + s2Index)){
            result = solve(s1Index, s2Index+1, s1, s2, s3, dp);
        }
        dp[s1Index][s2Index] = result;
        return result;
    }
}
