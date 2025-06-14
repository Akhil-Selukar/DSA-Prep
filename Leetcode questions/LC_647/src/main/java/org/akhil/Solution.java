package org.akhil;

public class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            count = count + checkPalindrome(i, i, s);
            count = count + checkPalindrome(i, i+1, s);
        }
        return count;
    }

    private int checkPalindrome(int p1, int p2, String s){
        int count = 0;

        while(p1 >=0 && p2 <s.length() && s.charAt(p1) == s.charAt(p2)){
            count++;
            p1--;
            p2++;
        }
        return count;
    }
}
