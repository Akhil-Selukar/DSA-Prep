package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private class Pair{
        private int weight;
        private int node;
        private int parent;

        public Pair(int weight, int node, int parent){
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    public int minimumSpanningTree(List<List<int[]>> adj) {
        if(adj == null || adj.size() == 0){
            return 0;
        }

        int mstWeight = 0;
        List<int[]> mstEdges = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        int visitedCount = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> {
            return a.weight - b.weight;
        });

        queue.offer(new Pair(0, 0, -1));          //[distance from start, start node, parent node]

        while(!queue.isEmpty()){
            Pair polled = queue.poll();

            int weight = polled.weight;
            int node = polled.node;
            int parent = polled.parent;

            if(visited[node]){
                continue;
            }

            mstWeight = mstWeight + weight;
            visited[node] = true;
            visitedCount++;
            if(parent >= 0){
                mstEdges.add(new int[]{parent, node});
            }

            for(int[] neighbor:adj.get(node)){
                int adjNode = neighbor[0];
                int adjWeight = neighbor[1];

                if(!visited[adjNode]){
                    queue.offer(new Pair(adjWeight, adjNode, node));
                }
            }
        }

        if(visitedCount != adj.size()){
            return 0;
        }
        return mstWeight;
    }
}
