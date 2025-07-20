package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinder {

    // Solution 1 - Bruteforce
    // TLE because for every findMedian call we are sorting the list which will take O(NlogN) and N keeps on increasing.
//    List<Integer> list = null;
//    public MedianFinder() {
//        list = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        list.add(num);
//    }
//
//    public double findMedian() {
//        int size = list.size();
//        Collections.sort(list);
//
//        if(size%2 == 1){
//            return (double) list.get(size/2);
//        }
//
//        return (double) (list.get((size/2)-1) + list.get(size/2))/2.0;
//    }


    // Solution 2 - using priorityQueue

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {         // O(1)
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {       // O(logN)
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {        // O(1)
        if (maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }
}
