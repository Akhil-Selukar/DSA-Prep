package org.akhil;

import java.util.Arrays;

/*
* colors 00 -> no color(0), 01 -> Red(1), 10 -> Green(2), 11 -> Blue(3),
* Time complexity - O(N * 3^M)      n columns, 3^m possible states for each column (the for loop of color)
* Space complexity - O(N * 3^M)     memoization table stores states for each column
*/

public class Solution {
    private static final int MOD = (int)1e9 + 7;
    private int[][] stateMemoization = new int[1002][1024]; // 1000 rows + 2, 1024 for 10 bits(1024 = 4^M; M rows and each row can have 4 possibilities 00,01,10,11);
    public int colorTheGrid(int m, int n) {
        // filling initial value with -1.
        for (int i = 0; i < stateMemoization.length; i++) {
            Arrays.fill(stateMemoization[i], -1);
        }

        return countWays(m, n, 0, 0, 0, 0);
    }

    private int countWays(int totalRow, int totalCol, int currRow, int currCol, int currState, int prevState) {
        if(currCol == totalCol){    // means entire grid is filled.
            return 1;       // we found 1 way to fill the grid hence 1
        }

        if (currRow == totalRow){       // if we reach to the end of column (we are filling colors column wise i.e. top to bottom and we reach the bottom so need to shift to next column).
            return countWays(totalRow, totalCol, 0, currCol + 1, 0, currState);         // for next column row will start again from 0 (i.e. top) and current state will become previous state for new column.
        }

        // memoization
        if (currRow == 0 && stateMemoization[currCol][prevState] != -1){
            return stateMemoization[currCol][prevState];
        }

        int upColor = 0;        // i.e. no color as of now (if we are at 0th row and any column then there will not be any up color hence initialize it with 0.
        if(currRow > 0){
            upColor = currState & 3;    // each color is represented by 2 bits and hence from current state bit representation last 2 bits will be up color hence to get the last two bits we are unsetting the remaining bits hence & with 000011 so only last 2 bits will be extracted.
        }

        int leftColor = (prevState >> ((totalRow - currRow - 1)*2)) & 3;        // we need left color of that specific row hence we will have to skip all bits below curr row (i.e. totalRow - currRow)*2 multiplied by 2 because each cell color will be represented by 2 bits).

        int totalWays = 0;

        for(int color = 1; color<=3; color++){
            if(color != upColor && color != leftColor){
                // update currState with newly colored cell
                int newCurrState = (currState << 2) | color;
                totalWays = (totalWays + countWays(totalRow, totalCol, currRow+1, currCol, newCurrState, prevState)) % MOD;    // attempt for next cell in below row.
            }
        }

        // fill the DP i.e. stateMemoization
        if(currRow == 0){
            stateMemoization[currCol][prevState] = totalWays;
        }

        return totalWays;
    }
}
