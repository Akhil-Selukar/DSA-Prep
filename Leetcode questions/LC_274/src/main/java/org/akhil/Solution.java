package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - (O(N)/O(N)
//    public int hIndex(int[] citations) {
//        int n = citations.length;
//        Map<Integer, Integer> frequency = new HashMap<>();
//        int totalCitations = 0;
//
//        for(int num:citations){
//            if(num > n){
//                num = n;
//            }
//            frequency.put(num, frequency.getOrDefault(num, 0)+1);
//        }
//
//        for(int i=n; i>=0; i--){
//            totalCitations = totalCitations+frequency.getOrDefault(i, 0);
//            if(totalCitations>=i){
//                return i;
//            }
//        }
//        return -1;
//    }

    //Solution 2 - (O(Nlog(N))/O(1))
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        for(int i=0; i<n; i++){
            if(citations[i] >= n-i){
                return n-i;
            }
        }
        return 0;
    }
}
