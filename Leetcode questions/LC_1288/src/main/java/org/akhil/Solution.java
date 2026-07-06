package org.akhil;

import java.util.Arrays;

public class Solution {
    // O(NlogN)/O(1)
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });

        int[] prev = intervals[0];
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] <= prev[1] && curr[1] <= prev[1]){
                count++;
            } else {
                prev = curr;
            }
        }

        return intervals.length - count;
    }
}
