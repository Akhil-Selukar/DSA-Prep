package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        int[] indegree = new int[n];
        boolean[] infected = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:invocations){
            int from = edge[0];
            int to = edge[1];
            indegree[to]++;

            adj.get(from).add(to);
        }

        // perform a traversal from infected node k to mark entire infection
        // also reduce indegree of infected nodes
        dfs(adj, infected, indegree, k);

        // check which all nodes are not infected also if there is any node which is infected but has indegree > 0 that means there is
        // an edge to that node from non-infected group so simply return entire graph
        List<Integer> result = new ArrayList<>();
        boolean noRemoval = false;
        for(int i=0; i<n; i++){
            if(infected[i]){
                if(indegree[i] > 0) {
                    noRemoval = true;
                    break;
                }
            } else {
                result.add(i);
            }
        }

        if(noRemoval){
            result.clear();
            for(int i=0; i<n; i++){
                result.add(i);
            }
            return result;
        }
        return result;

    }

    private void dfs(List<List<Integer>> adj, boolean[] infected, int[] indegree, int k){
        infected[k] = true;
        for(int neighbor:adj.get(k)){
            indegree[neighbor]--;
            if(!infected[neighbor]){
                dfs(adj, infected, indegree, neighbor);
            }
        }
    }
}
