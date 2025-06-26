package org.akhil;

public class Solution {

    // Solution 1 - using recursion (Will give TLE)
//    int result = Integer.MIN_VALUE;
//    public int longestSubsequence(String s, int k) {
//
//        helper(s, k, new StringBuilder(),0);
//        return result+1;
//    }
//
//    private void helper(String s, int k, StringBuilder sb, int index) {
//        if(index >= s.length()){
//            return;
//        }
//
//        if(isValid(sb, k)){
//            result = Math.max(result, sb.length());
//        } else {
//            return;
//        }
//
//        // consider the char
//        sb.append(s.charAt(index));
//        helper(s, k, sb, index+1);
//        sb.deleteCharAt(sb.length()-1);
//
//        // not consider the char
//        helper(s, k, sb, index+1);
//
//    }
//
//    private boolean isValid(StringBuilder sb, int k) {
//        int val = 0;
//        int multiplier = 1;
//        for(char ch:sb.reverse().toString().toCharArray()){
//            val = val + (ch == '1' ? multiplier : 0);
//            multiplier = multiplier*2;
//        }
//        return val <= k;
//    }


    // Solution 2 - Greedy approach
    // Here we need to check subsequence and not subString or subarray hence we can remove chars in between provided the order of remaining chars is maintained.
    // There is no point in removing any 0 as it will not contribute to the decimal number of final binary, so the chars which we will have to remove are 1's only.
    // so we can keep on traversing from right to left till our decimal of binary string is <= k, post the breakpoint (point where decimal value is more than k) we will start counting 1's
    // because those 1's we will have to remove and 0's can stay. At the end from entire string length if we subtract the count of 1's to remove we will get the required answer.

    // O(N)/O(1)
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        long val = 0;
        int i = 0;

        while (i < n) {
            long multiplier = (long) Math.pow(2, i);
            if (s.charAt(n - i - 1) == '1') {
                if (val + multiplier > k) {
                    break;
                }
                val = val + multiplier;
            }
            i++;
        }
        // Step-2: Count the removed bits
        int onesToRemove = 0;
        while (i < n) {
            if (s.charAt(n - i - 1) == '1') {
                onesToRemove++;
            }
            i++;
        }
        return n - onesToRemove;
    }
}
