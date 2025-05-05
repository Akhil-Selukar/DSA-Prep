package org.akhil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    // Solution 1 - using set (O(N+K+B)/O(N+K))
//    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        Set<Integer> keysAvailable = new HashSet<>();
//        Set<Integer> boxesAvailable = new HashSet<>();
//        int total = 0;
//
//        for(int initial:initialBoxes){
//            boxesAvailable.add(initial);        // we can get key for these boxes somewhere so we need to carry all these boxes.
//            if(status[initial] == 1){
//                queue.offer(initial);           // these boxes are already open so we can pick the candies from these boxes.
//            }
//        }
//
//        while(!queue.isEmpty()){
//            int polled = queue.poll();
//            total = total + candies[polled];
//
//            int[] keysFound = keys[polled];
//            int[] boxesFound = containedBoxes[polled];
//
//            for(int key:keysFound){
//                keysAvailable.add(key);
//                if(boxesAvailable.contains(key) && status[key] == 0){       // box is available and closed (because if it is opened then it is already in queue, so no need to add again)
//                    status[key] = 1;        // if it was closed then open the box.
//                    queue.offer(key);       // as box is opened now so add in queue.
//                }
//            }
//
//            for(int newBox:boxesFound){
//                boxesAvailable.add(newBox);
//                if(keysAvailable.contains(newBox) || status[newBox] == 1){      // status[newBox]==1 is imp because it can happen that we found already opened box, and we dont need the key)
//                    status[newBox] = 1;
//                    queue.offer(newBox);
//                }
//            }
//
//        }
//        return total;
//    }


    // Solution 2 - using arrays (same complexity)
    // even though the time and space complexities are same but array solution is a bit faster than set one.
    // this is because of accessing an element in array is constant time operation because of contiguous memory allocation while
    // operations on set has AVERAGE time complexity of O(1) this is because operations on set (typically hash based set) involve calculation of hash,
    // determining index based on hash, collision handling, etc hence solution with arrays is faster than set even though time complexity is same.
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] keysAvailable = new boolean[status.length];
        boolean[] boxesAvailable = new boolean[status.length];
        int total = 0;

        for(int initial:initialBoxes){
            boxesAvailable[initial] = true;        // we can get key for these boxes somewhere so we need to carry all these boxes.
            if(status[initial] == 1){
                queue.offer(initial);           // these boxes are already open so we can pick the candies from these boxes.
            }
        }

        while(!queue.isEmpty()){
            int polled = queue.poll();
            total = total + candies[polled];

            int[] keysFound = keys[polled];
            int[] boxesFound = containedBoxes[polled];

            for(int key:keysFound){
                keysAvailable[key] = true;
                if(boxesAvailable[key] && status[key] == 0){       // box is available and closed (because if it is opened then it is already in queue, so no need to add again)
                    status[key] = 1;        // if it was closed then open the box.
                    queue.offer(key);       // as box is opened now so add in queue.
                }
            }

            for(int newBox:boxesFound){
                boxesAvailable[newBox] = true;
                if(keysAvailable[newBox] || status[newBox] == 1){      // status[newBox]==1 is imp because it can happen that we found already opened box, and we dont need the key)
                    status[newBox] = 1;
                    queue.offer(newBox);
                }
            }

        }
        return total;
    }
}
