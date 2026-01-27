package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // Here we are asked to find the minimum total cost to travel from 0 to n-1 node -> So shortest path weight between 0 to n-1
    // Means our start point is 0.
    // Now 1 additional twist is we can reverse the incoming edge at any node 1 time and the weight of reversed edge will
    // be 2 * weight of original edge. So before finding the shortest path we need to reverse all incoming edges.
    // Once edges are reversed and added to the graph we can simply run a Dijkstras algorithm to find the shortest distance.

    // Solution using Dijkstras algorithm
    // O(ElogV)/O(V+E)  -> Dijkstras algorithm
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList());
        }

        for(int[] edge:edges){
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            graph.get(start).add(new int[]{end, weight});
            // reversed edge
            graph.get(end).add(new int[]{start, 2*weight});
        }

        int[] dist = new int[n];
        for(int i=1; i<n; i++){
            dist[i] = (int)1e9;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{      // [node, weight]
            return a[1]-b[1];
        });

        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] polled = queue.poll();

            int startNode = polled[0];
            int currWeight = polled[1];

            for(int[] neighbor:graph.get(startNode)){
                int neighbourWeight = neighbor[1];
                int neighborNode = neighbor[0];

                if(dist[neighborNode] > (currWeight+neighbourWeight)){
                    dist[neighborNode] = currWeight+neighbourWeight;
                    queue.offer(new int[]{neighborNode, dist[neighborNode]});
                }
            }
        }

        return dist[n-1] == (int)1e9 ? -1 : dist[n-1];
    }
}
