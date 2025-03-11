package org.akhil;

import java.util.HashMap;

public class Solution {

    // Solution 1 - O(N)/O(1)
//    public int numberOfSubstrings(String s) {
//        int n = s.length();
//        int start = 0;
//        int end = 0;
//        int count = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        while(end<n){
//            char charAtEnd = s.charAt(end);
//            map.put(charAtEnd, map.getOrDefault(charAtEnd, 0)+1);
//
//            while(map.size() == 3){
//                count = count + (n-end);
//
//                char charAtStart = s.charAt(start);
//                map.put(charAtStart, map.get(charAtStart)-1);
//                if(map.get(charAtStart) == 0){
//                    map.remove(charAtStart);
//                }
//                start++;
//            }
//            end++;
//        }
//        return count;
//    }

    // Solution 2 - O(N)/O(1)
    // As we know that there can be only 3 chars 'a','b' and 'c' in the string so we can eliminate the HashMap.
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int count = 0;
        int[] frequency = new int[3];

        while(end<n){
            char charAtEnd = s.charAt(end);
            frequency[charAtEnd - 'a'] += 1;

            while(frequency[0] != 0 && frequency[1] != 0 && frequency[2] != 0){
                count = count + (n-end);

                char charAtStart = s.charAt(start);
                frequency[charAtStart - 'a'] -=1;
                start++;
            }
            end++;
        }
        return count;
    }
}
