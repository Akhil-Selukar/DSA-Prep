package org.dsaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // O(V+E) / O(V+E)
    // Leetcode question 1192
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // create adjacency list as it is not given.

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge:connections){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        // define necessary arrays.
        boolean[] visited = new boolean[n];
        int[] discoveryTime = new int[n];       // to store at what iteration the node was discovered.
        int[] minDiscoveryTime = new int[n];    // to store the lowest discovery time reachable from this node (including itself) through back-edges in its DFS subtree.
        int time = 1;                           // time or iteration number, represent when the node was discovered

        List<List<Integer>> result = new ArrayList<>();     // to store the edges forming SCC or bridges.

        dfs(0, -1, adj, visited, discoveryTime, minDiscoveryTime, result, time);
        return result;

    }

    private void dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited, int[] discoveryTime, int[] minDiscoveryTime, List<List<Integer>> result, int time) {
        visited[node] = true;
        discoveryTime[node] = time;
        minDiscoveryTime[node] = time;
        time++;

        for(int adjNode:adj.get(node)){
            // if adjNode is parent then skip. (This is important, we can't relay on visited here because based on visited we need to do calculations below.
            if(adjNode == parent){
                continue;
            }

            if(!visited[adjNode]){
                dfs(adjNode, node, adj, visited, discoveryTime, minDiscoveryTime, result, time);
                minDiscoveryTime[node] = Math.min(minDiscoveryTime[node], minDiscoveryTime[adjNode]);

                if(minDiscoveryTime[node] < discoveryTime[adjNode]){        // VVIMP - comparing minDiscoveryTime with discoveryTime of adjNode.
                    result.add(Arrays.asList(adjNode, node));
                }
            } else {
                minDiscoveryTime[node] = Math.min(minDiscoveryTime[node], minDiscoveryTime[adjNode]);
            }
        }
    }
}
