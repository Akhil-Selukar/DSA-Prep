package org.akhil;

import java.util.PriorityQueue;

// O(NlogK)/O(logK)
public class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for(int num:nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            } else {
                if(minHeap.peek() < num){
                    minHeap.offer(num);
                    while(minHeap.size() > k){
                        minHeap.poll();
                    }
                }
            }
        }
    }

    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.offer(val);
        } else {
            if(minHeap.peek() < val){
                minHeap.offer(val);
                while(minHeap.size() > k){
                    minHeap.poll();
                }
            }
        }
        return minHeap.peek();
    }
}
