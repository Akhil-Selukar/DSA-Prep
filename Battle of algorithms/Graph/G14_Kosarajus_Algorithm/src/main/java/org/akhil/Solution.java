package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> kosaraju(int noOfNodes, List<List<Integer>> adj){
        Stack<Integer> topoOrder = new Stack<>();
        boolean[] visited = new boolean[noOfNodes];

        // topo sort code (dfs)
        for(int i=0; i<noOfNodes; i++){
            if(!visited[i]){
                dfs(adj, i, visited, topoOrder);
            }
        }

        // reverse the edges
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for(int i=0; i<noOfNodes; i++){
            visited[i] = false;         // to reuse further
            reversedGraph.add(new ArrayList<>());
        }

        for(int i=0; i<noOfNodes; i++){
            for(int neighbor:adj.get(i)){
                reversedGraph.get(neighbor).add(i);         // actual reversal
            }
        }

        // another DFS to count no of SCC
        int result = 0;
        List<List<Integer>> scc = new ArrayList<>();
        while(!topoOrder.isEmpty()){
            int node = topoOrder.pop();
            if(!visited[node]){
                result++;
                List<Integer> component = new ArrayList<>();
                sccDfs(reversedGraph, node, visited, component);
                scc.add(component);
            }
        }
//        return result;  // if asked count return result
        return scc;     // if asked scc's return this
    }

    private void sccDfs(List<List<Integer>> reversedAdj, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);

        for(int neighbor:reversedAdj.get(node)){
            if(!visited[neighbor]){
                sccDfs(reversedAdj, neighbor, visited, component);
            }
        }
    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> topoOrder) {
        visited[node] = true;

        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                dfs(adj, neighbor, visited, topoOrder);
            }
        }
        topoOrder.push(node);
    }
}
