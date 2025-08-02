package org.akhil;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    // Solution 1
    // O(NlogN)/O(logN) logN space for sorting
//    public int findMinArrowShots(int[][] points) {
//        int n = points.length;
//        int arrowsNeeded = n;   // considering each balloon need 1 arrow
//
//        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
//        int[] previousBalloon = points[0];
//        for(int i=1; i<n; i++){
//            // check the overlap
//            if(points[i][0] <= previousBalloon[1]){     // = because even if start and end point of two balloons are same that can be burst by a single arrow
//                // consider only overlap
//                previousBalloon[0] = points[i][0];
//                previousBalloon[1] = Math.min(points[i][1], previousBalloon[1]);
//                arrowsNeeded = arrowsNeeded - 1;        // as 1 balloon can be busted using another balloons arrow
//            } else {
//                previousBalloon = points[i];
//            }
//        }
//        return arrowsNeeded;
//    }

    // Solution 2 - bit simpler code with same concept
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // here as we are comparing based on end point in loop hence we need to sort based on end points

        int arrows = 0;
        int lastBalloonsEnd = Integer.MIN_VALUE;

        for(int[] point : points) {
            if(arrows == 0 || point[0] > lastBalloonsEnd) {
                arrows++;
                lastBalloonsEnd = point[1];
            }
        }

        return arrows;
    }
}
