package org.akhil;

import java.util.Arrays;
import java.util.List;

public class Solution {

    // O(NLog(N))/O(N)
    public int findMinDifference(List<String> timePoints) {

        int minDiff = Integer.MAX_VALUE;

        // convert time stamp into minutes
        int[] minutes = new int[timePoints.size()];
        for(int i=0; i< timePoints.size(); i++){
            int hr = Integer.parseInt(timePoints.get(i).substring(0,2));
            int min = Integer.parseInt(timePoints.get(i).substring(3));

            minutes[i] = (hr*60)+min;
        }

        // sort minutes
        Arrays.sort(minutes);

        // find minimum difference.
        for(int i=0; i<minutes.length-1; i++){
            minDiff = Math.min(minDiff, minutes[i+1]-minutes[i]);
        }

        // handle edge case of cyclic difference (i.e. 23:59, 00:00 in this case difference should be 1)
        minDiff = Math.min(minDiff, (24*60)-(minutes[minutes.length-1] - minutes[0]));

        return minDiff;
    }
}
