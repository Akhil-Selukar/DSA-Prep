package org.akhil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n=3;

        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int count=1;

        while(count<=(n*n)){
            for(int i=top; i<=right; i++){
                ans[top][i] = count++;
            }
            for(int i=top+1; i<=bottom; i++){
                ans[i][right] = count++;
            }
            for(int i=right-1; i>=left; i--){
                ans[bottom][i] = count++;
            }
            for(int i=bottom-1; i>top; i--){
                ans[i][left] = count++;
            }

            top++; bottom--; left++; right--;
        }
        return ans;
    }
}