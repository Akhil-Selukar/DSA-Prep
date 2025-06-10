package org.akhil;

public class Solution {

    // O(N)/O(1)
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int i=25; i>=0; i--){
            if(freq[i] != 0){
                if(freq[i]%2 == 1){
                    maxOdd = Math.max(maxOdd, freq[i]);
                }
                if(freq[i]%2 == 0){
                    minEven = Math.min(minEven, freq[i]);
                }
            }
        }

        return maxOdd - minEven;
    }
}
