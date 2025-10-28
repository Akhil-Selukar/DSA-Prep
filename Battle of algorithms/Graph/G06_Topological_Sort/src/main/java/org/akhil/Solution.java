package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
The definition of topological sorting stats that, topological sorted ordering is any linear ordering of vertices such
that if there is an edge present from U to V, then U must appear before V in the ordering.

Topological sorting is present in only Directed Acyclic Graph (i.e. DAG)
 */
public class Solution {

    public List<Integer> topologicalSort(List<List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                dfs(i, adj, stack, visited);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    private void dfs(int vertex, List<List<Integer>> adj, Stack<Integer> stack, boolean[] visited){
        visited[vertex] = true;

        for(int neighbor:adj.get(vertex)){
            if(!visited[neighbor]){
                dfs(neighbor, adj, stack, visited);
            }
        }
        stack.add(vertex);
    }
}
