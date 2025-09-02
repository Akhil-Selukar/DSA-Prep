package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // O(N^3)/O(1)
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            // upper left point (A)
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // lower right point (B)
                int x2 = points[j][0];
                int y2 = points[j][1];

                // (x1, y1) must be upper-left of (x2, y2)
                if (x1 <= x2 && y1 >= y2) {
                    boolean hasPointInside = false;

                    // Check if some other point lies inside or on the rectangle
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j){
                            continue;
                        }

                        int x3 = points[k][0];
                        int y3 = points[k][1];

                        // (x3, y3) inside or on rectangle formed by (x1, y1) and (x2, y2)
                        if (x3 >= x1 && x3 <= x2 && y3 <= y1 && y3 >= y2) {
                            hasPointInside = true;
                            break;
                        }
                    }

                    if (!hasPointInside) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
