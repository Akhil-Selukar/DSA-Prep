package org.akhil;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] flattened = new int[m*n];
        int index = 0;

        for(int[] row:grid){
            for(int num:row){
                flattened[index++] = num;
            }
        }

        Arrays.sort(flattened);
        int midVal = flattened[(m+n)/2];
        int count = 0;

        for(int i=0; i<flattened.length; i++){
            if(flattened[i] == midVal){
                continue;
            }
            int val = Math.abs(flattened[i] - midVal);
            if(val%x != 0){
                return -1;
            }
            count = count + val/x;
        }
        return count;
    }
}
