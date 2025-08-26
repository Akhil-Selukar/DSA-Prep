package org.akhil;

public class Solution {
    // O(N)/O(1)
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;

        for(int[] val:dimensions){
            double currDiagonal = Math.sqrt((val[0]*val[0]) + (val[1]*val[1]));

            if(maxDiagonal == currDiagonal){
                maxArea = Math.max(maxArea, val[0]*val[1]);
            }
            if(currDiagonal > maxDiagonal){
                maxArea = val[0]*val[1];
                maxDiagonal = currDiagonal;
            }
        }

        return maxArea;
    }
}
