package org.akhil;

public class Solution {
    // Solution 1
    // O(M*N)/O(1)
    public long maxMatrixSum(int[][] matrix) {
        int totalNegatives = 0;
        long minAbsValue = Integer.MAX_VALUE;
        long result = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int absVal = Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                    totalNegatives++;
                }
                minAbsValue = Math.min(minAbsValue, absVal);

                result = result + absVal;
            }
        }

        if(totalNegatives % 2 == 0){
            return result;
        }

        return result - 2 * minAbsValue;        // 2* because the value is already added in the total so we need to remove that first and then remove it to exclude that value
    }
}
