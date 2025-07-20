package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    // Solution 1 - Using priorityQueue and more intuitive
    // TC -> O(N^2)   because of priorityQueue.remove() call
    // SC -> O(N)
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // separate the coordinates (i.e. identify the points where height is changing by EACH rectangle (no need to worry about overlapping yet))
        List<int[]> coordinates = new ArrayList<>();
        for(int[] building:buildings){
            int startPoint = building[0];
            int endPoint = building[1];
            int height = building[2];

            coordinates.add(new int[]{startPoint, -1*height});      // -ve height represent that from here new rectangle/building is starting.
            coordinates.add(new int[]{endPoint, height});           // +ve height means the building is ending here.
        }

        // Now as in any case start point of building will come before end point and in result as well we have to return building starting first before building starting later.
        Collections.sort(coordinates, (a, b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());     // need greater height first.

        int currHeight = 0;
        queue.offer(0);         // starting height will be 0

        for(int i=0; i<coordinates.size(); i++){
            int xCoordinate = coordinates.get(i)[0];
            int height = coordinates.get(i)[1];

            if(height < 0){     // new building is starting from this point
                queue.offer(-1*height);         // need to convert height to positive (it was made negative to distinguish between start and end of building (the if condition above)
            } else {    // a building is ending at this point
                queue.remove(height);
            }

            // if current height and maximum height out of active rectangles are same then no need to do anything as there is no height change at this point
            if(currHeight != queue.peek()){
                List<Integer> temp = new ArrayList<>();
                temp.add(xCoordinate);          // at this point on x-axis height is changing
                temp.add(queue.peek());         // what is the new height

                result.add(temp);
                currHeight = queue.peek();
            }
        }
        return result;
    }
}
