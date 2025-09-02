package org.akhil;

import java.util.Arrays;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^3)/O(1)
//    public int numberOfPairs(int[][] points) {
//        int n = points.length;
//        int result = 0;
//
//        for (int i = 0; i < n; i++) {
//            // upper left point (A)
//            int x1 = points[i][0];
//            int y1 = points[i][1];
//
//            for (int j = 0; j < n; j++) {
//                if (i == j) continue;
//
//                // lower right point (B)
//                int x2 = points[j][0];
//                int y2 = points[j][1];
//
//                // (x1, y1) must be upper-left of (x2, y2)
//                if (x1 <= x2 && y1 >= y2) {
//                    boolean hasPointInside = false;
//
//                    // Check if some other point lies inside or on the rectangle
//                    for (int k = 0; k < n; k++) {
//                        if (k == i || k == j){
//                            continue;
//                        }
//
//                        int x3 = points[k][0];
//                        int y3 = points[k][1];
//
//                        // (x3, y3) inside or on rectangle formed by (x1, y1) and (x2, y2)
//                        if (x3 >= x1 && x3 <= x2 && y3 <= y1 && y3 >= y2) {
//                            hasPointInside = true;
//                            break;
//                        }
//                    }
//
//                    if (!hasPointInside) {
//                        result++;
//                    }
//                }
//            }
//        }
//        return result;
//    }


    // Solution 2 - Optimized
    // We know that we want x2 to be greater than or equal to x1, so rather than iterating through all points for and checking them for B
    // we can sort the points based on x and only check for B in all points ahead of A. Now x is sorted and we know that every time we will get
    // valid x. Second thing is we know that if any y is greater than or equal to y2 then that point with coordinate (x, y) will lie in the rectangle
    // so we need to ensure than no point till now is greater than y2, this can be achieved by keeping track of maximum value of y till we go beyond limit.
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int result = 0;

        // Sort based on x first and if x is equal then sort by y
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] == point2[0]) {
                return point2[1] - point1[1];
            }
            return point1[0] - point2[0];
        });

        for (int i = 0; i < n; i++) {
            // upper left point (A)
//            int x1 = points[i][0];    // not required as taken care by sorting
            int y1 = points[i][1];

            int maxY = Integer.MIN_VALUE;

            // only check for points ahead of A (i.e ith point)
            for (int j = i+1; j < n; j++) {

                // lower right point (B)
//                int x2 = points[j][0];    // not required as taken care by sorting
                int y2 = points[j][1];

                if(y2 > y1){  // not lower right point
                    continue;
                }

                if(y2 > maxY){
                    result++;
                    maxY = y2;
                }
            }
        }
        return result;
    }
}
