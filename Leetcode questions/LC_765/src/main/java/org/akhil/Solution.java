package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int count = 0;
        Map<Integer, Integer> indices = new HashMap<>();

        // note down the indices of each person.
        for(int i=0; i<n; i++){
            indices.put(row[i], i);
        }

        for(int i=0; i<n; i+=2){        // every time we will check position and its partner (i.e. 2 indices) hence i+=2
            int p1 = row[i];
            int p2 = p1 + (p1%2 == 0? 1 : -1);      // here we can use bitwise XOR
//            int p2 = p1 ^ 1;

            if(p2 != row[i+1]){
                count++;
                swap(row, indices, i+1, indices.get(p2));
            }
        }
        return count;
    }

    private void swap(int[] row, Map<Integer, Integer> indices, int i, int j){
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;

        // correct indices in map as well. As in future iterations we might need them.
        indices.put(row[i], i);
        indices.put(row[j], j);
    }
}
