package org.akhil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    // O(N^2 * 2^N)/O(N*2^N)
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // This bit masking logic is because we cna revisit the nodes (i.e. while traversing we can come back the node which was already visited)
        int finalBitMask = (1<<n)-1;        // this should be the value of bit mask when all elements are traversed. (we are considering index of bit as node value i.e. LSB will be for node 0 and so on, if the bit is set i.e. 1 that means the node is visited)

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for(int i=0; i<n; i++){
            queue.offer(new int[]{i, (1<<i), 0});       // we want to find shortest path hence we need to explore path starting from each node hence in starting condition considering each node as starting point. if node i is starting point then at that point distance will be 0 and set bit in current mask will be ith bit.
            visited.add(i+","+(1<<i));
        }

        // explore path from each starting node by using BFS
        while(!queue.isEmpty()){
            int[] currPosition = queue.poll();

            int node = currPosition[0];
            int currMask = currPosition[1];
            int currDistance = currPosition[2];

            // if this mask is equal to final mask which we are expecting then that means in this path we have visited all nodes.
            if(currMask == finalBitMask){
                return currDistance;
            }

            for(int neighbour:graph[node]){
                int newMask = currMask | (1<<neighbour);    // setting the neighbour node bit to 1 in currMask.
                String visitedKey = neighbour+","+newMask;

                if(!visited.contains(visitedKey)){
                    visited.add(visitedKey);
                    queue.offer(new int[]{neighbour, newMask, currDistance+1});         // if from node we have not visited the neighbour then visit the neighbour.
                }
            }
        }

        return -1;      // if we are here then that means it is impossible to traverse the graph.
    }
}

