package org.akhil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int[] shortestPath(List<List<Integer>> adj, int numberNodes, int numberEdges , int src) {

        // Create distance array
        int[] distance = new int[numberNodes];

        // initialize distance array
        for(int i=0; i<numberNodes; i++){
            distance[i] = 9999999;      // some large number
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        distance[0] = 0;

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int value = polled[0];
            int minDistance = polled[1];

            for(int adjNode:adj.get(value)){
                int dist = distance[value] + 1;
                if(dist < distance[adjNode]){
                    distance[adjNode] = dist;
                    queue.offer(new int[]{adjNode, dist});
                }
            }
        }

        // mark all unreachable nodes as -1
        for(int i=0; i< distance.length; i++){
            if(distance[i] == 9999999){
                distance[i] = -1;
            }
        }

        return distance;
    }
}
