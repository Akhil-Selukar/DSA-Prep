package org.akhil;

public class Solution {

    // O(N^2)/O(N)
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        // find number of zeros present at end for each row
        int[] zeroCount = new int[n];

        // O(N^2)
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=n-1; j>=0; j--){
                if(grid[i][j] == 0){
                    count++;
                } else {
                    break;
                }
            }
            zeroCount[i] = count;
        }

        // now at ith row we need at lease (n-1-i) zeros.
        // if we have that many zeros then no need to swap but if we dont have it then we can check for those many zeros in below
        // rows and swap current row till we get the required number of zeros. (Pay attention while swapping, we can't directly swap the rows,
        // we need to swap step by step)

        int swapCount = 0;

        // O(N^2)
        for(int i=0; i<n; i++){
            int requiredZeros = n-1-i;

            int j=i;
            while(j<n && zeroCount[j] < requiredZeros){
                j++;
            }

            if(j == n){  // we reach till the end of rows and still not able to find the required number of zeros
                return -1;
            }

            while(j>i){
                // This is important, we are not swapping j i.e. index where we got required zeros with i (i.e. correct position of that row)
                // we are shifting the jth row one by one hence swapping with j-1 till we reach i.
                int temp = zeroCount[j];
                zeroCount[j] = zeroCount[j-1];
                zeroCount[j-1] = temp;
                swapCount++;
                j--;
            }
        }

        return swapCount;
    }
}
