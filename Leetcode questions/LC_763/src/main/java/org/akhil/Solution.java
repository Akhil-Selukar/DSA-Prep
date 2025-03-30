package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // O(N)/O(K) where K is number of unique elements in s.
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        int length = s.length();
        Map<Character, Integer> lastIndex = new HashMap<>();

        for(int i=0; i<length; i++){
            lastIndex.put(s.charAt(i), i);
        }

        for(int i=0; i<length; i++){
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if(i == end){
                ans.add(end-start+1);
                start = end+1;
            }
        }

        return ans;
    }
}
