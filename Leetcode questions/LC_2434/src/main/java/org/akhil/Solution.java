package org.akhil;

public class Solution {

    // O(N)/O(N) space complexity is to store result string.
    public String robotWithString(String s) {
        int n = s.length();

        // create a frequency array
        int[] freq = new int[26];
        for (int i = 0; i < n; ++i) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder t = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int pos = 0;

        while (pos < n) {
            t.append(s.charAt(pos));
            freq[s.charAt(pos) - 'a']--;

            while (t.length() > 0 && t.charAt(t.length() - 1) <= smallest(freq)) {
                result.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            pos++;
        }

        return result.toString();
    }

    private char smallest(int[] freq) {
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0)
                return (char) ('a' + i);
        }
        return 'z';
    }
}
