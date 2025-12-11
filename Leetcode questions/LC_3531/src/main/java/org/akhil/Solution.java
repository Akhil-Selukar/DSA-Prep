package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // O(N)/O(N)
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, int[]> verticalBoundaries = new HashMap<>();
        Map<Integer, int[]> horizontalBoundaries = new HashMap<>();

        for(int[] building:buildings){
            int x = building[0];
            int y = building[1];

            if(!verticalBoundaries.containsKey(x)){
                verticalBoundaries.put(x, new int[]{y, y});
            } else {
                int newUpperBoundary = Math.max(verticalBoundaries.get(x)[1], y);
                int newLowerBoundary = Math.min(verticalBoundaries.get(x)[0], y);
                verticalBoundaries.get(x)[0] = newLowerBoundary;
                verticalBoundaries.get(x)[1] = newUpperBoundary;
            }
            if(!horizontalBoundaries.containsKey(y)){
                horizontalBoundaries.put(y, new int[]{x, x});
            } else {
                int newRightBoundary = Math.max(horizontalBoundaries.get(y)[1], x);
                int newLeftBoundary = Math.min(horizontalBoundaries.get(y)[0], x);
                horizontalBoundaries.get(y)[0] = newLeftBoundary;
                horizontalBoundaries.get(y)[1] = newRightBoundary;
            }
        }

        int result = 0;
        for(int[] building:buildings){
            int x = building[0];
            int y = building[1];

            if(y > verticalBoundaries.get(x)[0] && y < verticalBoundaries.get(x)[1]
                    && x > horizontalBoundaries.get(y)[0] && x < horizontalBoundaries.get(y)[1]){
                result++;
            }
        }

        return result;
    }
}
