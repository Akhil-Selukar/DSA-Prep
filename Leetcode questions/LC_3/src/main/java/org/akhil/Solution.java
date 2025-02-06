package org.akhil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {


    // Solution 1 - (O(N^2)/O(N))
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        Set<Character> temp = new HashSet<>();

        for(int end=0; end<s.length(); end++){
            char ch = s.charAt(end);
//            if(temp.contains(ch)){
                while(temp.contains(ch)){
                    temp.remove(s.charAt(start));
                    start++;
                }
//            }

            temp.add(ch);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    // Solution 2 - (more intuitive)
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        Queue<Character> temp = new LinkedList<>();

        for(int end=0; end<s.length(); end++){
            char ch = s.charAt(end);
            while(temp.contains(ch)){
                temp.poll();
            }

            temp.offer(ch);
            maxLength = Math.max(maxLength, temp.size());
        }
        return maxLength;
    }
}
