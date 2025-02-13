package org.akhil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // (O(N)/O(N))
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet();

        for(int i=0; i<s.length(); i++){
            char sChar = s.charAt(i);
            if(map.containsKey(sChar)){
                char tChar = map.get(sChar);
                if(t.charAt(i) != tChar){
                    return false;
                }
            } else {
                char tChar = t.charAt(i);
                if(mapped.contains(tChar)){
                    return false;
                }
                map.put(sChar, tChar);
                mapped.add(tChar);
            }
        }
        return true;
    }
}
