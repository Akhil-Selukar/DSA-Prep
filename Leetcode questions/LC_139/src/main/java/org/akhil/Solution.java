package org.akhil;

import java.util.List;

public class Solution {

    // below solution misses some edge cases like  below
    /*
        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList(new String[]{"aaaa","aaa"});
     */

//    public boolean wordBreak(String s, List<String> wordDict) {
//        int startIndex = 0;
//        int endIndex = 0;
//
//        for(int i=endIndex; i<=s.length(); i++){
//            String str = s.substring(startIndex, i);
//            if(wordDict.contains(str)){
//                startIndex = i;
//            }
//        }
//
//        return startIndex == s.length();
//    }


    // Solution 2
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
