package org.akhil;

public class Solution {
    // private final int MOD = 12345;
    // Algorithm is fine but will not work as range of num is till 10^9 so mult will go beyound long range.
    // Also will not satisfy Time limit condition
    // public int[][] constructProductMatrix(int[][] grid) {
    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     int[][] result = new int[rows][cols];

    //     long mult = 1;
    //     for(int i=0; i<rows; i++){
    //         for(int j=0; j<cols; j++){
    //             mult = mult*grid[i][j];
    //         }
    //     }

    //     for(int i=0; i<rows; i++){
    //         for(int j=0; j<cols; j++){
    //             result[i][j] = (int)((mult/grid[i][j]) % MOD);
    //         }
    //     }

    //     return result;
    // }

    // -------------------------
    // Solution 2 - Optimized
    // O(M*N)/O(M*N)
    // if we visualize the 2D matrix as a simple 1D array then we will be able to see something like below
    // for 2D array [[1,2],[3,4]] the 1D visualization will be [1,2,3,4]
    // Now we want to calculate multiplication of all values except the value of ith index then we simply need multiplication of all values
    // to the left of it and multiplication of all values to the right of it. We can calcuate it and store in two different arrays like below
    // leftProduct = [1, 1, 2, 6]  -> can use simple prefix sum SORT OF technique not exactly prefix sum. (0th index will always be 1)
    // rightProduct =[24, 12, 4, 1] -> same technique but from right to left (i.e. end to start) (last index will always be 1 as nothing is there to the right of it)
    // new required result will be just multiplication of these arrrays
    // result = [24, 12, 8, 6]
    // now just visualize this 1D array back to 2D matrix so it will be [[24, 12], [8, 6]]
    // private final int MOD = 12345;
    // public int[][] constructProductMatrix(int[][] grid) {
    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     int[][] result = new int[rows][cols];
    //     int[][] leftProduct = new int[rows][cols];
    //     int[][] rightProduct = new int[rows][cols];

    //     // fill leftProducts
    //     long product = 1;

    //     for(int row=0; row<rows; row++){
    //         for(int col=0; col<cols; col++){
    //             leftProduct[row][col] = (int)(product % MOD);
    //             product = ((product * grid[row][col]) % MOD);
    //         }
    //     }

    //     // fill rightProduct
    //     product = 1;
    //     for(int row=rows-1; row>=0; row--){
    //         for(int col=cols-1; col>=0; col--){
    //             rightProduct[row][col] = (int)(product % MOD);
    //             product = ((product * grid[row][col]) % MOD);
    //         }
    //     }

    //     // calculate result
    //     for(int row=0; row<rows; row++){
    //         for(int col=0; col<cols; col++){
    //             result[row][col] = ((leftProduct[row][col] * rightProduct[row][col]) % MOD);
    //         }
    //     }

    //     return result;
    // }


    // ---------------------------
    // Same logic but optimized to reduced space and a loop
    private final int MOD = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];

        // fill leftProducts
        long product = 1;

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){
                result[row][col] = (int)(product % MOD);
                product = ((product * grid[row][col]) % MOD);
            }
        }

        // fill rightProduct
        product = 1;
        for(int row=rows-1; row>=0; row--){
            for(int col=cols-1; col>=0; col--){
                result[row][col] =  (int)((result[row][col] * product) % MOD);
                product = ((product * grid[row][col]) % MOD);
            }
        }

        return result;
    }
}
