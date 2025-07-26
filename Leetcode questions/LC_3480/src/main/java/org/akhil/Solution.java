package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Solution 1
    // TC -> O(N+P) where P is total number of conflicting pairs
    // SC -> O(N)
    public long maxSubarrays(int n, int[][] conflictingPairs) {

        long valid = 0;

        // conflictingPoints[i] = list of points which conflict with i
        List<List<Integer>> conflictingPoints = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            conflictingPoints.add(new ArrayList<>());
        }

        // Build the conflicting points list (ensure second value in pair is greater than first)
        for (int[] p : conflictingPairs) {
            int a = Math.min(p[0], p[1]);
            int b = Math.max(p[0], p[1]);
            conflictingPoints.get(b).add(a);
        }

        int maxConflict = 0;
        int secondMaxConflict = 0;
        // extra[i] = number of extra subarrays by removing the conflicting point i
        long[] extra = new long[n + 1];

        // Process each end point of subarrays
        for (int end = 1; end <= n; end++) {
            // Check all conflicting points of 'end' (i.e. for subarray ending at 'end' what all are the conflicting points to the left of it)
            for(int point:conflictingPoints.get(end)){
                if(point >= maxConflict){       // found new conflicting point which is closer to end
                    secondMaxConflict = maxConflict;
                    maxConflict = point;
                } else if (point > secondMaxConflict) {     // current point is at second position (points to the left of secondMaxConflict point are not useful)
                    secondMaxConflict = point;
                }
            }

            // Count of valid subarrays ending at 'end'
            valid = valid + (end - maxConflict);        // if we go to the left of maxConflictPoint, every subarray will have points conflicting each other)

            // Add extra subarrays count
            extra[maxConflict] = extra[maxConflict] + (maxConflict - secondMaxConflict);
        }


        // Find the maximum value in extra array
        long maxExtra = 0;
        for (long val : extra) {
            if (val > maxExtra) {
                maxExtra = val;
            }
        }

        return valid + maxExtra;

    }
}
