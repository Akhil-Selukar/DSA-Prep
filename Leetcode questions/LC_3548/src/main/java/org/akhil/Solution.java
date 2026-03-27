package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// TC -> O(M*(M+(M*N)) + N*(M+(N*M))
// SC -> O(M*N)
public class Solution {
    int rows;
    int cols;
    long totalSum;
    HashMap<Long, List<int[]>> map;

    public boolean canPartitionGrid(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalSum += grid[i][j];
                long val = grid[i][j];
                if (!map.containsKey(val)) {
                    map.put(val, new ArrayList<>());
                }
                map.get(val).add(new int[]{i, j});
            }
        }

        // perform horizontal cut
        long currSum = 0;
        // m*(n+m*n) + n*(m+m*n)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                currSum += grid[i][j];
            }

            if (isValidPartition(currSum, totalSum - currSum, i, true)) {
                return true;
            }
        }

        // perform vertical cut
        currSum = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                currSum += grid[i][j];
            }
            if (isValidPartition(currSum, totalSum - currSum, j, false)) {
                return true;
            }
        }

        return false;
    }

    boolean isValidPartition(long firstPartSum, long secondPartSum, int cutIndex, boolean isHorizontalCut) {

        // if sum are equal then we are good
        if (firstPartSum == secondPartSum) {
            return true;
        }

        long diff = firstPartSum - secondPartSum;       // diff has to be removed from heavier section

        if (!map.containsKey(Math.abs(diff))) {         // diff can be removed only if it is present as a cell in grid (as only 1 cell can be removed)
            return false;
        }
        List<int[]> indices = map.get(Math.abs(diff));

        boolean canRemove = false;
        for (int[] index : indices) {
            int row = index[0]
            int col = index[1];

            boolean isInFirstSection = isHorizontalCut ? row <= cutIndex : col <= cutIndex;

            if (diff > 0 && !isInFirstSection) {         // not in heavier section
                continue;
            }
            if (diff < 0 && isInFirstSection) {      // not in heavier section
                continue;
            }

            // now we are in heavier section
            int minRow;
            int maxRow;
            int minCol;
            int maxCol;

            if (isInFirstSection) {
                minRow = 0;
                minCol = 0;
                maxRow = isHorizontalCut ? cutIndex : rows - 1;
                maxCol = isHorizontalCut ? cols - 1 : cutIndex;
            } else {
                maxRow = rows - 1;
                maxCol = cols - 1;
                minRow = isHorizontalCut ? cutIndex + 1 : 0;
                minCol = isHorizontalCut ? 0 : cutIndex + 1;
            }

            int rows = maxRow - minRow + 1;
            int cols = maxCol - minCol + 1;

            if (rows == 1) {
                canRemove = (col == minCol || col == maxCol);
            } else if (cols == 1) {
                canRemove = (row == minRow || row == maxRow);
            } else {
                canRemove = true;
            }

        }
        return canRemove;
    }
}
