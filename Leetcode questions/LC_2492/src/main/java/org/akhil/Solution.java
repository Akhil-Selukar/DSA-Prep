package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // As it is mentioned here that we need to find the minimum score and not the shortest path. So we can take any path
    // it doesn't matter that path considers most expensive route or the shortest one.
    // Another thing given is there will be a path present from 1 to n in the graph so in all test cases 1st node and nth node
    // are for sure connected. So as we don't need to worry about shortest path we can simply choose the path which cover
    // all connected nodes between 1 to n and then the score of that path will be the shortest distance value between any two
    // connected nodes in that path/graph
    // So in short what we need to find here is the smallest possible edge weight from all edges which are connected to 1st node.

    // O(V+E)/O(V+E)
    public int minScore(int n, int[][] roads) {
        // create adjacency list
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road:roads){
            int from = road[0];
            int to = road[1];
            int dist = road[2];

            adj.get(from).add(new int[]{to, dist});
            adj.get(to).add(new int[]{from, dist});
        }

        // perform a BFS
        int minDist = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);         // starting from 1 we need to go to n
        boolean[] visited = new boolean[n+1];

        while(!queue.isEmpty()){
            int polled = queue.poll();
            List<int[]> neighbors = adj.get(polled);

            for(int[] neighbor:neighbors){
                minDist = Math.min(minDist, neighbor[1]);

                if(!visited[neighbor[0]]){
                    queue.offer(neighbor[0]);
                    visited[neighbor[0]] = true;
                }
            }
        }
        return minDist;
    }
}
