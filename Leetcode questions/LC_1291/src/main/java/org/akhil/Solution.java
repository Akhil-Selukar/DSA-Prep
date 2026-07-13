package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        String maxPossible = "123456789";      // This is the maxString possible (not "987654321" because we need ascending order only)
        int minLen = Integer.toString(low).length();
        int maxLen = Integer.toString(high).length();

        for(int len=minLen; len<=maxLen; len++){        // we can have this length of strings in result
            for(int start=0; start+len<=9; start++){    // if string start from start index then start + len (i.e. end index should not go beyond range
                String subStr = maxPossible.substring(start, start+len);
                int val = Integer.parseInt(subStr);
                if(val >= low && val <= high){
                    result.add(val);
                }
            }
        }
        return result;
    }
}
