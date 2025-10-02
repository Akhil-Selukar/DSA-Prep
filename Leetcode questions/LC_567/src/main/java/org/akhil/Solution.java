package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(N1+N2)/O(26) i.e. constant
    public boolean checkInclusion(String s1, String s2) {

        // if s2 is smaller than s1 then s1 can not be a substring of s2
        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Integer> s1Count = new HashMap<>();
        Map<Character, Integer> s2Count = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            s1Count.put(s1.charAt(i), s1Count.getOrDefault(s1.charAt(i), 0)+1);
            s2Count.put(s2.charAt(i), s2Count.getOrDefault(s2.charAt(i), 0)+1);
        }

        // if both maps are equal then we found the equal permutation
        // Here equality must be .equals() and not ==.
        if(s1Count.equals(s2Count)){
            return true;
        }

        // otherwise remove left/start char from s2 and add right/end char in it and again check
        int start = 0;
        for(int end = s1.length(); end<s2.length(); end++){
            // remove charAt start
            char charAtStart = s2.charAt(start);
            s2Count.put(charAtStart, s2Count.get(charAtStart)-1);

            if(s2Count.get(charAtStart) == 0){
                s2Count.remove(charAtStart);
            }
            start++;

            // add charAt end
            char charAtEnd = s2.charAt(end);
            s2Count.put(charAtEnd, s2Count.getOrDefault(charAtEnd, 0)+1);

            // check for substring match
            if(s1Count.equals(s2Count)){
                return true;
            }
        }
        return false;
    }
}
