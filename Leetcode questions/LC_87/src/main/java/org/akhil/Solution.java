package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - O(N^4)/O(N^4)
//    public boolean isScramble(String s1, String s2) {
//        if(s1.length() != s2.length()){
//            return false;
//        }
//
//        Map<String, Boolean> dp = new HashMap<>();
//        return helper(s1, s2, dp);
//    }
//
//    private boolean helper(String s1, String s2, Map<String, Boolean> dp) {
//        if (s1.equals(s2)) {
//            return true;
//        }
//
//        if(s1.length() == 1){
//            return false;
//        }
//
//        String key = s1+"_"+s2;
//        if(dp.containsKey(key)){
//            return dp.get(key);
//        }
//        boolean result = false;
//
//        for(int i=1; i<s1.length(); i++){
//
//            boolean noSwapCheck = helper(s1.substring(0, i), s2.substring(0, i), dp) && helper(s1.substring(i), s2.substring(i), dp);
//            boolean swapCheck = helper(s1.substring(0, i), s2.substring(s2.length()-i), dp) && helper(s1.substring(i), s2.substring(0, s2.length()-i), dp);
//
//            if(swapCheck || noSwapCheck){
//                result = true;
//                break;
//            }
//        }
//
//        dp.put(key, result);
//        return result;
//    }


    // Solution 1.1 - Same time and space complexity just added an early exit condition which improve the runtime significantly.

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        Map<String, Boolean> dp = new HashMap<>();
        return helper(s1, s2, dp);
    }

    private boolean helper(String s1, String s2, Map<String, Boolean> dp) {
        if (s1.equals(s2)) {
            return true;
        }

        if(s1.length() == 1){
            return false;
        }

        String key = s1+"_"+s2;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        // early exit if chars are different in s1 and s2
        int[] charCount = new int[26];
        for(int i=0; i<s1.length(); i++){
            charCount[s1.charAt(i)-'a']++;
            charCount[s2.charAt(i)-'a']--;
        }

        for(int count:charCount){
            if(count != 0){
                dp.put(key, false);
                return false;
            }
        }

        boolean result = false;

        for(int i=1; i<s1.length(); i++){

            boolean noSwapCheck = helper(s1.substring(0, i), s2.substring(0, i), dp) && helper(s1.substring(i), s2.substring(i), dp);
            boolean swapCheck = helper(s1.substring(0, i), s2.substring(s2.length()-i), dp) && helper(s1.substring(i), s2.substring(0, s2.length()-i), dp);

            if(swapCheck || noSwapCheck){
                result = true;
                break;
            }
        }

        dp.put(key, result);
        return result;
    }
}
