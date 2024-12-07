package org.dsaprep;

import java.util.List;

public class Solution {

    public boolean detectCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        // loop because there can be multiple sub-graphs and if cycle is present in any one of them then we can say cycle is present in given graph.
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                if(helperDFS(adj, visited, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helperDFS(List<List<Integer>> adj, boolean[] visited, int value, int parent) {
        visited[value] = true;
        for(int adjValue:adj.get(value)){
            if(!visited[adjValue]){
                return helperDFS(adj, visited, adjValue, value);
            } else if(adjValue != parent){
                return true;
            }
        }
        return false;
    }
}
