package org.akhil;

public class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

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

        int[] maxFreeToRight = new int[n+1];
        int[] maxFreeToLeft = new int[n+1];
        int m = maxFreeToRight.length;

        for(int i=m-2; i>=0; i--){
            maxFreeToRight[i] = Math.max(maxFreeToRight[i + 1], freeTime[i + 1]);
        }

        // pre-computation of maxFreeToLeft
        for(int i=1; i<m; i++){
            maxFreeToLeft[i] = Math.max(maxFreeToLeft[i - 1], freeTime[i - 1]);
        }

        int result = 0;
        // Step 4: Iterate for each possible movement/shift
        for (int i = 1; i < m; i++) {
            int currEventTime = endTime[i - 1] - startTime[i - 1];

            // Case 1: Move completely out
            if (currEventTime <= Math.max(maxFreeToLeft[i - 1], maxFreeToRight[i])) {
                result = Math.max(result, freeTime[i - 1] + currEventTime + freeTime[i]);
            }

            // Case 2: Shift left or right
            result = Math.max(result, freeTime[i - 1] + freeTime[i]);
        }

        return result;
    }
}
