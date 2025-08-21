package org.akhil;

public class Solution {

    // Solution 1 - using flattening matrix technique (area of histogram)
    // TC -> O(M(N+MN)) = O(MN + M^2N) ~ O(M^2N) after dropping non-dominant term
    // SC -> O(N)
    // where M is number of rows and N is number of columns
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int result = 0;

        // flatten 2D-matrix into 1D array row by row
        // O(M(N+MN)) = O(MN + M^2N) ~ O(M^2N) after dropping non-dominant term
        for(int startRow=0;startRow<rows; startRow++){      // O(M)

            int[] flattened = new int[cols];
            // fill values in start row
            for(int col=0; col<cols; col++){                // O(N)
                flattened[col] = mat[startRow][col];
            }

            // expand the matrix row by row
            // O(M(N+N)) = O(MN)
            for(int endRow = startRow; endRow<rows; endRow++){      // O(M)
                for(int col=0; col<cols; col++){                    // O(N)
                    flattened[col] = flattened[col] & mat[endRow][col];
                }

                // count submatrix with all 1's
                result = result + countAllOneSubMatInOneDArray(flattened);          // O(N)
            }
        }
        return result;
    }

    private int countAllOneSubMatInOneDArray(int[] flattened) {
        int continuousOnes = 0;
        int count = 0;

        for(int num:flattened){
            if(num == 1){
                continuousOnes++;
                count = count + continuousOnes;
            } else {
                continuousOnes = 0;
            }
        }
        return count;
    }
}
