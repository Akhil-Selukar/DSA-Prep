package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<Integer> DFSTraversal(int startVertex, List<List<Integer>> adj){
        List<Integer> result = new ArrayList<>();
        if(adj == null || adj.size() == 0 || startVertex >= adj.size()){
            return result;
        }

        boolean[] visited = new boolean[adj.size()];

        helper(result, visited, startVertex, adj);
        return result;
    }

    private void helper(List<Integer> result, boolean[] visited, int start, List<List<Integer>> adj) {
        visited[start] = true;

        result.add(start);

        for(int neighbor:adj.get(start)){
            if(!visited[neighbor]){
                helper(result, visited, neighbor, adj);
            }
        }
    }

}
