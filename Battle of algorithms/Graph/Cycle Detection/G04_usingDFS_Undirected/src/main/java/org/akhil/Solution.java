package org.akhil;

import java.util.List;

public class Solution {
    public boolean detectCycle(List<List<Integer>> adj) {
        if(adj == null || adj.size() == 0){
            return false;
        }

        boolean[] visited = new boolean[adj.size()];
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                if(isCyclePresent(i, adj, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclePresent(int i, List<List<Integer>> adj, boolean[] visited, int parent) {
        visited[i] = true;

            for(int neighbor:adj.get(i)){
                if(!visited[neighbor]){
                    if(isCyclePresent(neighbor, adj, visited, i)){
                        return true;
                    }
                } else if(neighbor != parent){
                    return true;
                }
            }
        return false;
    }
}
