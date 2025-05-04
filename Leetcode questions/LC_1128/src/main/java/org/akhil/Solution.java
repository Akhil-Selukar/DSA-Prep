package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // O(N)/O(N)        Here even though we are using Arrays.sort() which has logarithmic time complexity but we know that in each pair there will be exactly 2 elements hence we can consider this as constant time complexity.
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> count = new HashMap<>();

        for(int[] pair:dominoes){
            Arrays.sort(pair);
            String sumStr = "" + pair[0] + pair[1];
            count.put(sumStr, count.getOrDefault(sumStr, 0)+1);
        }

        int res = 0;
        for(Map.Entry<String, Integer> entry:count.entrySet()){
            if(entry.getValue() > 1){
                res = res + getPairCount(entry.getValue());
            }
        }

        return res;
    }

    private int getPairCount(Integer n) {
        return n * (n-1)/2;
    }

    // Solution 2 - Another approach without using hashMap

    public int numEquivDominoPairs1(int[][] dominoes) {
        int[] num = new int[100];       // as we know that the number of domino can be between 1 to 9 hence at max the combination will create 99 value

        int res = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];       // to check the rotation as well.
            res = res + num[val];
            num[val]++;
        }
        return res;
    }
}
