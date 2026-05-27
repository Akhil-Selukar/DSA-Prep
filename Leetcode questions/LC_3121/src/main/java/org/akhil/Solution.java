package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(N)/O(1)
    public int numberOfSpecialChars(String word) {
        int[] lowerCaseLast = new int[26];
        int[] upperCaseFirst = new int[26];
        Arrays.fill(lowerCaseLast, -1);
        Arrays.fill(upperCaseFirst, Integer.MAX_VALUE);

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(Character.isLowerCase(ch)){
                lowerCaseLast[ch-'a'] = Math.max(lowerCaseLast[ch-'a'], i);
            } else {
                upperCaseFirst[ch-'A'] = Math.min(upperCaseFirst[ch-'A'], i);
            }
        }

        int count = 0;
        for(int i=0; i<26; i++){
            if(lowerCaseLast[i] != -1 && upperCaseFirst[i] != Integer.MAX_VALUE){
                if(upperCaseFirst[i] > lowerCaseLast[i]){
                    count++;
                }
            }
        }
        return count;
    }
}
