package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public int longestSubstring(String s, int k) {
//        // base cases
//        if(s.length() < k){
//            return 0;
//        }
//        if(k <= 1){
//            return s.length();
//        }
//
//        // frequency calculation
//        int[] count = new int[26];
//
//        for(int i=0; i<s.length(); i++){
//            count[s.charAt(i)-'a']++;
//        }
//
//        // Iterations
//        int start = 0;
//        int end = s.length();
//
//        while(start < end && count[s.charAt(start)-'a'] >= k) {
//            start++;
//        }
//
//        if(start >= end-1){
//            return start;
//        }
//
//        int leftPartAns = longestSubstring(s.substring(0, start), k);
//        int rightPartAns = longestSubstring(s.substring(start+1), k);
//
//        return Math.max(leftPartAns, rightPartAns);
//    }

    // Solution 2

//    public int longestSubstring(String s, int k) {
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//        if(k <= 1){
//            return s.length();
//        }
//
//        int start = 0;
//        int end = s.length();
//
//        return helper(start, end, s, k);
//    }
//
//    private int helper(int start, int end, String s, int k) {
//        if(start >= end){
//            return 0;
//        }
//
//        // populate frequency
//        int[] count = new int[26];
//        for(int i=start; i<end; i++){
//            count[s.charAt(i)-'a']++;
//        }
//
//        // check validity
//        boolean valid = true;
//        for(int i=0; i<26 && valid; i++){
//            if(count[i] > 0 && count[i] < k){
//                valid = false;
//            }
//        }
//        if(valid){      // i.e. entire string is valid string
//            return end - start;
//        }
//
//        int maxLength = 0;
//        int tempStart = start;
//        for(int i=start; i<end; i++){
//            if(count[s.charAt(i)-'a'] >= k){
//                continue;
//            }
//            maxLength = Math.max(maxLength, helper(tempStart, i, s, k));
//            tempStart = i+1;
//        }
//
//        maxLength = Math.max(maxLength, helper(tempStart, end, s, k));
//        return maxLength;
//    }

    // -----------------

    // Solution 3 - Most intuitive approach (divide and conquer)
    // concept is as we want the resultant string such that all chars in that string must appear at least k times (which means no character in string we want
    // can have frequency less than k) so we keep on splitting the given string recursively at on the character which has frequency less than 'k'
    // at a point we will reach either to the required resultant string or empty string that is length 0. (in case no char has at-least k count.

    public int longestSubstring(String s, int k) {
        return solve(s, k);
    }

    private int solve(String s, int k) {
        if(s.length() == 0){
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();

        for(char ch:s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        for(char ch:freq.keySet()){
            if(freq.get(ch) < k){
                // split string at ch
                String[] subStrings = s.split(String.valueOf(ch));
                int maxLength = 0;
                for(String str:subStrings){
                    maxLength = Math.max(maxLength, solve(str, k));
                }
                return maxLength;
            }
        }

        // if we are reaching at this point means no char in s has frequency atleat equal to k (i.e. if statement in loop was never true)
        return s.length();
    }


}
