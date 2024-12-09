package org.dsaprep;

import java.util.List;
import java.util.Stack;

public class Solution {

    public void topologicalSort(List<List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                dfs(adj, visited, stack, i);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" , ");
        }
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack, int node){
        visited[node] = true;

        for(int adjNode:adj.get(node)){
            if(!visited[adjNode]){
                dfs(adj, visited, stack, adjNode);
            }
        }
        stack.push(node);
    }
}
