package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];      // to store first index of each char
        int[] last = new int[26];        // to store last index of each char
        boolean[] isValid = new boolean[26];    // to store if current element if already seen earlier or not.

        Arrays.fill(first, -1);
        Arrays.fill(isValid, true);

        List<String> result = new ArrayList<>();

        // store first and last index of every char.
        for(int i=0; i<n; i++) {
            int charIndex = s.charAt(i) - 'a';

            if (first[charIndex] == -1) {
                first[charIndex] = i;
            }
            last[charIndex] = i;
        }

        // check all chars of strinng
        for(int i=0; i<26; i++) {
            if (first[i] == -1){
                continue;
            }

            for(int j=first[i]; j<=last[i]; j++) {
                int charIndex = s.charAt(j) - 'a';

                if (first[charIndex] < first[i]) {
                    isValid[i] = false;
                    break;
                }

                last[i] = Math.max(last[i], last[charIndex]);
            }
        }

        int lastTakenStart = Integer.MAX_VALUE;

        for(int i=n-1; i>=0; i--) {
            int charIndex = s.charAt(i) - 'a';

            if(!isValid[charIndex]){
                continue;
            }

            if(i==first[charIndex] && last[charIndex]<lastTakenStart) {
                result.add(s.substring(i, last[charIndex] + 1));
                lastTakenStart = i;
            }
        }

        return result;
    }
}
