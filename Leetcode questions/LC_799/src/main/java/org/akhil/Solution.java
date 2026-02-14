package org.akhil;

public class Solution {

    // O(N^2)/O(1) where N is the query_row
    public double champagneTower(int poured, int query_row, int query_glass) {
        // it is given in the question that we can have at max 100 rows. So that means the bottom row will have 100 glasses only.
        double[][] glasses = new double[101][101];

        // at start top glass will be poured with all the champagne
        glasses[0][0] = (double)poured;

        // now we just need to keep track of extra champagne at each glass and distribute it to right and left glass below it
        for(int i=0; i<=query_row; i++){
            for(int j=0; j<=i; j++){        // j<=i because at ith row exactly i glasses will be there.
                double extra = glasses[i][j] - 1;       // 1 cup of champagne is what the glass can hold

                // distribute the extra champagne equally to left and right glass
                // extra can be -ve because of -1 hence add a check.
                if(extra > 0) {
                    glasses[i + 1][j] = glasses[i + 1][j] + extra / 2;
                    glasses[i + 1][j + 1] = glasses[i + 1][j + 1] + extra / 2;
                }
            }
        }

        return glasses[query_row][query_glass] > 1 ? 1 : glasses[query_row][query_glass];
    }
}
