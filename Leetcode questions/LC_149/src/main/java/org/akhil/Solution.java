package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Solution 1 - Bruteforce
    // O(N^3)/O(1)
//    public int maxPoints(int[][] points) {
//        int result = 0;
//        int n = points.length;
//
//        if(n <= 2){
//            return n;
//        }
//
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                int count = 2;
//                int dy = points[j][1] - points[i][1];
//                int dx = points[j][0] - points[i][0];
//
//                double slope = (1.0*dy/dx);
//
//                // if any other point share same slope as that of above two point then that point lie on same line formed by i ad j point
//                for(int k=0; k<n; k++){
//                    if(k == i || k == j){
//                        continue;
//                    }
//                    int dy_ = points[k][1] - points[i][1];
//                    int dx_ = points[k][0] - points[i][0];
//
//                    double slope_ = (1.0*dy_/dx_);
//
//                    if(slope == slope_){
//                        count++;
//                    }
//                }
//
//                result = Math.max(result, count);
//            }
//        }
//        return result;
//    }

    // -------------------------------
    // Solution 2 - Optimized and more intuitive than solution 3
    // for two points to be on same line their slope must be equal. hence we will consider each point as first point and calculate slope of all
    // other points with that point and keep track of which slope has max point
    // O(N^2)/O(N)
    public int maxPoints(int[][] points) {
        int result = 0;
        int n = points.length;

        if(n <= 2){
            return n;
        }

        for(int i=0; i<n; i++){
            Map<Double, Integer> slopeCount = new HashMap<>();

            for(int j=0; j<n; j++){
                if(i == j) {
                    continue;
                }
                int dy = points[j][1] - points[i][1];
                int dx = points[j][0] - points[i][0];

                double slope = (1.0*dy/dx);

                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0)+1);
                // above map will store count of points having same slope with respect to chosen ith point
                // (keep in mind ith point is not considered in count hence we will add 1 below while finding max)
            }

            for(Map.Entry<Double, Integer> entry:slopeCount.entrySet()) {
                result = Math.max(result, entry.getValue() + 1);        // +1 because ith point was not added in count
            }

        }
        return result;
    }


    // ------------------------
    // Solution 2 - Optimized
    // O(N^2)/O(N)
//    public int maxPoints(int[][] points) {
//        int n = points.length;
//        if (n <= 2) {
//            return n;
//        }
//
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//            Map<Double, Integer> map = new HashMap<>();
//            int vertical = 0;
//            int same = 0;
//            int currentMax = 0;
//
//            for (int j = 0; j < n; j++) {
//                if (i == j) continue;
//
//                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
//                    same++;
//                } else if (points[j][0] == points[i][0]) {
//                    vertical++;
//                } else {
//                    double slope = (double)(points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
//                    map.put(slope, map.getOrDefault(slope, 0) + 1);
//                    currentMax = Math.max(currentMax, map.get(slope));
//                }
//            }
//
//            currentMax = Math.max(currentMax, vertical);
//            result = Math.max(result, currentMax + same + 1);
//        }
//        return result;
//    }
}
