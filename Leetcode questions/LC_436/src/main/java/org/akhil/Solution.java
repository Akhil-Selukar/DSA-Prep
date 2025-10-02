package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - using sorting
    // O(NlogN)/O(N)
//    public int[] findRightInterval(int[][] intervals) {
//        int n = intervals.length;
//        int[] result = new int[n];
//        Arrays.fill(result, -1);
//
//        List<int[]> list = new ArrayList<>();
//        for(int i=0; i<n; i++){
//            list.add(new int[]{intervals[i][0], intervals[i][1], i});
//        }
//
//        Collections.sort(list, (a, b)->a[0]-b[0]);
//
//        for(int i=0; i<n; i++){
//            int[] curr = list.get(i);
//            for(int j=i; j<n; j++){
//                int[] next = list.get(j);
//                if(curr[1] <= next[0]){
//                    result[curr[2]] = next[2];
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }

    // ------------------------
    // Solution 2 - Using map
    // O(N)/O(N)
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            map.put(intervals[i][0], i);            // [k, i] i.e. interval which is STARTING at value k is at index i.
            max = Math.max(max, intervals[i][0]);
        }

        for(int i=0; i<n; i++){
            int endOfCurrInterval = intervals[i][1];
            // so we need some value which is greater than or equal to this value.

            while(endOfCurrInterval <= max){
                if(map.containsKey(endOfCurrInterval)){
                    result[i] = map.get(endOfCurrInterval);
                    break;
                }
                endOfCurrInterval++;
            }
        }
        return result;
    }
}
