package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    // Solution 1 - normal recursion (Accepted)
//    // O(L + 2^W * Wmax)
//    // O(W) i.e. recursive call stack depth
//
//    Map<Character, Integer> freq = new HashMap<>(); // O(1) space as there can be at max 26 chars
//    int result = 0;
//    public int maxScoreWords(String[] words, char[] letters, int[] score) {
//        for(char letter:letters){       // O(L)
//            freq.put(letter, freq.getOrDefault(letter, 0)+1);
//        }
//
//        helper(words, score, 0, 0);     // O(2^W) where W is length of words array. O(W) space i.e. recursion depth (1 level for each word consideration)
//
//        return result;
//    }
//
//    private void helper(String[] words, int[] score, int index, int currScore) {
//        if(index >= words.length){
//            result = Math.max(result, currScore);
//            return;
//        }
//
//        // decide to take the word
//        // check if can be created with available letters
//        int[] validity = create(words[index], score);       // O(Wmax)  where Wmax is length of the longest word
//        if(validity[0] == 1){
//            currScore = currScore + validity[1];
//            helper(words, score, index+1, currScore);
//            currScore = currScore - validity[1];
//        }
//        repopulate(words[index], validity[2]);      // O(Wmax)
//
//        // decide to skip the word
//        helper(words, score, index+1, currScore);
//    }
//
//    private int[] create(String word, int[] score) {
//        int sum = 0;
//        int index = -1;
//        for(int i=0; i<word.length(); i++){
//            char ch = word.charAt(i);
//            if(freq.containsKey(ch)){
//                freq.put(ch, freq.get(ch)-1);
//                index = i;
//                if(freq.get(ch) == 0){
//                    freq.remove(ch);
//                }
//                sum = sum + score[ch-'a'];
//            } else {
//                repopulate(word, index);
//                return new int[]{0,0,-1};
//            }
//        }
//
//        return new int[]{1, sum, index};
//    }
//
//    private void repopulate(String word, int index){
//        while(index >= 0){
//            char ch = word.charAt(index);
//            freq.put(ch, freq.getOrDefault(ch, 0)+1);
//            index--;
//        }
//    }


    // Solution 1.1 - As hashMap uses hashing and all which consume fraction of sec hence converting it to array
    // this small change makes the code 100% better in time complexity and 97% better in space complexity.
    // O(L + 2^W * Wmax)
    // O(W) i.e. recursive call stack depth

    int[] freq = new int[26]; // O(1) space as there can be at max 26 chars
    int result = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for(char letter:letters){       // O(L)
            freq[letter-'a']++;
        }

        helper(words, score, 0, 0);     // O(2^W) where W is length of words array. O(W) space i.e. recursion depth (1 level for each word consideration)

        return result;
    }

    private void helper(String[] words, int[] score, int index, int currScore) {
        if(index >= words.length){
            result = Math.max(result, currScore);
            return;
        }

        // decide to take the word
        // check if can be created with available letters
        int[] validity = create(words[index], score);       // O(Wmax)  where Wmax is length of the longest word
        if(validity[0] == 1){
            currScore = currScore + validity[1];
            helper(words, score, index+1, currScore);
            currScore = currScore - validity[1];
        }
        repopulate(words[index], validity[2]);      // O(Wmax)

        // decide to skip the word
        helper(words, score, index+1, currScore);
    }

    private int[] create(String word, int[] score) {
        int sum = 0;
        int index = -1;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(freq[ch-'a'] > 0){
                freq[ch-'a']--;
                index = i;
                sum = sum + score[ch-'a'];
            } else {
                repopulate(word, index);
                return new int[]{0,0,-1};
            }
        }

        return new int[]{1, sum, index};
    }

    private void repopulate(String word, int index){
        while(index >= 0){
            char ch = word.charAt(index);
            freq[ch-'a']++;
            index--;
        }
    }
}
