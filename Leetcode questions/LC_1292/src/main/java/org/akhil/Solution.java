package org.akhil;

public class Solution {
//    public int maxSideLength(int[][] grid, int threshold) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int prefixSum[][] = new int[m+1][n+1];
//
//        for (int i=1; i<=m; i++) {
//            for (int j=1; j<=n; j++) {
//                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] + grid[i-1][j-1] - prefixSum[i-1][j-1];
//            }
//        }
//
//        int max = 0;
//
//        for(int side=1; side<=Math.min(m,n); side++) {
//            for(int i=0; i<=m; i++) {
//                for(int j=0; j<=n; j++) {
//                    if(i+side>m || j+side>n) {
//                        break;
//                    }
//                    int sum = prefixSum[i+side][j+side] - prefixSum[i][j+side] - prefixSum[i+side][j] +
//                            prefixSum[i][j];
//                    if(sum <= threshold) {
//                        max = side;
//                        break;
//                    }
//                }
//            }
//        }
//
//        return max;
//    }

    // --------------------------------
    public int maxSideLength(int[][] grid, int threshold) {
        int m = grid.length;
        int n = grid[0].length;

        int prefixSum[][] = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] + grid[i-1][j-1] - prefixSum[i-1][j-1];
            }
        }

        int max = 0;

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=m; j++) {
                int side = max + 1;
                while(i+side<=m && j+side<=n) {
                    int sum = prefixSum[i+side][j+side] - prefixSum[i][j+side] - prefixSum[i+side][j]
                            + prefixSum[i][j];

                    if(sum <=threshold) {
                        max = side;
                        side++;
                    }
                    else break;
                }
            }
        }

        return max;
    }
}
