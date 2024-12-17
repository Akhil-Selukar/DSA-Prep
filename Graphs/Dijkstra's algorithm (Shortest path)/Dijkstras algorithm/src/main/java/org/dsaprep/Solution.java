package org.dsaprep;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] dijkstra(List<List<Pair>> adj, int startNode){
        // implementation of min-priority queue
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> {
            if(a.getDistance() == b.getDistance()){
                return a.getNode() - b.getNode();
            } else {
                return a.getDistance() - b.getDistance();
            }
        });

        int[] distance = new int[adj.size()];
        for(int i=0; i<adj.size(); i++){
            distance[i] = 900000;
        }

        queue.offer(new Pair(startNode, 0));
        distance[startNode] = 0;

        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int node = temp.getNode();
            int dist = temp.getDistance();

            for(Pair adjPair:adj.get(node)){
                int adjWeight = adjPair.getDistance();
                int adjNode = adjPair.getNode();

                if(distance[adjNode] > (adjWeight+dist)){
                    queue.offer(new Pair(adjNode, adjWeight+dist));
                    distance[adjNode] = adjWeight+dist;
                }
            }
        }
        return distance;
    }
}
