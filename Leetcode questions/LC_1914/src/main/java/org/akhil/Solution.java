package org.akhil;

public class Solution {

    // Here the first thing is want to rotate an array by k times and K can be huge, but after some rotations the structure will repeat itself
    // So first clue for us is find effective rotations and rotate only that many times.
    // Next is we want to rotate each layer. If we try to rotate layer and shift rows and columns (bruteforce that will be a very complex code with
    // deep nesting of loops (first to check valid rind left<right and top<bottom, then another loop for k rotations, then conditions if the rotated
    // row/column is going out of range, then change the direction and all. Which is complex.
    // Instead, we can simply traverse the level(ring) store all the values as 1D array and rotate it, then we can simply put back the values in layer/ring
    // rotation of 1D array is much more simple than 2D array.

    //O(M*N)/O(M*N)
    public int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        int leftBoundary = 0;
        int rightBoundary = cols-1;
        int topBoundary = 0;
        int bottomBoundary = rows-1;

        while(leftBoundary<rightBoundary && topBoundary<bottomBoundary){
            int totalElements = 2*(rightBoundary - leftBoundary) + (2*(bottomBoundary - topBoundary));

            int[] tempArr = new int[totalElements];     // 1D array representation of layer
            int index = 0;

            // top row of ring
            for(int i=leftBoundary; i<rightBoundary; i++) {
                tempArr[index++] = grid[topBoundary][i];
            }
            // right column of ring
            for(int i=topBoundary; i<bottomBoundary; i++){
                tempArr[index++] = grid[i][rightBoundary];
            }
            // bottom row of ring
            for(int i=rightBoundary; i>leftBoundary; i--){
                tempArr[index++] = grid[bottomBoundary][i];
            }
            // left column of the ring
            for(int i=bottomBoundary; i>topBoundary; i--){
                tempArr[index++] = grid[i][leftBoundary];
            }

            // rotate the 1D array k times
            // inplace rotation logic (reversing the two parts and then reversing entire array)
            int effectiveRotations = k%totalElements;
            reverse(tempArr, 0, effectiveRotations - 1);
            reverse(tempArr, effectiveRotations, totalElements-1);
            reverse(tempArr, 0, totalElements-1);

            // place the elements from 1D array (after rotation) back to the ring
            index = 0;
            // top row of ring
            for(int i=leftBoundary; i<rightBoundary; i++) {
                grid[topBoundary][i] = tempArr[index++];
            }
            // right column of ring
            for(int i=topBoundary; i<bottomBoundary; i++){
                grid[i][rightBoundary] = tempArr[index++];
            }
            // bottom row of ring
            for(int i=rightBoundary; i>leftBoundary; i--){
                grid[bottomBoundary][i] = tempArr[index++];
            }
            // left column of the ring
            for(int i=bottomBoundary; i>topBoundary; i--){
                grid[i][leftBoundary] = tempArr[index++];
            }

            // shrink the ring
            leftBoundary++;
            rightBoundary--;
            topBoundary++;
            bottomBoundary--;
        }
        return grid;
    }

    private void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
