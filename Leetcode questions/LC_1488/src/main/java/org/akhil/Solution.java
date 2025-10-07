package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - (bruteforce) Using array for dryDay tracking
    // O(N^2)/O(N) - Should give TLE as per constraints but getting accepted as of now.
//    public int[] avoidFlood(int[] rains) {
//        int n = rains.length;
//        int[] result = new int[n];
//        Arrays.fill(result, 1);
//
//        Map<Integer, Integer> filled = new HashMap<>();         // [lake, index];
//        boolean[] dryDays = new boolean[n];
//
//        // find all dryDays
//        for(int i=0; i<n; i++){
//            if(rains[i] == 0){
//                dryDays[i] = true;
//            }
//        }
//
//        // now iterate over all rains and check for overflow
//        for(int i=0; i<n; i++){
//            int lake = rains[i];
//
//            // if there is a rain on ith day, then we will have to check if the lake is already filled or not
//            if(lake != 0){
//                if(filled.containsKey(lake)){
//                    int lakeWasFilledOn = filled.get(lake);
//
//                    // now check from last day that lake was filled till today is there any dry day?
//                    int lakeCanBeDriedOn = -1;
//                    for(int j=lakeWasFilledOn; j<i; j++){
//                        if(dryDays[j]){
//                            lakeCanBeDriedOn = j;
//                            dryDays[j] = false;
//                            break;
//                        }
//                    }
//                    if(lakeCanBeDriedOn == -1){
//                        return new int[]{};
//                    } else {
//                        result[lakeCanBeDriedOn] = lake;
//                    }
//                }
//
//                // mark the lake as filled and put in filled map the lake and when was it filled.
//                filled.put(lake, i);
//                result[i] = -1;
//            }
//
//        }
//        return result;
//    }

    // Solution 2 - Using treeSet to track dryDays (As we need dryDays in sorted order and treeSet is sorted with TC of logN)
    // O(N*logN)/O(N)

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        Map<Integer, Integer> filled = new HashMap<>();         // [lake, index];
        TreeSet<Integer> dryDays = new TreeSet<>();

//      find all dryDays
        for(int i=0; i<n; i++){
            if(rains[i] == 0){
                dryDays.add(i);
            }
        }

        // now iterate over all rains and check for overflow
        for(int i=0; i<n; i++){
            int lake = rains[i];

            // if there is a rain on ith day, then we will have to check if the lake is already filled or not
            if(lake != 0){
                if(filled.containsKey(lake)){
                    int lakeWasFilledOn = filled.get(lake);

                    // now check from last day that lake was filled till today is there any dry day?
                    Integer lakeCanBeDriedOn = dryDays.ceiling(lakeWasFilledOn);    // this will give smallest element greater than lakeWasFilledOn

                    // as we have precomputed the dry days so it can give day which is in future hence lakeCanBeDriedOn should always be < i
                    if(lakeCanBeDriedOn == null || lakeCanBeDriedOn > i){
                        return new int[]{};
                    } else {
                        result[lakeCanBeDriedOn] = lake;
                        dryDays.remove(lakeCanBeDriedOn);
                    }
                }

                // mark the lake as filled and put in filled map the lake and when was it filled.
                filled.put(lake, i);
                result[i] = -1;
            }

        }
        return result;
    }
}
