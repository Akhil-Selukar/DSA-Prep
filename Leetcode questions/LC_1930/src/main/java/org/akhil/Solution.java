package org.akhil;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    // Solution 1 -> Brute force
    // O(N^3)/O(1) -> TLE
//    public int countPalindromicSubsequence(String s) {
//        StringBuilder sb = new StringBuilder();
//        Set<String> set = new HashSet<>();
//
//        for(int i=0; i<s.length(); i++){
//            sb.append(s.charAt(i));
//            for(int j=i+1; j<s.length(); j++){
//                sb.append(s.charAt(j));
//                for(int k=j+1; k<s.length(); k++){
//                    sb.append(s.charAt(k));
//                    if(isPalindrome(sb.toString())) {
//                        set.add(sb.toString());
//                    }
//                    sb.deleteCharAt(sb.length()-1);
//                }
//                sb.deleteCharAt(sb.length()-1);
//            }
//            sb.deleteCharAt(sb.length()-1);
//        }
//
//        System.out.println(set.toString());
//        return set.size();
//    }
//
//    private boolean isPalindrome(String s){
//        int start = 0;
//        int end = s.length()-1;
//
//        while(start <= end){
//            if(s.charAt(start) != s.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    //---------------------------
    // Solution 2 - Optimized
    // O(N)/O(N)
    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);
        int result = 0;

        // precompute first and last index of each unique character.
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(firstIndex[ch-'a'] == -1){
                firstIndex[ch-'a'] = i;
            } else {
                lastIndex[ch-'a'] = i;
            }
        }

        // check for all chars
        for(int i=0; i<26; i++){
            if(firstIndex[i] == -1 || lastIndex[i] == -1){
                continue;
            }

            Set<Character> uniqueInBetween = new HashSet<>();
            for(int j=firstIndex[i]+1; j<lastIndex[i]; j++){
                uniqueInBetween.add(s.charAt(j));
            }

            result = result+uniqueInBetween.size();
        }
        return result;
    }
}
