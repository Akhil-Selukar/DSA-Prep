package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // Solution 1 - bruteforce and not optimized
    // O(M*N)/O(M*N)
//    public int[] findDiagonalOrder(int[][] mat) {
//        int m = mat.length;
//        int n = mat[0].length;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        int[] result = new int[m*n];
//
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                List<Integer> temp = map.getOrDefault(i+j, new ArrayList<>());
//                temp.add(mat[i][j]);
//                map.put(i+j, temp);
//            }
//        }
//
//        boolean downDirection = false;
//        int index = 0;
//        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){
//
//            List<Integer> temp = entry.getValue();
//            if(downDirection){
//                for(int val:temp){
//                    result[index++] = val;
//                }
//                downDirection = false;
//            } else {
//                for(int i=temp.size()-1; i>=0; i--){
//                    result[index++] = temp.get(i);
//                }
//                downDirection = true;
//            }
//        }
//
//        return result;
//    }

    //-----------------------

    // Solution 2 - More intuitive and simple (Optimized as well)
    // O(M*N)/O(M*N)
    // Here we are using the observation that in each diagonal the addition of rowIndex and columnIndex will always be constant
    // if it is a odd diagonal we are going downward and if it is a even diagonal we need to go upward. (there are some
    // edge cases for turning the direction, that we need to handle in both direction)
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] result = new int[m*n];
        int row = 0;
        int col = 0;

        // fill the result array (diagonally)
        for(int i=0; i<m*n; i++){

            result[i] = mat[row][col];

            int diagonalNo = row + col;
            // if even diagonal then travel up-right (handle edge cases)
            if(diagonalNo % 2 == 0){
                if(col == n-1){
                    row++;
                } else if(row == 0){
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {        // if odd diagonal then travel down-left (handle edge cases)
                if(row == m-1){
                    col++;
                } else if(col == 0){
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
