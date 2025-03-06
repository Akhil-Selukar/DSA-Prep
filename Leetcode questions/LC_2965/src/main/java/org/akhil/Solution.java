package org.akhil;

public class Solution {
    // O(N^2)/O(N^2)
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n*n];

        for(int[] arr:grid){
            for(int num:arr){
                count[num-1]++;
            }
        }
        int a = 0;
        int b = 0;

        for(int i=0; i<n*n; i++){
            if(count[i] == 0){
                b = i+1;
            }
            if(count[i] == 2){
                a = i+1;
            }
        }

        return new int[]{a, b};
    }
}
