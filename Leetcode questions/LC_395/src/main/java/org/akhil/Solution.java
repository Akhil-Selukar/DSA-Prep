package org.akhil;

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

    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(k <= 1){
            return s.length();
        }

        int start = 0;
        int end = s.length();

        return helper(start, end, s, k);
    }

    private int helper(int start, int end, String s, int k) {
        if(start >= end){
            return 0;
        }

        // populate frequency
        int[] count = new int[26];
        for(int i=start; i<end; i++){
            count[s.charAt(i)-'a']++;
        }

        // check validity
        boolean valid = true;
        for(int i=0; i<26 && valid; i++){
            if(count[i] > 0 && count[i] < k){
                valid = false;
            }
        }
        if(valid){      // i.e. entire string is valid string
            return end - start;
        }

        int maxLength = 0;
        int tempStart = start;
        for(int i=start; i<end; i++){
            if(count[s.charAt(i)-'a'] >= k){
                continue;
            }
            maxLength = Math.max(maxLength, helper(tempStart, i, s, k));
            tempStart = i+1;
        }

        maxLength = Math.max(maxLength, helper(tempStart, end, s, k));
        return maxLength;
    }
}
