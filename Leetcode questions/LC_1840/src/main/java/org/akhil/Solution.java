package org.akhil;

import java.util.Arrays;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b)->{
            return a[0]-b[0];
        });

        int length = restrictions.length;
        if(length == 0){    // no restriction so we can build the buildings in increasing step like structure and it will give the max height at last building
            return n-1;
        }

        // does last building has restrictions
        boolean lastRestricted = restrictions[length-1][0] == n;

        // compute total buildings with restrictions (because those are the ones which can break the structure)
        // 1 for 1st building and is last is restricted then already considered in length otherwise add 1 because last can not go beyond n-1 height (so restricted)
        int buildingsWithRestriction = length + 1 + (lastRestricted ? 0 : 1);

        int[][] heights = new int[buildingsWithRestriction][2];     // store building no and height possible

        // given that 1st building has height zero
        heights[0][0] = 1;
        heights[0][1] = 0;

        // traverse from left to right
        for(int i=0; i<length; i++){
            int diff = restrictions[i][0] - heights[i][0];
            int height = heights[i][1] + diff;

            heights[i+1][0] = restrictions[i][0];
            heights[i+1][1] = Math.min(height, restrictions[i][1]);
        }

        if(!lastRestricted){
            int diff = n - heights[length][0];
            int height = heights[length][1] + diff;
            heights[length+1][0] = n;
            heights[length+1][1] = Math.min(height, n-1);
        }

        // traverse from right to left
        for(int i=buildingsWithRestriction-2; i>=0; i--){
            int diff = heights[i+1][0] - heights[i][0];
            int height = heights[i+1][1] + diff;
            heights[i][1] = Math.min(heights[i][1], height);
        }

        int result = 0;
        for(int i=1; i<buildingsWithRestriction; i++){
            int left = heights[i-1][0];
            int right = heights[i][0];
            int h1 = heights[i-1][1];
            int h2 = heights[i][1];

            int max = (right - left - Math.abs(h1-h2))/2+Math.max(h1, h2);
            result = Math.max(result, max);
        }
        return result;
    }
}
