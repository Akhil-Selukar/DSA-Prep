package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};

        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        List<Integer> rowMin = new ArrayList<>();
        List<Integer> colMax = new ArrayList<>();

        for(int row=0; row<matrix.length; row++){
            int minVal = Integer.MAX_VALUE;
            for(int col=0; col<matrix[row].length; col++){
                if(minVal>matrix[row][col]){
                    minVal = matrix[row][col];
                }
            }
            rowMin.add(row, minVal);
        }

        for(int col=0; col<matrix[0].length; col++){
            int maxVal = Integer.MIN_VALUE;
            for(int row=0; row<matrix.length; row++){
                if(maxVal<matrix[row][col]){
                    maxVal = matrix[row][col];
                }
            }
            colMax.add(col, maxVal);
        }

        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                if((matrix[row][col] == rowMin.get(row)) && (matrix[row][col] == colMax.get(col))){
                    ans.add(matrix[row][col]);
                }
            }
        }
        return ans;
    }
}