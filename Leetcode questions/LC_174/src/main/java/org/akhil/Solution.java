package org.akhil;

import java.util.Arrays;

public class Solution {

    // O(M*N)/O(M*N)
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(0, 0, dungeon, dp);
    }

    private int helper(int row, int col, int[][] dungeon, int[][] dp) {
        // if we are out of bounds
        if(row >= dungeon.length || col >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }

        // if we found the princes
        if(row == dungeon.length-1 && col == dungeon[0].length-1){
            if(dungeon[row][col] < 0){
                return Math.abs(dungeon[row][col]) + 1;     // this will be minimum health which knight has to carry if princes is guarded by demon
            }
            return 1;   // if princes is not guarded by any demon then minimum health which knight can carry will be 1 because he just has to survive.
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        // down path
        int down = helper(row+1, col, dungeon, dp);

        // right path
        int right = helper(row, col+1, dungeon, dp);

        int minHealthNeeded = Math.min(right, down) - dungeon[row][col];       // at least this much health knight has to bring to survive at dungeon[row][col]

        // this value will be +ve only when dungeon[row][col] has -ve value so there is a demon at [row][col] so knight has to carry minHealthNeeded to [row][col]
        if(minHealthNeeded > 0){
            return dp[row][col] = minHealthNeeded;
        } else {
            return dp[row][col] = 1;
        }
    }
}
