package org.akhil;

import java.util.Arrays;

public class Solution {

    // Solution 1 - bruteforce
    // O(N^3)/O(N)  (WORST solution will give TLE, Not even good for starting point in an interview)
//    public long maxSubarraySum(int[] nums, int k) {
//        long maxSum = Integer.MIN_VALUE;
//
//        for(int i=0; i<nums.length; i++){
//            for(int j=i+k; j<=nums.length; j=j+k){
//                long sum = getSum(nums, i, j);
//                maxSum = Math.max(maxSum, sum);
//            }
//        }
//        return maxSum;
//    }
//
//    private long getSum(int[] nums, int i, int j){
//        long sum = 0;
//        for(int start = i; start<j; start++){
//            sum = sum + nums[start];
//        }
//        return sum;
//    }

    // --------------------------------------
    // Solution 2 - Optimized
    // O(N)/OO(N)
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long prefix[] = new long[n+1];
        for(int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];        // one extra index 0 with prefixSum[0] = 0;
        }

        long ans = Long.MIN_VALUE;
        // O(k)
        for(int i=0; i<k; i++) {        // at max each segment can be of k-1 length because if we have k = 0 and take one subarray as 0-1 then second will be 2-3 and if we start from 1 then first will be 1-2 and then 3-4 now if we try to start from 2 then 2-3 is already considered.

            long sum = 0;
            // O(n/k)
            for(int j=i; j+k<=n; j+=k) {
                long currsum = prefix[j+k] - prefix[j];
                sum += currsum;
                if(sum < currsum) {         // this if statement ensure to check sum of current segment as well as entire subarray and take the max one
                    sum = currsum;
                }
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}