package org.akhil;

import java.util.*;

public class Solution {

//    // Solution 1 - using map and priorityQueue
//    // O(N logN)/O(N)
//    public long minCost(int[] basket1, int[] basket2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Integer> swapCandidates = new PriorityQueue<>((a,b) -> a-b);
//        int minElement = Integer.MAX_VALUE;         // for indirect swapping
//
//        for(int num:basket1){
//            map.put(num, map.getOrDefault(num, 0)+1);
//            minElement = Math.min(minElement, num);
//        }
//
//        for(int num:basket2){
//            map.put(num, map.getOrDefault(num, 0)-1);
//            minElement = Math.min(minElement, num);
//        }
//
//        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
//            int count = entry.getValue();
//
//            if(count == 0){
//                continue;
//            }
//            if(count % 2 == 0){
//                int elementsToSwap = Math.abs(count/2);
//                while(elementsToSwap > 0) {
//                    swapCandidates.offer(entry.getKey());
//                    elementsToSwap--;
//                }
//            } else {
//                return -1;
//            }
//        }
//
//        long cost = 0;
//        int swapCount = swapCandidates.size()/2;
//        while(swapCount > 0){
//            cost = cost + Math.min(swapCandidates.poll(), minElement * 2);
//            swapCount--;
//        }
//
//        return cost;
//    }

    //---------------------------------
    // Solution 1 - using map and List
    // O(N logN)/O(N) -> even though the complexity is same but this solution will be faster as in case of priority queue
    // log component will be in each addition as shifting will happen. But here in case of list we are sorting the list
    // only once hence no repeated log component in overall time.
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int minElement = Integer.MAX_VALUE;         // for indirect swapping

        for(int num:basket1){
            map.put(num, map.getOrDefault(num, 0)+1);
            minElement = Math.min(minElement, num);
        }

        for(int num:basket2){
            map.put(num, map.getOrDefault(num, 0)-1);
            minElement = Math.min(minElement, num);
        }

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int count = entry.getValue();

            if(count == 0){
                continue;
            }
            if(count % 2 == 0){
                int elementsToSwap = Math.abs(count/2);
                while(elementsToSwap > 0) {
                    list.add(entry.getKey());
                    elementsToSwap--;
                }
            } else {
                return -1;
            }
        }

        Collections.sort(list);
        long cost = 0;
        int swapCount = list.size()/2;
        for(int i=0; i<swapCount; i++){
            cost = cost + Math.min(list.get(i), minElement * 2);
        }

        return cost;
    }
}
