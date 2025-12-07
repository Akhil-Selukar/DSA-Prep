package org.akhil;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    final int MOD = (int)(7+1e9);
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();

        int p1 = 0;
        for(int p2=0; p2<n; p2++){
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[p2]) {
                maxQ.pollLast();
            }
            maxQ.addLast(p2);

            while(!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[p2]) {
                minQ.pollLast();
            }
            minQ.addLast(p2);

            while(nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if(maxQ.peekFirst() == p1){
                    maxQ.pollFirst();
                }
                if(minQ.peekFirst() == p1) {
                    minQ.pollFirst();
                }
                p1++;
            }

            long ways = prefix[p2];
            if(p1 > 0){
                ways = (ways - prefix[p1 - 1] + MOD) % MOD;
            }
            dp[p2 + 1] = ways;
            prefix[p2 + 1] = (prefix[p2] + dp[p2 + 1]) % MOD;
        }

        return (int)dp[n];
    }
}
