package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - using Map (O(N)/O(N)) near linear space complexity.
//    public boolean isAnagram(String s, String t) {
//        if(s.length() != t.length()){
//            return false;
//        }
//
//        Map<Character, Integer> map = new HashMap<>();
//
//        for(int i=0; i<s.length(); i++){
//            char sChar = s.charAt(i);
//            char tChar = t.charAt(i);
//
//            map.put(sChar, map.getOrDefault(sChar, 0)+1);
//            map.put(tChar, map.getOrDefault(tChar, 0)-1);
//        }
//
//        for(Integer value:map.values()){
//            if(value != 0){
//                return false;
//            }
//        }
//
//        return true;
//    }

    // Solution 2 - Using array (O(N)/O(1))     Here even though time complexity is same for both the code but this will be a bit faster but will require more space if Strings are of smaller size
    // because if string is of almost 10-50 char long still we will need to create array of 256 length, while in case of map if String is of 50 chars then we will only use 50 places to store values
    // no need to reserve 256 places in advance.
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] arr = new int[256];         // 256 because we will store count based on ASCII value of each char in s and t.

        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            arr[sChar]++;
            arr[tChar]--;
        }

        for(int count:arr){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
