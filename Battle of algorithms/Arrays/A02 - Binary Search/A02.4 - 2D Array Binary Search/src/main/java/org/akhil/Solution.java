package org.akhil;

public class Solution {
    /**
     * Searches for a target value in an M x N matrix where:
     * 1. Each row is sorted in ascending order.
     * 2. The first integer of each row is greater than the last integer of the previous row.
     *
     * This structure allows treating the matrix as a single sorted 1D array for binary search.
     *
     * @param matrix The 2D array to search in.
     * @param target The value to search for.
     * @return An int array [row, col] if the target is found, or [-1, -1] otherwise.
     *
     * @author Akhil Selukar
     */

    public int[] binarySearch(int[][] arr, int target){
        // Write your code here
        if(arr == null || arr.length == 0){
            return new int[]{-1, -1};
        }

        int row = 0;
        int col = arr[0].length-1;

        while(row < arr.length && col >=0){
            if(arr[row][col] == target){
                return new int[]{row, col};
            }

            if(arr[row][col] < target){
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
