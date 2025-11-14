package org.akhil;

public class Solution {
    // Solution 1 - Bruteforce
    // O(Q*N^2)/O(N^2)    (Accepted even after N^2)
//    public int[][] rangeAddQueries(int n, int[][] queries) {
//        int[][] result = new int[n][n];
//
//        for(int[] query:queries){
//            int rowStart = query[0];
//            int colStart = query[1];
//            int rowEnd = query[2];
//            int colEnd = query[3];
//
//            for(int i=rowStart; i<=rowEnd; i++){
//                for(int j=colStart; j<=colEnd; j++){
//                    result[i][j] += 1;
//                }
//            }
//        }
//        return result;
//    }

    // -----------
    // Solution 2 - Using difference array technique in 2D-array
    // O(Q*N + N^2)/O(N^2)
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];

        for(int[] query:queries){
            int rowStart = query[0];
            int colStart = query[1];
            int rowEnd = query[2];
            int colEnd = query[3];

            for(int i=rowStart; i<=rowEnd; i++){
                result[i][colStart] = result[i][colStart] + 1;

                if(colEnd+1 < n){
                    result[i][colEnd+1] = result[i][colEnd] - 1;
                }
            }
        }

        // calculate cumulative sum row wise
        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                result[i][j] = result[i][j-1] + result[i][j];
            }
        }

        return result;
    }
}
