package org.akhil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    private class Pair{
        int node;
        int weight;

        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int ed, int vertices, int[][] edges) {

        // creation and population of adjacency list.
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<ed; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int weight = edges[i][2];

            adj.get(start).add(new Pair(end, weight));
        }

        // create visited array
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<vertices; i++){
            if(!visited[i]){
                topoSort(i, adj, visited, stack);
            }
        }

        // initialize distance array
        int dist[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = (int)(1e9);
        }

        dist[6] = 0;     // here we have considered starting node as 6.
        while(!stack.isEmpty()){
            int tempNode = stack.pop();

            for(int i=0; i<adj.get(tempNode).size(); i++){
                int adjNodeValue = adj.get(tempNode).get(i).node;
                int adjNodeEdgeWeight = adj.get(tempNode).get(i).weight;

                if (dist[tempNode] + adjNodeEdgeWeight <= dist[adjNodeValue]) {
                    dist[adjNodeValue] = dist[tempNode] + adjNodeEdgeWeight;
                }
            }
        }

        return dist;        // if for node which is not connected need to return -1 then replace default value with -1 in dist array.
    }

    private void topoSort(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for(int i=0; i<adj.get(node).size(); i++){
            int adjNode = adj.get(node).get(i).node;
            if(!visited[adjNode]){
                topoSort(adjNode, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}
