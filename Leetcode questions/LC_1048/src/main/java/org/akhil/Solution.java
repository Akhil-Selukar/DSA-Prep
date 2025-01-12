package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (String a, String b) -> {return a.length()-b.length();});
        Map<String, Integer> dp = new HashMap<>();
        int maxPath = 1;

        for(String word:words){
            int currentLength = 1;
            StringBuilder sb = new StringBuilder(word);
            for(int i=0; i<word.length(); i++){
                sb.deleteCharAt(i);
                String previousWord = sb.toString();
                currentLength = Math.max(currentLength, dp.getOrDefault(previousWord, 0)+1);
                sb.insert(i, word.charAt(i));
            }
            dp.put(word, currentLength);
            maxPath = Math.max(maxPath, currentLength);
        }
        return maxPath;
    }
}
