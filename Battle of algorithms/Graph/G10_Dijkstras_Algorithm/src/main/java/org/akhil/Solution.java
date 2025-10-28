package org.akhil;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int[] dijkstra(List<List<Pair>> adj, int startNode){

        int[] dist = new int[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(i == startNode){
                dist[i] = 0;
            } else {
                dist[i] = (int)1e9;
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        queue.offer(new int[]{0, startNode});

        while(!queue.isEmpty()){
            int[] polled = queue.poll();
            int polledNode = polled[1];
            int distOfPolled = polled[0];

            for(Pair neighbor:adj.get(polledNode)){
                int node = neighbor.node;
                int weight = neighbor.dist;

                int newDistance = distOfPolled + weight;
                if(dist[node] > newDistance){
                    dist[node] = newDistance;
                    queue.offer(new int[]{newDistance, node});
                }
            }
        }
        return dist;
    }
}
