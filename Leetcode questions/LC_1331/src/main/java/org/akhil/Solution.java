package org.akhil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // O(NLogN)/O(N)
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> rankMap = new HashMap<>();

        int rank = 1;
        for(int val:copy){
            if(!rankMap.containsKey(val)){
                rankMap.put(val, rank++);
            }
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}
