package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Using Map
    // O(N1+N2)/O(26) i.e. constant
//    public boolean checkInclusion(String s1, String s2) {
//
//        // if s2 is smaller than s1 then s1 can not be a substring of s2
//        if(s1.length() > s2.length()){
//            return false;
//        }
//
//        Map<Character, Integer> s1Count = new HashMap<>();
//        Map<Character, Integer> s2Count = new HashMap<>();
//
//        for(int i=0; i<s1.length(); i++){
//            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0)+1);
//            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0)+1);
//        }
//
//        // if both maps are equal then we found the equal permutation
//        // Here equality must be .equals() and not ==.
//        if(s1Count.equals(s2Count)){
//            return true;
//        }
//
//        // otherwise remove left/start char from s2 and add right/end char in it and again check
//        int start = 0;
//        for(int end = s1.length(); end<s2.length(); end++){
//            // remove charAt start
//            char charAtStart = s2.charAt(start);
//            s2Count.put(charAtStart, s2Count.get(charAtStart)-1);
//
//            if(s2Count.get(charAtStart) == 0){
//                s2Count.remove(charAtStart);
//            }
//            start++;
//
//            // add charAt end
//            char charAtEnd = s2.charAt(end);
//            s2Count.put(charAtEnd, s2Count.getOrDefault(charAtEnd, 0)+1);
//
//            // check for substring match
//            if(s1Count.equals(s2Count)){
//                return true;
//            }
//        }
//        return false;
//    }

    // ---------------------
    // Solution 2 - Using array (reduces the overhead of hashing

    public boolean checkInclusion(String s1, String s2) {

        // if s2 is smaller than s1 then s1 can not be a substring of s2
        if(s1.length() > s2.length()){
            return false;
        }

        int[] freq = new int[26];

        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        // if the char is present in both and of equal no of times then overall freq will be 0 for that char
        int balanced = 0;
        for(int num:freq){
            if(num == 0){
                balanced++;
            }
        }
        if(balanced == 26){
            return true;
        }


        // otherwise remove left/start char from s2 and add right/end char in it and again check
        int start = 0;
        for(int end = s1.length(); end<s2.length(); end++){
            // remove charAt start
            freq[s2.charAt(start)-'a']++;       // doing ++ because in case of s2 considering character means -1 in freq
            start++;

            // add charAt end
            freq[s2.charAt(end)-'a']--;

            // check if all freq 0?
            balanced = 0;
            for(int num:freq){
                if(num == 0){
                    balanced++;
                }
            }
            if(balanced == 26){
                return true;
            }
        }
        return false;
    }
}
