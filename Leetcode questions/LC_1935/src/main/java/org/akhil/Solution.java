package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Solution 1 - using array
    //
    public int canBeTypedWords(String text, String brokenLetters) {
        int[] brokenChars = new int[26];

        for(char ch:brokenLetters.toCharArray()){
            brokenChars[ch-'a']++;
        }

        String[] words = text.split("\\s");
        int count = words.length;

        for(String word:words){
            for(char ch:word.toCharArray()){
                if(brokenChars[ch-'a'] != 0){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    //------------
    // solution 2 - using set
    // O(N)/O(N) Where N is length of text and L is length of broken words
//    public int canBeTypedWords(String text, String brokenLetters) {
//        Set<Character> brokenChars = new HashSet<>();
//
//        for(char ch:brokenLetters.toCharArray()){
//            brokenChars.add(ch);
//        }
//
//        String[] words = text.split("\\s");
//        int count = words.length;
//
//        for(String word:words){
//            for(char ch:word.toCharArray()){
//                if(brokenChars.contains(ch)){
//                    count--;
//                    break;
//                }
//            }
//        }
//        return count;
//    }
}
