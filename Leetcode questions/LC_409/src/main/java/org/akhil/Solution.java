package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Using Map (O(N)/O(N))
//    public int longestPalindrome(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        for(char ch:s.toCharArray()){
//            map.put(ch, map.getOrDefault(ch, 0)+1);
//        }
//
//        int ones = 0;
//        int length = 0;
//
//        for(Map.Entry entry:map.entrySet()){
//            length = length + (2* ((int)entry.getValue()/2));
//            if((int)entry.getValue() % 2 == 1){
//                ones++;
//            }
//        }
//
//        return length + (ones != 0 ? 1 : 0);
//    }

    // Solution 2 - using array (O(N)/O(1))
    public int longestPalindrome(String s) {
        int[] count = new int[256];

        for(char ch:s.toCharArray()){
            count[ch]++;
        }

        int ones = 0;
        int length = 0;

        for(int ch:count){
            length = length + (2* (ch/2));
            if(ch % 2 == 1){
                ones++;
            }
        }

        return length + (ones != 0 ? 1 : 0);
    }
}
