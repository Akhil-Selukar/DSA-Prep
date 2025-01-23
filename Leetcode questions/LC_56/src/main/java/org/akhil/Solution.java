package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals, (a, b)->{return a[0]-b[0];});

        List<int[]> ans = new ArrayList<>();
        int[] previous = intervals[0];

        for(int i=1; i<intervals.length; i++){
            boolean pairFound = false;
            int[] current = intervals[i];
            if(previous[1] >= current[0]){
                previous[1] = Math.max(previous[1], current[1]);
                pairFound = true;
            }

            if(previous[0] >= current[0]){
                previous[0] = Math.min(previous[0], current[0]);
                pairFound = true;
            }

            if(!pairFound){
                ans.add(previous);
                previous = current;
            }
        }

        ans.add(previous);

        return ans.toArray(new int[ans.size()][]);
    }
}
