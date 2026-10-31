package org.akhil;

import java.util.*;

public class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u  = edge[0];
            int v  = edge[1];
            int weight = edge[2];

            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, weight});
        }

        // result[node][count] = min cost to reach node with 'count' consecutive identical chars
        int[][] result = new int[n][k + 1];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);       // {dist, node, count} ordered by dist

        // initialization
        result[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d     = top[0];
            int node  = top[1];
            int count = top[2];

            if(d > result[node][count]) {       // we already have better way to reach at this node
                continue;
            }

            if(node == n - 1) {     // we have reached to the destination.
                return d;
            }

            if (!adj.containsKey(node)) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {
                int neighborNode = neighbor[0];
                int neighborWt = neighbor[1];

                int newCount = (labels.charAt(neighborNode) == labels.charAt(node)) ? count + 1 : 1;

                if (newCount > k) {
                    continue;
                }

                int newDist = d + neighborWt;
                if (newDist < result[neighborNode][newCount]) {
                    result[neighborNode][newCount] = newDist;
                    pq.offer(new int[]{newDist, neighborNode, newCount});
                }
            }
        }
        return -1;
    }
}
