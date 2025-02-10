package org.akhil;

public class Solution {

    // Solution 1 (O(N)/O(N))
//    public int numDecodings(String s) {
//        if(s.length() < 1 || s.charAt(0) == '0'){
//            return 0;
//        }
//
//        int[] dp = new int[s.length()+1];       // at each index we will store number of ways possible at that index. considering index starting at 1, at 0th index string will be "" hence only 1 way is possible.
//
//        dp[0] = 1;  // if we consider no character from given string i.e. empty string then that empty string can only be decoded as empty string. hence only 1 way.
//        dp[1] = 1;  // we are only considering first char from string hence only 1 way will be possible. (As combination of number with empty string is not a valid encoded character)
//
//        for(int i=2; i<=s.length(); i++){
//            int takeSingleChar = Integer.parseInt(s.substring(i-1, i));
//            int takeTwoChars = Integer.parseInt(s.substring(i-2, i));
//
//            if(takeSingleChar > 0 && takeSingleChar <= 9){
//                dp[i] = dp[i] + dp[i-1];
//            }
//            if(takeTwoChars >= 10 && takeTwoChars <= 26){
//                dp[i] = dp[i] + dp[i-2];
//            }
//        }
//
//        return dp[s.length()];
//    }


    // Solution 2 - (O(N)/O(1))
    public int numDecodings(String s) {
        if(s.length() < 1 || s.charAt(0) == '0'){
            return 0;
        }

        int oneCount = 1;  // if we consider no character from given string i.e. empty string then that empty string can only be decoded as empty string. hence only 1 way.
        int twoCount = 1;  // we are only considering first char from string hence only 1 way will be possible. (As combination of number with empty string is not a valid encoded character)

        for(int i=2; i<=s.length(); i++){
            int takeSingleChar = Integer.parseInt(s.substring(i-1, i));
            int takeTwoChars = Integer.parseInt(s.substring(i-2, i));
            int thirdCount = 0;
            if(takeSingleChar > 0 && takeSingleChar <= 9){
                 thirdCount = thirdCount + twoCount;
            }
            if(takeTwoChars >= 10 && takeTwoChars <= 26){
                thirdCount= thirdCount + oneCount;
            }

            oneCount = twoCount;
            twoCount = thirdCount;
        }

        return twoCount;
    }
}
