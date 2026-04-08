package org.akhil;

public class Solution {

    // O(N*M)/O(1) where N is length of nums and M is length of queries
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = (int)(7+1e9);

        for(int[] query:queries){       // total M queries
            int start = query[0];
            int end = query[1];
            int steps = query[2];
            int multiplier = query[3];

            for(int i=start; i<=end; i=i+steps){        // in case of step = 1, start = 0 and end = n-1 this will run O(N) times hence overall O(M*N)
                nums[i] = (int)(((long)nums[i] * multiplier)%MOD);
            }
        }

        int result = 0;
        for(int val:nums){
            result = result ^ val;
        }

        return result;
    }
}
