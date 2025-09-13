package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int vowels = 0;
        int consonant = 0;

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels = Math.max(vowels, freq[ch - 'a']);
            } else {
                consonant = Math.max(consonant, freq[ch - 'a']);
            }
        }

        return vowels + consonant;
    }
}
