package org.akhil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // O(M*N)/O(M*N)
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[m*n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                List<Integer> temp = map.getOrDefault(i+j, new ArrayList<>());
                temp.add(mat[i][j]);
                map.put(i+j, temp);
            }
        }

        boolean downDirection = false;
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet()){

            List<Integer> temp = entry.getValue();
            if(downDirection){
                for(int val:temp){
                    result[index++] = val;
                }
                downDirection = false;
            } else {
                for(int i=temp.size()-1; i>=0; i--){
                    result[index++] = temp.get(i);
                }
                downDirection = true;
            }
        }

        return result;
    }
}
