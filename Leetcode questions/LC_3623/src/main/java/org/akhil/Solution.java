package org.akhil;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Here the important thing which we need to observe is we are asked to count horizontal trapezoids , i.e. the trapezoids which are formed by
    // combining any two parallel edges which are also parallel to x-axis.
    // So if we observe the given examples we can see that the if we have only 1 edge on lets say y coordinate 0 and another edge at y coordinate 2 then
    // we can simply combine those two edges to form a trapezoid. If we have 1 edge on y=0 and 2 different edges on y=2 then we can combine the edge at y=0
    // with both the edges at y=2 and form total of 2 trapezoids. So in general if we have m edges at one y coordinate and n edges at another y coordinate then
    // total trapezoids we can form using them are m*n.
    // So now the question becomes fond the edges parallel to x-axis at any y coordinate. Once we found that we can calculate the edges between any two
    // levels by multiplying the edges at those two levels. (if we have more than 3 levels then edges at 3rd level can form trapezoids with all the
    // edges below that level i.e. (p*(m+n)) where p is the no of edges at 3rd level)

    // O(N)/O(N)
    final static int MOD = (int)(7+1e9);
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> countPerLevel = new HashMap<>();

        for(int[] point:points){
            countPerLevel.put(point[1], countPerLevel.getOrDefault(point[1],0)+1);
        }

        long result = 0;
        long sumOfEdgesBelow = 0;

        for(Map.Entry<Integer, Integer> entry:countPerLevel.entrySet()){
            int n = entry.getValue();
            long edges = (long) n *(n-1)/2;

            result = (result + (edges * sumOfEdgesBelow)) % MOD;
            sumOfEdgesBelow = (sumOfEdgesBelow + edges) % MOD;
        }

        return (int)result;
    }
}
