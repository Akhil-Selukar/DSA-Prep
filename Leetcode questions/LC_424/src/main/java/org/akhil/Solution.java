package org.akhil;

public class Solution {

    // O(O(N)/O(1))
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int pointer1 = 0;
        int maxLength = 0;
        int maxRepeatingCharCount = 0;

        for(int pointer2 = 0; pointer2 < s.length(); pointer2++){
            frequency[s.charAt(pointer2) - 'A']++;      // frequency of character at endIndex of window.

            maxRepeatingCharCount = Math.max(maxRepeatingCharCount, frequency[s.charAt(pointer2)-'A']);

            int charToReplace = (pointer2 - pointer1 + 1) - maxRepeatingCharCount;

            if(charToReplace > k){      // That means we have more than K chars which differs and need to be replaced.
                frequency[s.charAt(pointer1) - 'A']--;      // because the char at pointer1 is out of window now.
                pointer1++;     // slide the start of window to right.
            }

            maxLength = Math.max(maxLength, (pointer2 - pointer1 + 1));
        }

        return maxLength;
    }
}
