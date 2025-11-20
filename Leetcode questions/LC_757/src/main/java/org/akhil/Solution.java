package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution using sorting and greedy
    // O(NlogN)/O(1)
    public int intersectionSizeTwo(int[][] intervals) {
        // Pay attention to the order of sorting and try some examples on pen and paper (edge cases like one interval in completely inside other, two interval ending at same point, etc)
        Arrays.sort(intervals, (a, b)->{
           if(a[1] == b[1]){
               return b[0] - a[0];
           } else {
               return a[1] - b[1];
           }
        });

        int result = 0;
        // starting from OOB (i.e. initially previous left and right will be invalid
        int prevLeft = -1;
        int prevRight = -1;

        for(int i=0; i<intervals.length; i++){
            int currentLeft = intervals[i][0];
            int currentRight = intervals[i][1];

            if(currentLeft > prevRight){
                prevLeft = currentRight - 1;
                prevRight = currentRight;
                result = result + 2;
            } else if(currentLeft > prevLeft) {
                prevLeft = prevRight;
                prevRight = currentRight;
                result = result + 1;
            }
        }
        return result;
    }
}
