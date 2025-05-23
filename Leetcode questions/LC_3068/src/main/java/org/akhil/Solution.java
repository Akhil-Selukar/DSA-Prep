package org.akhil;

public class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        long count = 0;
        long discardedNode = Integer.MAX_VALUE; // Minimize the loss due to not finding XOR (Only applicable for ODD case)

        for (int num : nums) {
            ans += Math.max(num, num ^ k);      // take the max value of node either XOR'ed or without XOR'ed
            count += (num ^ k) > num ? 1 : 0;   // count of number of XOR operation taken (as 1 edge = 2 XOR operation)
            discardedNode = Math.min(discardedNode, Math.abs(num - (num ^ k)));         // if in case after XORing some node is getting less value but we have to take than node because at other end of that nodes edge we are getting maximum value. In this case we need to subtract this loss from final max (as we are just maximizing the ans without considering this case)
        }

        return count % 2 == 0 ? ans : (ans - discardedNode);       // if count is odd that means there is some edge which when XOR'ed gives less value at one of the two edges. Hence reduce that value.
    }
}
