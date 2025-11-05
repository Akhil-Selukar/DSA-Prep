package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - Bruteforce (TLE)
    // O(KlogK * (n-k+1)) // O(K)
//    public long[] findXSum(int[] nums, int k, int x) {
//        Map<Long, Long> count = new HashMap<>();
//
//        int n = nums.length;
//        int startIndex = 0;
//        int endIndex = Math.min(k, n);
//        long[] result = new long[n-k+1];
//        int resultIndex = 0;
//
//        while(resultIndex < n-k+1){
//            long val = nums[startIndex];
//            count.put(val, count.getOrDefault(val, 0l)+1);
//
//            if(startIndex == endIndex-1){
//                result[resultIndex++] = getTopXCount(count, x);
//                count = new HashMap<>();
//                startIndex = resultIndex;
//                endIndex = Math.min(n, endIndex+1);
//            } else {
//                startIndex++;
//            }
//        }
//
//        return result;
//    }
//
//    private long getTopXCount(Map<Long, Long> count, int x){
//        List<long[]> list = new ArrayList<>();
//        for(Map.Entry<Long, Long> entry:count.entrySet()){
//            list.add(new long[]{entry.getValue(), entry.getKey()});
//        }
//
//        list.sort((a, b) -> {
//            if (a[0] != b[0]) {
//                return (int) (b[0] - a[0]);
//            } else {
//                return (int) (b[1] - a[1]);
//            }
//        });
//
//        long result = 0;
//        for(int i=0; i<Math.min(count.size(), x); i++) {
//            long val = list.get(i)[1] * list.get(i)[0];
//            result = result + val;
//        }
//
//        return result;
//    }


    // ----------------------

    // Solution 2 - Optimized solution
    // O(NlogN)
    public long[] findXSum(int[] nums, int k, int x) {
        Map<Long, Long> count = new HashMap<>();

        int n = nums.length;
        int startIndex = 0;
        int endIndex = Math.min(k, n);
        long[] result = new long[n-k+1];
        int resultIndex = 0;

        while(resultIndex < n-k+1){
            long val = nums[startIndex];
            count.put(val, count.getOrDefault(val, 0l)+1);

            if(startIndex == endIndex-1){
                result[resultIndex++] = getTopXCount(count, x);
                count = new HashMap<>();
                startIndex = resultIndex;
                endIndex = Math.min(n, endIndex+1);
            } else {
                startIndex++;
            }
        }

        return result;
    }

    private long getTopXCount(Map<Long, Long> count, int x){
        List<long[]> list = new ArrayList<>();
        for(Map.Entry<Long, Long> entry:count.entrySet()){
            list.add(new long[]{entry.getValue(), entry.getKey()});
        }

        list.sort((a, b) -> {
            if (a[0] != b[0]) {
                return (int) (b[0] - a[0]);
            } else {
                return (int) (b[1] - a[1]);
            }
        });

        long result = 0;
        for(int i=0; i<Math.min(count.size(), x); i++) {
            long val = list.get(i)[1] * list.get(i)[0];
            result = result + val;
        }

        return result;
    }
}
