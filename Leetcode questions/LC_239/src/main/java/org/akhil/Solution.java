package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - bruteforce (TLE)
    // O(NK)/O(W) where W is number of windows
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        // assume nums is not null
//        int n = nums.length;
//        if (n == 0 || k == 0) {
//            return new int[0];
//        }
//
//        int numOfWindow = n - k + 1;
//        int[] result = new int[numOfWindow]; // number of windows
//
//        for (int start = 0; start < numOfWindow; ++start) {
//            int end = start + k - 1;
//            int maxVal = nums[start];
//            for (int i = start + 1; i <= end; ++i) {
//                if (nums[i] > maxVal) { // update
//                    maxVal = nums[i];
//                }
//            }
//            result[start] = maxVal;
//        }
//
//        return result;
//    }


    // Solution 2 - using priority queue (TLE)
    // O(N^2)/O(N)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        List<Integer> list = new ArrayList<>();
//
//        int start = 0;
//        int end = k;
//
//        while(start < k){
//            queue.offer(nums[start++]);
//        }
//
//        list.add(queue.peek());
//        start = 0;
//
//        while(end < nums.length){
//            queue.remove(nums[start++]);
//            queue.offer(nums[end++]);
//
//            list.add(queue.peek());
//        }
//
//        int[] result = new int[list.size()];
//
//        for(int i=0; i<list.size(); i++){
//            result[i] = list.get(i);
//        }
//
//        return result;
//    }

    // Solution 3 - using Dequeue
    // O(N)/O(K)
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);

            if (i >= k && nums[i - k] == deque.getFirst()) {
                deque.pollFirst();
            }

            if (i >= k - 1) {
                res.add(deque.getFirst());
            }
        }

        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
}
