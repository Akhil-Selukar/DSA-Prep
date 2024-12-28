package org.akhil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int counter = 1;
    public List<List<Integer>> criticalConnections(int noOfNodes, List<List<Integer>> connections) {

        // Here connections are given so we need to create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<noOfNodes; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge:connections){
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[noOfNodes];
        int[] timeOfInsertion = new int[noOfNodes];
        int[] lowestTime = new int[noOfNodes];

        List<List<Integer>> answer = new ArrayList<>();

        dfs(0, -1, adj, visited, timeOfInsertion, lowestTime, answer);
        return answer;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited, int[] iterationNo, int[] lowestPath, List<List<Integer>> answer) {
        visited[node] = true;
        iterationNo[node] = counter;
        lowestPath[node] = counter;
        counter++;

        for(int adjNode:adj.get(node)){
            if(adjNode == parent) continue;
            if(!visited[adjNode]){
                dfs(adjNode, node, adj, visited, iterationNo, lowestPath, answer);
                lowestPath[node] = Math.min(lowestPath[node], lowestPath[adjNode]);

                if(lowestPath[adjNode] > iterationNo[node]){
                    answer.add(Arrays.asList(adjNode, node));
                }
            } else {
                lowestPath[node] = Math.min(lowestPath[node], lowestPath[adjNode]);
            }
        }
    }
}
