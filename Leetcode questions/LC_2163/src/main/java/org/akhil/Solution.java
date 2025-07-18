package org.akhil;

import java.util.PriorityQueue;

public class Solution {

    // Solution - using priority queue
    // O(Nlogn) / O(n+N) where N is length of nums and n is N/3 so effectively we can say that O(NlogN)/O(N)
    public long minimumDifference(int[] nums) {
        int length = nums.length;
        int n = length/3;
        long result = Long.MAX_VALUE;

        long[] leftMinSum = new long[length];
        long[] rightMaxSum = new long[length];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);

        // calculate leftMinSum for all indices (except last n, because second part must have n elements so no point in considering them in first part)
        long sum = 0;
        for(int i=0; i<length-n; i++){              // O(N)
            maxHeap.offer(nums[i]);
            sum = sum + nums[i];

            if(maxHeap.size() > n){
                sum = sum - maxHeap.poll();         // O(logN)
            }

            leftMinSum[i] = sum;
        }

        // calculate rightMaxSum for all indices (except first n)
        sum = 0;
        for(int i = length-1; i>=n; i--){           // O(N)
            minHeap.offer(nums[i]);
            sum = sum + nums[i];

            if(minHeap.size() > n){
                sum = sum - minHeap.poll();         // O(logN)
            }

            rightMaxSum[i] = sum;
        }

        // calculate the minimum difference
        for(int i=n-1; i<=2*n-1; i++){              // O(N)
            long firstPartSum = leftMinSum[i];
            long secondPartSum = rightMaxSum[i+1];

            result = Math.min(result, firstPartSum - secondPartSum);
        }

        return result;
    }
}
