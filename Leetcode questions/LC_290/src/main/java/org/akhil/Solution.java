package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    // Solution 1 - using map - (O(N^2)/O(N))   - O(N^2) time complexity because line 'map.values().contains(word)' or 'map.containsValue(word)'
    // will loop through entire values in the map which will take O(N) in worst case the values in map can be N hence O(N^2).
    // (Actually it will be slightly less that N^2 because values in Map will be N only for last iteration. but still this has impact on time consumed)
//    public boolean wordPattern(String pattern, String s) {
//        String[] words = s.split("\\s");
//        Map<Character, String> map = new HashMap<>();
//
//        if(words.length != pattern.length()){
//            return false;
//        }
//
//        for(int i=0; i<words.length; i++){
//            char ch = pattern.charAt(i);
//            String word = words[i];
//
//            if(!map.containsKey(ch)){
//                if(map.values().contains(word)){
//                    return false;
//                }
//                map.put(ch, word);
//            } else {
//                if(!map.get(ch).equals(word)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // Solution 1.1 - using hashSet (O(N)/O(N)) - This code will be faster that the above one as we are not using any map.containsValue() operation. But here we are consuming some space for Set.
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        Map<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        if(words.length != pattern.length()){
            return false;
        }

        for(int i=0; i<words.length; i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            if(!map.containsKey(ch)){
                if(set.contains(word)){
                    return false;
                }
                map.put(ch, word);
                set.add(word);
            } else {
                if(!map.get(ch).equals(word)){
                    return false;
                }
            }
        }
        return true;
    }
}
