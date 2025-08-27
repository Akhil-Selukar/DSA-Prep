package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // Solution
    // O(N)/O(N)
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int result = 1;         // atleast 1 will be the answer in any case

        for(char ch:s.toCharArray()){
            if(set.contains(ch)){
                result++;
                set.clear();
            }
            set.add(ch);
        }
        return result;
    }
}
