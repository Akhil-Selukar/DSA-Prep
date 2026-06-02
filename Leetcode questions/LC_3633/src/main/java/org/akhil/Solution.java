package org.akhil;

public class Solution {
    public int earliestFinishTime(int[] landStart, int[] landDuration, int[] waterStart, int[] waterDuration) {
        int minLand = Integer.MAX_VALUE;
        int minWater = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        int n = landStart.length;
        int m = waterStart.length;

        for (int i = 0; i < n; i++)
            minLand = Math.min(minLand, landStart[i] + landDuration[i]);

        for (int i = 0; i < m; i++) {
            minWater = Math.min(minWater, waterStart[i] + waterDuration[i]);
            result = Math.min(result, Math.max(minLand, waterStart[i]) + waterDuration[i]);
        }

        for (int i = 0; i < n; i++)
            result = Math.min(result, Math.max(minWater, landStart[i]) + landDuration[i]);

        return result;
    }
}
