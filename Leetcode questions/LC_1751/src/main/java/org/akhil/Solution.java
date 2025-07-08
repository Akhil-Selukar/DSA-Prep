package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Simple recursion without dp (TLE)
//    public int maxValue(int[][] events, int k) {
//        int index = 0;
//        Arrays.sort(events, (a, b) -> a[0]-b[0]);
//
//        return helper(events, index, k);
//    }
//
//    private int helper(int[][] events, int index, int k) {
//        if(index >= events.length || k == 0){
//            return 0;
//        }
//
//        // skip the event
//        int skip = helper(events, index+1, k);
//
//        int nextPossibleEventIndex = getNextEvent(events, index);
//        int attend = events[index][2] + helper(events, nextPossibleEventIndex, k-1);
//
//        return Math.max(skip, attend);
//    }
//
//    private int getNextEvent(int[][] events, int index) {
//        int currEventLastDay = events[index][1];
//
//        for(int i=index+1; i<events.length; i++){
//            if(currEventLastDay < events[i][0]){        // immediate next event which start after current event ends
//                return i;
//            }
//        }
//
//        return events.length;
//    }

    // Solution 2 - Using DP still TLE
    // O(NlogN + O(kN^2))/O(Nk)
//    public int maxValue(int[][] events, int k) {
//        int index = 0;
//        Arrays.sort(events, (a, b) -> a[0]-b[0]);       // O(NlogN)
//        int[][] dp = new int[events.length][k+1];
//        for(int[] row:dp){
//            Arrays.fill(row, -1);
//        }
//
//        return helper(events, index, k, dp);    //
//    }
//
//    //O(Nk)
//    private int helper(int[][] events, int index, int k, int[][] dp) {
//        if(index >= events.length || k == 0){
//            return 0;
//        }
//
//        if(dp[index][k] != -1){
//            return dp[index][k];
//        }
//
//        // skip the event
//        int skip = helper(events, index+1, k, dp);
//
//        int nextPossibleEventIndex = getNextEvent(events, index);   // O(N)
//        int attend = events[index][2] + helper(events, nextPossibleEventIndex, k-1, dp);
//
//        return dp[index][k] = Math.max(skip, attend);
//    }
//
//    private int getNextEvent(int[][] events, int index) {       // performing linear scan hence O(N)
//        int currEventLastDay = events[index][1];
//
//        for(int i=index+1; i<events.length; i++){
//            if(currEventLastDay < events[i][0]){        // immediate next event which start after current event ends
//                return i;
//            }
//        }
//
//        return events.length;
//    }


    // Solution 3 - DP with optimization of finding next events index
    // O(NlogN + NK) / O(NK)

    public int maxValue(int[][] events, int k) {
        int index = 0;
        Arrays.sort(events, (a, b) -> a[0]-b[0]);       // O(NlogN)
        int[][] dp = new int[events.length][k+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        // precompute immediate next event possible to attend
        int[] nextEvents = precomputeNextEvent(events);         // O(NlogN)



        return helper(events, index, k, dp, nextEvents);    //
    }

    //O(Nk)
    private int helper(int[][] events, int index, int k, int[][] dp, int[] nextEvents) {
        if(index >= events.length || k == 0){
            return 0;
        }

        if(dp[index][k] != -1){
            return dp[index][k];
        }

        // skip the event
        int skip = helper(events, index+1, k, dp, nextEvents);

//        int nextPossibleEventIndex = nextEvents[index];
//        int attend = events[index][2] + helper(events, nextPossibleEventIndex , k-1, dp, nextEvents);

        int attend = events[index][2] + helper(events, nextEvents[index], k-1, dp, nextEvents);

        return dp[index][k] = Math.max(skip, attend);
    }

    private int[] precomputeNextEvent(int[][] events) {
        int[] nextEvent = new int[events.length];

        for(int i=0; i < events.length; i++) {          // O(N)
            // use binary search                        // O(logN)
            int start = i+1;
            int end = events.length;

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (events[mid][0] > events[i][1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            nextEvent[i] = start;
        }
        return nextEvent;
    }
}
