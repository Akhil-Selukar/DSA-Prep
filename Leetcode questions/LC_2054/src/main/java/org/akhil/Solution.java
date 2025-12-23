package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Solution 1 - Without using memoization (TLE)
    // O(2^N)/O(2^N) recursive stack space
//    public int maxTwoEvents(int[][] events) {
//        Arrays.sort(events, (a, b)->{
//             if(a[0] == b[0]){
//             return a[1]-b[1];
//             }
//            return a[0]-b[0];
//        });
//
//        return helper(events, 0, 0, 0);
//    }
//
//    private int helper(int[][] events, int prevEnd, int index, int consideredEvents){
//        if(index >= events.length || consideredEvents == 2){
//            return 0;
//        }
//
//        int take = 0;
//        if(events[index][0] > prevEnd){
//            take = events[index][2] + helper(events, events[index][1], index+1, consideredEvents+1);
//        }
//        int notTake = helper(events, prevEnd, index+1, consideredEvents);
//
//        return Math.max(take, notTake);
//    }

    // --------------------------
    // Solution 2 - Memoization with binary search
    // O(NlogN)/O(N)
    public int maxTwoEvents(int[][] events) {
        // as we have sorted the events array here based on start time we can use binary search to find next event in case we took the ith event.
        // i.e. next event has to start from time >= i+1. So instead of iterating over all indices we can use binary search and directly jump to
        // the next possible index.
        Arrays.sort(events, (a, b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        int[][] dp = new int[events.length][3];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(events, 0, 0, dp);
    }

    private int helper(int[][] events, int index, int consideredEvents, int[][] dp){
        if(index >= events.length || consideredEvents == 2){
            return 0;
        }

        if(dp[index][consideredEvents] != -1){
            return dp[index][consideredEvents];
        }

        // in case of take find the next index i.e. >= prevEnd+1
        int nextIndex = binarySearch(events, events[index][1], index+1);
        int take = events[index][2] + helper(events, nextIndex, consideredEvents+1, dp);

        int notTake = helper(events, index+1, consideredEvents, dp);

        return dp[index][consideredEvents] = Math.max(take, notTake);
    }

    private int binarySearch(int[][] events, int prevEnd, int start){
        int end = events.length-1;
        int result = events.length;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(events[mid][0] > prevEnd){       // if start of mid is > prevEnd (i.e. its a valid event so this could be the possible next event)
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}
