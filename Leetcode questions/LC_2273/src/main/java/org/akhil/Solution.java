package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Solution 1 - Using sorted array form of each word
    // O(N*LlogL)/O(N*L) where N is number of words in words[] and L is length of longest word in words[].
    // in space complexity during each iteration we need 2L to hold the array conversion of words.
//    public List<String> removeAnagrams(String[] words) {
//        List<String> result = new ArrayList<>();
//        result.add(words[0]);
//
//        for(int i=1; i<words.length; i++){              // O(N)
//            char[] arr1 = words[i-1].toCharArray();
//            char[] arr2 = words[i].toCharArray();
//
//            Arrays.sort(arr1);          // O(LLogL)
//            Arrays.sort(arr2);          // O(LLogL)
//
//            if(!Arrays.equals(arr1, arr2)){         // O(L)
//                result.add(words[i]);
//            }
//        }
//
//        return result;
//    }


    // -----------------------
    // Solution 2 - using counting to check anagram
    // O(N*L)/O(N)
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);

        for(int i=1; i<words.length; i++){              // O(N)
            if(!checkAnagram(words[i-1], words[i])){
                result.add(words[i]);
            }
        }

        return result;
    }


    // O(L) where L is max length of word in words[]
    private boolean checkAnagram(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }

        int[] count = new int[26];
        for(int i=0; i<word1.length(); i++){
            count[word1.charAt(i)-'a']++;
            count[word2.charAt(i)-'a']--;
        }

        for(int val:count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
