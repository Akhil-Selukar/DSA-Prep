package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(N)/O(N)
    // Time complexity is O(N*L) but as L i.e. average length of word is 2 i.e. constant here hence effective time complexity is O(N)
    public int longestPalindrome(String[] words) {
        Map<String, Integer> frequency = new HashMap<>();
        int size = 0;

        // iterate over words and check reverse
        for(String word:words){
            String reverse = ""+word.charAt(1)+word.charAt(0);
            if(frequency.containsKey(reverse)){
                size += 4;                                              // added the pair in palindrome
                frequency.put(reverse, frequency.get(reverse)-1);       // consumed the word stored in map with current word.

                if(frequency.get(reverse) == 0){
                    frequency.remove(reverse);
                }
            } else {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        // check for word with same char at both places (such word if present only 1's then can be used only 1 such word. If present twice (even times) will be considered above)
        for(Map.Entry<String, Integer> entry:frequency.entrySet()){
            if(entry.getKey().charAt(0) == entry.getKey().charAt(1)){
                size +=2;
                return size;
            }
        }

        return size;
    }
}
