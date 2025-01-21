package org.akhil;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String word:strs){
            char[] charInWord = word.toCharArray();
            Arrays.sort(charInWord);

            String sortedWord = new String(charInWord);

            if(!anagrams.containsKey(sortedWord)){
                anagrams.put(sortedWord, new ArrayList<>());
            }

            anagrams.get(sortedWord).add(word);
        }

        for(List<String> list:anagrams.values()){
            ans.add(list);
        }

        return ans;
    }
}
