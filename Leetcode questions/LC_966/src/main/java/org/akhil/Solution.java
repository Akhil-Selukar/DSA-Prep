package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    // O(N*L + Q*L)/O(N*L + Q*L)  where N is number of strings in wordList and Q is number of strings in queries while L is length of longest string.
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch = new HashSet<>();
        Map<String, String> caseMatch = new HashMap<>();
        Map<String, String> vowelMatch = new HashMap<>();
        String[] result = new String[queries.length];

        for(String word:wordlist){
            exactMatch.add(word);
            if(!caseMatch.containsKey(word.toLowerCase())) {        // as we want first match
                caseMatch.put(word.toLowerCase(), word);
            }
            StringBuilder sb = new StringBuilder(word.toLowerCase());
            for(int i=0; i<word.length(); i++){
                char ch = sb.charAt(i);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    sb.setCharAt(i, '*');
                }
            }
            if(!vowelMatch.containsKey(sb.toString())) {
                vowelMatch.put(sb.toString(), word);
            }
        }

        for(int i=0; i<queries.length; i++){
            String word = queries[i];

            // check exact match
            if(exactMatch.contains(word)){
                result[i] = word;
            } else if(caseMatch.containsKey(word.toLowerCase())){
                result[i] = caseMatch.get(word.toLowerCase());
            } else {
                String str = checkVowelMatch(word, vowelMatch);
                result[i] = str;
            }
        }

        return result;
    }

    private String checkVowelMatch(String word, Map<String, String> vowelMatch){

        StringBuilder sb = new StringBuilder(word.toLowerCase());
        for(int i=0; i<word.length(); i++){
            char ch = sb.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                sb.setCharAt(i, '*');
            }
        }

        String newWord = sb.toString();

        if(vowelMatch.containsKey(newWord)){
            return vowelMatch.get(newWord);
        }

        return "";
    }
}
