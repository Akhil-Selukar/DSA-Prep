package org.akhil;

import java.util.*;

// O(N+E)/O(N+E)
public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // create adj list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:dislikes){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);      // here a hate b means b and a can not be in same group hence we can infer that b also hates a.
        }

        // bipartite graph
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        for(int i=1; i<=n; i++){
            if(color[i] == -1){
                if(!isBipartite(adj, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(List<List<Integer>> adj, int node, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 0;

        while(!queue.isEmpty()){
            int polled = queue.poll();

            for(int neighbour:adj.get(polled)){
                if(color[neighbour] == -1){
                    color[neighbour] = 1 - color[polled];
                    queue.offer(neighbour);
                } else if(color[neighbour] == color[polled]){
                    return false;
                }
            }
        }
        return true;
    }


}
