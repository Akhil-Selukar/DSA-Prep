package org.akhil;

import java.util.HashMap;

public class Solution {

    // O(N)/O(1)
    public long countOfSubstrings(String word, int k) {
        return substringWithAtLeastKConsonants(word, k) - substringWithAtLeastKConsonants(word, k+1);
    }

    private long substringWithAtLeastKConsonants(String word, int k) {
        long count = 0;
        HashMap<Character, Integer> vowels = new HashMap<>();
        int consonants = 0;
        int start = 0;
        int end = 0;
        int wordLength = word.length();

        while(end < wordLength){
            char charAtEnd = word.charAt(end);

            // check if the charAtEnd is vowel or consonant
            if(isVowel(charAtEnd)){
                vowels.put(charAtEnd, vowels.getOrDefault(charAtEnd, 0)+1);
            } else {
                consonants++;
            }

            // check if condition is satisfied or not. Until the condition is valid shift start of the window to right.
            while(vowels.size() == 5 && consonants >= k){      // consonants GREATER than equal to K because we are checking for AT LEAST k (at end we are doing (k - (k+1)))
                count = count + (wordLength - end);         // once the valid substring is found then each addition of next char (end+1) will give a new valid substring.
                char charAtStart = word.charAt(start);

                if(isVowel(charAtStart)){
                    vowels.put(charAtStart, vowels.get(charAtStart)-1);
                    if(vowels.get(charAtStart) == 0){
                        vowels.remove(charAtStart);
                    }
                } else {
                    consonants--;
                }
                start++;
            }
            end++;
        }
        return count;
    }

    private boolean isVowel(char charAtEnd) {
        return "aeiou".indexOf(charAtEnd) != -1;
    }
}
