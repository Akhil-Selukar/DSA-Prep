package org.akhil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Solution 1 - Bruteforce (TLE)
    // O(N^3)/O(N)
//    public int subarrayBitwiseORs(int[] arr) {
//        int n = arr.length;
//        Set<Integer> set = new HashSet<>();
//
//        for(int i=0; i<n; i++){
//            for(int j=i; j<n; j++){
//                int orVal = 0;
//                for(int start=i; start <= j; start++){
//                    orVal = orVal | arr[start];
//                }
//                set.add(orVal);
//            }
//        }
//        return set.size();
//    }

    // Solution 2 -
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        for(int val:arr){
            Set<Integer> next = new HashSet<>();
            next.add(val);
            for(int setVal:current){
                next.add(setVal | val);
            }
            current = next;
            result.addAll(current);
        }
        return result.size();
    }
}
