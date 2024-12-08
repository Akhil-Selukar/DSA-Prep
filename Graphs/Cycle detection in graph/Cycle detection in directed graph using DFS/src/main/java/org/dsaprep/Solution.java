package org.dsaprep;

import java.util.List;

public class Solution {
    public boolean isCyclic(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] isInPath = new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                if(cycleDetectionDFS(adj, visited, isInPath, i)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cycleDetectionDFS(List<List<Integer>> adj, boolean[] visited, boolean[] isInPath, int node) {
        visited[node] = true;
        isInPath[node] = true;

        for(int adjacentValue : adj.get(node)){
            if(!visited[adjacentValue]){
                 if(cycleDetectionDFS(adj, visited, isInPath, adjacentValue)){
                     return true;
                 }
            } else if(isInPath[adjacentValue]){
                return true;
            }
        }

        isInPath[node] = false;
        return false;
    }
}
