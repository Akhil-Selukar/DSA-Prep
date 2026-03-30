package org.akhil;

public class Solution {
    // O(N)/O(1)
    public boolean checkStrings(String s1, String s2) {
        int[] evenPlaceCount = new int[26];
        int[] oddPlaceCount = new int[26];

        for(int i=0; i<s1.length(); i++){
            if(i%2 == 0){
                evenPlaceCount[s1.charAt(i)-'a']++;
                evenPlaceCount[s2.charAt(i)-'a']--;
            } else {
                oddPlaceCount[s1.charAt(i)-'a']++;
                oddPlaceCount[s2.charAt(i)-'a']--;
            }
        }

        for(int i=0; i<s1.length(); i++){
            if(oddPlaceCount[i] != 0 || evenPlaceCount[i] != 0){
                return false;
            }
        }
        return true;
    }
}
