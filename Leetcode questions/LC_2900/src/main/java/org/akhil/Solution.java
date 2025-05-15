package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int digit = -1;

        for (int i = 0; i < words.length; i++) {
            if (digit != groups[i]) {
                digit = groups[i];
                res.add(words[i]);
            }
        }
        return res;
    }
}
