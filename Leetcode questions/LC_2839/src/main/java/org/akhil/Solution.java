package org.akhil;

public class Solution {
    // Solution 1 - As swapping indices are fixed so at the end count has to be 0;
    // O(1)/O(1)
    public boolean canBeEqual(String s1, String s2) {
        int[] oddPlaceCount = new int[26];
        int[] evenPlaceCount = new int[26];

        for(int i = 0; i<4; i++){
            if(i%2 == 0){
                evenPlaceCount[s1.charAt(i)-'a']++;
                evenPlaceCount[s2.charAt(i)-'a']--;
            } else {
                oddPlaceCount[s1.charAt(i)-'a']++;
                oddPlaceCount[s2.charAt(i)-'a']--;
            }
        }

        for(int i=0; i<26; i++){
            if(evenPlaceCount[i] != 0 || oddPlaceCount[i] != 0){
                return false;
            }
        }
        return true;
    }
}
