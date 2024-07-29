package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0;
        int bottom = row-1;
        int left = 0;
        int right = col-1;

        while((left <= right) && (top <= bottom)){
            for(int i=top; i<=right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}