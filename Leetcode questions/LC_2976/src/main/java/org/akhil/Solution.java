package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(K+26^3+K)/O(26^2) Where K is length of string
    // i.e. O(K)/O(1)
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] shortestDist = new long[26][26];

        // load initial config (i.e. infinite dist for all)
        for (int i = 0; i < 26; i++) {
            Arrays.fill(shortestDist[i], (int)1e9);
            shortestDist[i][i] = 0; // Cost to change a character to itself is 0
        }

        // initial given cost for given changes in chars
        for(int i=0; i<original.length; i++){
            int sourceChar = original[i]-'a';
            int destChar = changed[i]-'a';
            int reqCost = cost[i];

            shortestDist[sourceChar][destChar] = Math.min(shortestDist[sourceChar][destChar], reqCost);
        }

        // Apply floyd warshall to find shortest path if present
        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                for(int j=0; j<26; j++){
                    shortestDist[i][j] = Math.min(shortestDist[i][j], shortestDist[i][k] + shortestDist[k][j]);
                }
            }
        }

        // traverse the string and add cost for conversion
        long totalMinCost = 0;
        for(int i=0; i<source.length(); i++){
            int sourceIndex = source.charAt(i)-'a';
            int targetIndex = target.charAt(i)-'a';

            if(shortestDist[sourceIndex][targetIndex] == (int)1e9){
                return -1;
            }
            totalMinCost = totalMinCost + shortestDist[sourceIndex][targetIndex];
        }

        return totalMinCost;
    }
}
