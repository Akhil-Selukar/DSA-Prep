package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // Solution 1 - Bruteforce
    // O(N*W*L)/O(W*L)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int wLength = words.length;
        int length = words[0].length();

        if(s.length() == 0 || sLength < (length * wLength)){
            return result;
        }

        // count the frequency of words in given words array
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for(int i=0; i<sLength - wLength * length + 1; i++){
            String subString = s.substring(i, i + wLength * length);
            if(containsAllWords(subString, map, length)){       // check if the subString contains all words in words array or not.
                result.add(i);
            }
        }

        return result;
    }

    private boolean containsAllWords(String subStr, Map<String, Integer> map, int length){
        Map<String, Integer> currSubStrMap = new HashMap<>();
        int i=0;

        while(i<subStr.length()){
            String word = subStr.substring(i, i+length);
            currSubStrMap.put(word, currSubStrMap.getOrDefault(word, 0)+1);
            i = i+length;
        }
        return currSubStrMap.equals(map);
    }
}
