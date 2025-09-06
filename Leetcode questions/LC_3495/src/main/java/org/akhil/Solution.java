package org.akhil;

public class Solution {

    // O(N*log(maxRightRangeFromAllQueries)) where N is total queries
    // O(1)
    public long minOperations(int[][] queries) {
        long result = 0;

        for(int[] query:queries){
            int queryLeft = query[0];
            int queryRight = query[1];

            long steps = helper(queryLeft, queryRight);
            result = result + (steps+1)/2;      // because at a time we can convert two values.
        }
        return result;
    }

    private long helper(int queryLeft, int queryRight) {
        long leftRange = 1;     // start of range
        long rightRange = 1;
        long steps = 1;
        long totalSteps = 0;

        while(leftRange <= queryRight){
            rightRange = (4 * leftRange) - 1;     // end of range

            long currRangeStart = Math.max(leftRange, queryLeft);
            long currRangeEnd = Math.min(rightRange, queryRight);

            if(currRangeStart <= currRangeEnd){
                totalSteps = totalSteps + (currRangeEnd-currRangeStart+1)*steps;
            }
            steps++;
            leftRange = leftRange*4;
        }
        return totalSteps;
    }
}
