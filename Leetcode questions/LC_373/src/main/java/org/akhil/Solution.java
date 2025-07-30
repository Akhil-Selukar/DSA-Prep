package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // Solution 1 - Using priorityQueue
    // TC -> O(N1*logN1 + K*logN1) where N1 is length of nums1 (log component because of priorityQueue, in PQ at max N1 elements will be there at any point)
    // SC -> O(N1+K)
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        // add combinations of sum(nums1[i]+nums2[0]) and 0th index (i.e. considered index of nums2)
        for(int num:nums1){
            queue.offer(new int[]{num + nums2[0], 0});          // sum at 0th index as we are sorting based on 0th index in priority queue
        }

        // as we need top k elements
        while(k > 0 && !queue.isEmpty()){
            int[] polled = queue.poll();
            int sum = polled[0];
            int index = polled[1];

            List<Integer> pair = new ArrayList<>();
            pair.add(sum - nums2[index]);       // sum contains nums1[i] and nums2[index] and we only want nums1[index] first
            pair.add(nums2[index]);

            result.add(pair);
            k--;

            // add next indexed element in nums2
            if(index+1 < nums2.length){
                int newSum = sum - nums2[index] + nums2[index+1];
                queue.offer(new int[]{newSum, index+1});
            }
        }

        return result;
    }
}
