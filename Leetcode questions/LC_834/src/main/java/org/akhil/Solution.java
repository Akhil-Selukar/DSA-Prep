package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - DFS (O(V*(V+E)) ~ O(V^2)/O(V))
    // will give TLE
//    int sum = 0;
//    int finalSum = 0;
//    public int[] sumOfDistancesInTree(int n, int[][] edges) {
//
//        // create adj list
//        List<List<Integer>> adj = new ArrayList<>();
//
//        for(int i=0; i<n; i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int[] edge:edges){
//            int start = edge[0];
//            int end = edge[1];
//
//            adj.get(start).add(end);
//            adj.get(end).add(start);
//        }
//
//        int[] answer = new int[n];
//        int[] visited = new int[n];
//
//        for(int i=0; i<n; i++){
//            sum = 0;
//            finalSum = 0;
//            Arrays.fill(visited, 0);
//            dfs(adj, visited, i);
//            answer[i] = finalSum;
//        }
//
//        return answer;
//    }
//
//    private void dfs(List<List<Integer>> adj, int[] visited, int node) {
//        visited[node] = 1;
//
//        for(int neighbour : adj.get(node)){
//            if(visited[neighbour] == 0){
//                visited[neighbour] = 1;
//                sum++;
//                finalSum = finalSum + sum;
//                dfs(adj, visited, neighbour);
//            }
//        }
//        sum--;
//    }


    // Solution 2 - Using DFS only 2 times (O(V+E) ~ O(V)/O(V))
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        // create adj list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(i, new ArrayList<>());
        }
        for(int[] edge:edges){
            int start = edge[0];
            int end = edge[1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        boolean[] visited = new boolean[n];
        int[] child = new int[n];
        int[] result = new int[n];

        // initializing child array with 1 as we are considering the node as well to be its child of itself.
        for(int i=0; i<n; i++){
            child[i] = 1;
        }

        result[0] = dfs1(adj, visited, child, 0, 0);            // calculate sum i.e. answer for 0th node and populate child array for all nodes.
        visited = new boolean[n];                                         // reset visited array
        dfs2(adj, visited, child, result, 0);                       // to calculate results for all other nodes

        return result;
    }

    private int dfs1(List<List<Integer>> adj, boolean[] visited, int[] child, int dist, int node) {
        visited[node] = true;
        int tempDist = dist;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                tempDist = tempDist + dfs1(adj, visited, child, dist+1, neighbour);
                child[node] = child[node] + child[neighbour];
            }
        }
        return tempDist;
    }

    private void dfs2(List<List<Integer>> adj, boolean[] visited, int[] child, int[] result, int node){
        visited[node] = true;
        for(int neighbour:adj.get(node)){
            if(!visited[neighbour]){
                result[neighbour] = result[node] - child[neighbour] + (adj.size() - child[neighbour]);
                dfs2(adj, visited, child, result, neighbour);
            }
        }
    }
}
