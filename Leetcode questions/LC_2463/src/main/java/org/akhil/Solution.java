package org.akhil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        // as we need to find minimum distance of robots and factories (with valid capacity) we need robots and factories in sorted order
        Arrays.sort(factory, (a, b)->{
            return a[0]-b[0];
        });
        Collections.sort(robot);

        long[][] dp = new long[robot.size()][factory.length];
        for(long[] row:dp){
            Arrays.fill(row, -1);
        }

        return helper(robot, factory, 0, 0,  dp);
    }

    private long helper(List<Integer> robot, int[][] factory, int roboIndex, int factIndex, long[][] dp){
        if(roboIndex >= robot.size()){      // no more robots left to reach to any factory
            return 0;
        }

        if(factIndex >= factory.length){
            return Long.MAX_VALUE;       // no more factory left hence all robots can not be accommodated
        }

        if(dp[roboIndex][factIndex] != -1){
            return dp[roboIndex][factIndex];
        }

        // skip current factory
        long skip = helper(robot, factory, roboIndex, factIndex + 1, dp);

        // fill current factory with the robots
        long currDist = 0;
        long result = Long.MAX_VALUE;

        // for ith robot if we have capacity at current factory i.e. i<factory[factIndex][1]
        // and actually ith robot exist i.e. roboIndex+i < robot.size()
        // as we keep on filling the robots either all robots will be filled in a factory or capacity of factory will be exhausted
        for(int i=0; i<factory[factIndex][1] && roboIndex+i < robot.size(); i++){
            currDist = currDist + Math.abs(factory[factIndex][0] - robot.get(roboIndex + i));   // distance between robot and factory i.e. the distance robots need to travel

            long remaining = helper(robot, factory, roboIndex + i + 1, factIndex+1, dp); // check for remaining robots

            if(remaining < Long.MAX_VALUE){  // if all robots are filled then only this will be < MAX_VALUE
                result = Math.min(result, currDist + remaining);
            }
        }

        return dp[roboIndex][factIndex] = Math.min(result, skip);
    }
}
