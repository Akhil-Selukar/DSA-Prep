package org.akhil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // Solution 1 - With sorting    (O(Nlog(N))/ (whatever space required for sorting)
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//
//        return nums[nums.length-k];
//    }

    // Solution 2 - Without sorting     (O(Nlog(k))/ O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();

        for(int num:nums){
            queue.offer(num);
//            System.out.println("Adding "+num);
            if(queue.size() > k){
                queue.poll();
//                System.out.println("pooled => "+queue.poll());
            }
        }
        return queue.poll();
    }
}
