package org.akhil;

public class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int n = startTime.length;
        int[] freeTime = new int[n+1];
        int lastEnd = 0;
        // calculate free time at every index
        for(int i=0; i<n; i++){
            freeTime[i] = startTime[i] - lastEnd;
            lastEnd = endTime[i];
        }

        // if after last event we have some hrs left
        freeTime[n] = eventTime - lastEnd;


        // Sliding window to find maximum sum of from freeTime with (k+1) size window
        int start = 0;
        int windowSum = 0;
        int maxFreeTime = 0;

        // get the window created
        for(int i=start; i<k+1; i++){
            windowSum += freeTime[i];
        }
        maxFreeTime = windowSum;

        // shift the window to find the max sum
        for(int end=k+1; end<freeTime.length; end++){
            windowSum = windowSum - freeTime[start] + freeTime[end];
            start++;

            maxFreeTime = Math.max(maxFreeTime, windowSum);
        }
        return maxFreeTime;
    }
}
