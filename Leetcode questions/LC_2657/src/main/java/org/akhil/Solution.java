package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {
//    // O(N)/O(N)
//    public int[] findThePrefixCommonArray(int[] A, int[] B) {
//        int n = A.length;
//        int[] result = new int[n];
//
//        Set<Integer> seenA = new HashSet<>();
//        Set<Integer> seenB = new HashSet<>();
//        int count = 0;
//
//        for(int i=0; i<n; i++){
//            int valA = A[i];
//            int valB = B[i];
//
//            seenA.add(valA);
//            seenB.add(valB);
//
//            if(valA == valB){
//                count++;
//            } else {
//                if(seenA.contains(valB)){
//                    count++;
//                }
//                if(seenB.contains(valA)){
//                    count++;
//                }
//            }
//
//            result[i] = count;
//        }
//
//        return result;
//    }


    // -----------------------
    // Solution 2 - With less space, no change on complexity but use a bit less space and a bit fast as no hashing is involved.
    // O(N)/O(N)
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int[] freq = new int[n+1];      // because given arrays contains values from 1 to n
        int count = 0;

        for(int i=0; i<n; i++){
            int valA = A[i];
            int valB = B[i];

            freq[valA]++;
            if(freq[valA] == 2){
                count++;
            }

            freq[valB]++;
            if(freq[valB] == 2){
                count++;
            }

            result[i] = count;
        }

        return result;
    }
}
