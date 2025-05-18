package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] lis = new int[n];         // to store longestIncreasingSubsequence
        int[] parent = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(parent, -1);

        int lisLen = 1, lisEnd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((groups[i] != groups[j])
                        && (words[i].length() == words[j].length())
                        && (getHammingDistance(words[i], words[j]) == 1)
                        && (lis[i] + 1 > lis[j])) {
                    lis[j] = lis[i] + 1;
                    parent[j] = i;
                    if (lis[j] > lisLen) {
                        lisLen = lis[j];
                        lisEnd = j;
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (int cur = lisEnd; cur != -1; cur = parent[cur]) {
            ans.add(0, words[cur]);
        }
        return ans;
    }

    private int getHammingDistance(String a, String b) {
        int distance = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
