package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution 1 - Using Map (O(N+M)/O(M) where M is length of magazine)
//    public boolean canConstruct(String ransomNote, String magazine) {
//        if(magazine.length() < ransomNote.length()){
//            return false;
//        }
//
//        Map<Character, Integer> map = new HashMap<>();
//
//        for(int i=0; i<magazine.length(); i++){
//            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0)+1);
//        }
//
//        for(char ch:ransomNote.toCharArray()){
//            if(map.containsKey(ch)){
//                if(map.get(ch) == 0){
//                    return false;
//                } else {
//                    map.put(ch, map.get(ch)-1);
//                }
//            } else {
//                return false;
//            }
//        }
//
//        return true;
//    }

    // Solution 2 - Using array (O(M+N)/O(1))
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (arr[ch - 'a'] == 0) {
                return false;
            } else {
                arr[ch - 'a']--;
            }
        }
        return true;
    }
}
