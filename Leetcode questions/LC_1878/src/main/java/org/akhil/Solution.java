package org.akhil;

import java.util.Iterator;
import java.util.TreeSet;

// This solution can further be improved by using prefix sum, instead of every time calculating all sums. (i.e. innermost for loop)
public class Solution {

    // Solution 1 - bruteforce
    // O(R*C*Min(R*C)^2)
    // O(1)
    public int[] getBiggestThree(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();     // because we need only top 3 DISTINCT sum. So TreeSet is ordered and store unique, so we can just maintain top 3 in it.

        // we are not sure rhombus from which point and with what length will give us max sum so we need to create all possible rhombus
        // now to create rhombus we need to traverse diagonally from all points. Hence we need to know all points first.
        // If we consider current row and col as center of rhombus and side of it as x, then we can easily get the vertices.
        // top -> (row-x, col)
        // bottom -> (row+x, col)
        // left -> (row, col-x)
        // right -> (row, col+x)
        // once coordinates are fixed we can simply traverse through one point to another diagonally.
        // We need to do this for all points, i.e. considering all points as center

        for(int row=0; row<rows; row++){
            for(int col=0; col<cols; col++){

                set.add(grid[row][col]); // each individual set can be considered as a rhombus of side 0;
                // make sure set has only top 3 values
                if(set.size() > 3){
                    set.pollFirst();    // remove the first i.e. smallest
                }

                // make sure that any vertex is not going OOB so choose side according to this condition
                // if we consider side 0 in below loop then it will add same value 4 times hence considered it above.
                for(int side=1; row-side>=0 && row+side<rows && col-side>=0 && col+side<cols; side++){
                    int sum = 0;    // to store rhombus sum for each rhombus

                    // diagonal traversal of all 4 sides
                    for(int i=0; i<side; i++){
                        sum = sum + grid[row-side+i][col+i];    // starting from top to right (excluding right vertex)
                        sum = sum + grid[row+i][col+side-i];    // from right (included here) to bottom (excluding the bottom)
                        sum = sum + grid[row+side-i][col-i];    // bottom (included here) to left (excluding)
                        sum = sum + grid[row-i][col-side+i];    // left (included) to top (excluded here, already included in first operation)
                    }

                    set.add(sum);
                    // ensure set has only 3 values
                    if(set.size() > 3){
                        set.pollFirst();    // remove the first i.e. smallest
                    }
                }
            }
        }

        // after iterating over entire grid we will have top 3 sum in set
        int[] result = new int[set.size()];
        int i=0;

        Iterator<Integer> itr = set.descendingIterator();

        while(itr.hasNext()){
            result[i++] = itr.next();
        }

        return result;
    }
}
