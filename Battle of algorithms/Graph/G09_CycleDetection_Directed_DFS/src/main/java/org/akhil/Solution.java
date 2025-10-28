package org.akhil;

import java.util.List;

/*
    To detect cycle in directed graph using DFS, along with visited elements we also need to keep track of what all values
    are in current path. Because if we can reach to a value which is already in the same path then that means we have a
    cycle.
 */
public class Solution {
    public boolean isCyclic(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] isInPath = new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, isInPath)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int vertex, List<List<Integer>> adj, boolean[] visited, boolean[] isInPath) {
        visited[vertex] = true;
        isInPath[vertex] = true;

        for(int neighbor:adj.get(vertex)){
            if(!visited[neighbor]){
                if(dfs(neighbor, adj, visited, isInPath)){
                    return true;
                }
            } else if(isInPath[neighbor]){
                return true;
            }
        }

        isInPath[vertex] = false;
        return false;
    }
}
