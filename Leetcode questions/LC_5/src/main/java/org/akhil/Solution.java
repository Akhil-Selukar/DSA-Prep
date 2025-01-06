package org.akhil;

public class Solution {
    int startIndex = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }

        for(int i=0; i<s.length(); i++){
            // check for odd length palindrome
            helper(s, i, i);
            // check for even length palindrome
            helper(s, i, i+1);
        }

        return s.substring(startIndex, startIndex+maxLength);
    }

    private void helper(String s, int i, int j) {

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        // if new longest palindrome is found then update the start and amxLength
        if(maxLength < j-i-1){
            maxLength = j-i-1;
            startIndex = i+1;
        }
    }
}
