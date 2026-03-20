package org.akhil;

import java.util.TreeSet;

public class Solution {

    // Complexity analysis
    // Here outer two for loops (for row and col) will run for 'rows-k' and 'cols-k' times, Consider rows = M and cols = N. So it will haave
    // TC -> O(M-k)*O(N-K) -> O((M-k)*(N-k))
    // Now inner two for loops are to add each value in submatrix of size K*K into tree-set so here there are two operations being performed
    // traversal over submatrix -> O(K^2)
    // adding values in TreeSet -> O(log(K^2))      (TreeSet operation takes O(log(maxValues)) TC)
    // hence overall complexity for inner part is
    // O(K^2 * log(K^2))
    // Also for finding currMin we are iterating over all values of treeset which is (at max K^2 values can be there)
    // Hence O(K^2)
    // Hence overall time complexity will be
    // TC -> O((M-K)*(N-K)*(K^2 + (K^2 * log(K^2)))
    // which can be simplified as O((M-K)*(N-K)*(K^2*(1 + log(K^2)))
    // i.e. O((M-K)*(N-K)*(K^2 * log(K^2)))

    // Space complexity is O(K^2 + ((M-k)*(N-K)))       -> K^2 for set and (M-k)*(n-k) is for result matrix
    public int[][] minAbsDiff(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows-k+1][cols-k+1];

        for(int row=0; row<=rows-k; row++){
            for(int col=0; col<=cols-k; col++){
                // We need to find SMALLEST diff between unique values in sub-matrix, in sorted values diff between adjacent elements is smallest.
                // (So we need unique and sorted hence TreeSet
                TreeSet<Integer> set = new TreeSet<>();

                // add all elements in submatrix in TreeSet
                for(int r=row; r<row+k; r++){
                    for(int c=col; c<col+k; c++){
                        set.add(grid[r][c]);
                    }
                }

                // find min diff of the all unique values
                int currMin = Integer.MAX_VALUE;
                int prevVal = set.first();
                for(int val:set){
                    if(prevVal != val){
                        currMin = Math.min(currMin, val-prevVal);
                        prevVal = val;
                    }
                }

                // set the currMin in result matrix
                result[row][col] = currMin == Integer.MAX_VALUE ? 0 : currMin;
            }
        }
        return result;
    }
}
