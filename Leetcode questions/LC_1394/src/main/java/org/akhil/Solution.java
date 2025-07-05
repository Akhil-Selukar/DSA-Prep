package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution 1 - Bruteforce
    //  O(N)/O(N)
//    public int findLucky(int[] arr) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        int result = -1;
//
//        for(int num:arr){
//            freq.put(num, freq.getOrDefault(num, 0)+1);
//        }
//
//        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
//            if(entry.getKey() == entry.getValue()) {
//                result = Math.max(result, entry.getKey());
//            }
//        }
//
//        return result;
//    }


    // Solution 2 - using sorting
    // O(NlogN)/O(1)
    // Even though complexity is nlogn but still this is faster that the above one as there is no hashing involved here.
//    public int findLucky(int[] arr) {
//        Arrays.sort(arr);
//        int result = -1;
//
//        for(int i=0; i<arr.length-1; i++){
//            int count = 1;
//            while(i<arr.length-1 && arr[i] == arr[i+1]){
//                i++;
//                count++;
//            }
//            if(arr[i] == count){
//                result = Math.max(result, count);
//            }
//        }
//
//        return result;
//    }


    // Solution 3 - bruteforce without hashMap
    // O(N)/O(501) - fastest one
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] freq = new int[501];
        int result = -1;

        for(int num:arr){
            freq[num]++;
        }

        for(int i=0; i<500; i++){
            if(i == freq[i]){
                result = Math.max(result, i);
            }
        }
        return result == 0 ? -1 : result;
    }
}
