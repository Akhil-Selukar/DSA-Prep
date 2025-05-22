package org.akhil;

public class Solution {

//    // Solution 1 - normal recursion
//    // TC -> O(2^(S+P)) -> where S is number of chars in s and P is number of chars in p
//    // SC -> O(1)   (very minimal recursive stack space)
//    public boolean isMatch(String s, String p) {
//        int sPointer = 0;
//        int pPointer = 0;
//
//        return helper(sPointer, pPointer, s, p);
//    }
//
//    private boolean helper(int sPointer, int pPointer, String s, String p) {
//        if(sPointer >= s.length() && pPointer >= p.length()){       // exact match case
//            return true;
//        }
//
//        if(pPointer >= p.length()){     // no pattern left to match
//            return false;
//        }
//
//        boolean charMatched = (sPointer < s.length() && ((s.charAt(sPointer) == p.charAt(pPointer)) || p.charAt(pPointer) == '.'));
//
//        if((pPointer+1) < p.length() && p.charAt(pPointer+1) == '*'){
//            // we have two choices
//            return helper(sPointer, pPointer+2, s, p) || (charMatched && helper(sPointer+1, pPointer, s, p));
//                // ignore * and move ahead hence j+2               char match found hence i+1 and j is same for next two choices.
//        }
//
//        if(charMatched){
//            return helper(sPointer+1, pPointer+1, s, p);   // no * just a single individual character hence if matched then only we can go ahead
//        }
//
//        return false;
//    }


    //-------------------

    // Solution 2 - Memoization
    // TC -> O(S*P) -> where S is number of chars in s and P is number of chars in p
    // SC -> O(S*P)   (very minimal recursive stack space)
    public boolean isMatch(String s, String p) {
        int sPointer = 0;
        int pPointer = 0;

        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];

        return helper(sPointer, pPointer, s, p, dp);
    }

    private boolean helper(int sPointer, int pPointer, String s, String p, Boolean dp[][]) {

        if(dp[sPointer][pPointer] != null){
            return dp[sPointer][pPointer];
        }

        if(sPointer >= s.length() && pPointer >= p.length()){       // exact match case
            return dp[sPointer][pPointer] = true;
        }

        if(pPointer >= p.length()){     // no pattern left to match
            return dp[sPointer][pPointer] = false;
        }

        boolean charMatched = (sPointer < s.length() && ((s.charAt(sPointer) == p.charAt(pPointer)) || p.charAt(pPointer) == '.'));

        if((pPointer+1) < p.length() && p.charAt(pPointer+1) == '*'){
            // we have two choices
            return dp[sPointer][pPointer] = helper(sPointer, pPointer+2, s, p, dp) || (charMatched && helper(sPointer+1, pPointer, s, p, dp));
            // ignore * and move ahead hence j+2               char match found hence i+1 and j is same for next two choices.
        }

        if(charMatched){
            return dp[sPointer][pPointer] = helper(sPointer+1, pPointer+1, s, p, dp);   // no * just a single individual character hence if matched then only we can go ahead
        }

        return dp[sPointer][pPointer] = false;
    }
}
