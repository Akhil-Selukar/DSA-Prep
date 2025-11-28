package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int components = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        // dfs
        findComponents(adj, values, k, visited, 0);
        return components;
    }

    private long findComponents(List<List<Integer>> adj, int[] values, int k, boolean[] visited, int node){
        visited[node] = true;

        long currSum = values[node];
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                currSum = currSum + findComponents(adj, values, k, visited, neighbor);
            }
        }

        if(currSum % k == 0){
            components++;
            return 0;       // new component formed hence broke the edge. So the sum returned from here will be zero as the parent node to this node is leaf node now because we broke the edge.
        }
        return currSum;
    }
}
