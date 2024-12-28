package org.dsaprep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int kosaraju(int noOfNodes, int[][] adj){
        boolean[] visited = new boolean[noOfNodes];
        Stack<Integer> stack = new Stack<>();

        // DFS to sort nodes based on finishing time.
        for(int i=0; i<noOfNodes; i++){
            if(!visited[i]){
                dfs(i, visited, adj, stack);
            }
        }

        // to store reversed graph new adj list
        List<List<Integer>> reversedAdj = new ArrayList<>();
        for(int i=0; i<noOfNodes; i++){
            reversedAdj.add(new ArrayList<>());
        }

        // reverse the graph
        for(int i=0; i<noOfNodes; i++){
            visited[i] = false;         // we need visited array again further hence resetting here only instead of running another loop just to resent or creating a new one.
            for(int adjNode:adj[i]){
                reversedAdj.get(adjNode).add(i);       // actual reversal
            }
        }

        // another DFS on reversed graph to calculate SCC.
        int scc = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                scc++;
                secondDfs(node, visited, reversedAdj);
            }
        }
        return scc;
    }

    private void dfs(int node, boolean[] visited, int[][] adj, Stack<Integer> stack){
        visited[node] = true;
        for(int adjNode:adj[node]){
            if(!visited[adjNode]){
                dfs(adjNode, visited, adj, stack);
            }
        }
        stack.push(node);
    }

    private void secondDfs(int node, boolean[] visited, List<List<Integer>> adj){
        visited[node] = true;
        for(int adjNode:adj.get(node)){
            if(!visited[adjNode]){
                secondDfs(adjNode, visited, adj);
            }
        }
    }
}
