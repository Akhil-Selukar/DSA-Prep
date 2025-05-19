package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    // Time Complexity: O(E log N), where E is the number of edges and N is the number of nodes (due to Dijkstra's).
    // Space Complexity: O(N + E), for the adjacency list and minDist array.
    private final int MOD = (int)1e9+7;
    public int countRestrictedPaths(int n, int[][] edges) {
        // Create adjacency list
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        // Dijkstra's algorithm (calculate minimum distance of each vertex from n)
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);    // [node, distance/weight]
        int[] minDist = new int[n+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        queue.offer(new int[]{n, 0});       // starting from nth node hence distance will be 0 from that node
        minDist[n] = 0;

        while(!queue.isEmpty()){
            int[] polled = queue.poll();

            int node = polled[0];
            int dist = polled[1];

            for(int[] neighbor:adj.get(node)){
                int neigh = neighbor[0];
                int distToNeigh = dist + neighbor[1];

                if(distToNeigh < minDist[neigh]){
                    minDist[neigh] = distToNeigh;
                    queue.offer(new int[]{neigh, distToNeigh});
                }
            }
        }

        // DFS to find restricted path
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(adj, 1, n, minDist, dp);
    }

    private int dfs(List<List<int[]>> adj, int start, int end, int[] minDist, int[] dp) {
        int res = 0;
        if(start == end){
            return 1;
        }

        if(dp[start] != -1){
            return dp[start];
        }

        for(int[] neigh:adj.get(start)){
            int node = neigh[0];

            if(minDist[start] > minDist[node]) {
                res = (res + dfs(adj, node, end, minDist, dp)) % MOD;
            }
        }

        return dp[start] = res;
    }
}
