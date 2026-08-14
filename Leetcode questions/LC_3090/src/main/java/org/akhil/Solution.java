package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int maxLen = 0;
        int start = 0;
        int end = 0;

        while(end < s.length()){
            int index = s.charAt(end)-'a';
            count[index]++;

            while(count[index] > 2){
                count[s.charAt(start)-'a']--;
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
            end++;
        }

        return maxLen;
    }
}
