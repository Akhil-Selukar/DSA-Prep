package org.akhil;

import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // convert adj matrix to adj List
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }

        // perform dfs
        boolean[] visited = new boolean[adjList.size()];
        boolean[] isInPath = new boolean[adjList.size()];
        boolean[] isSafe = new boolean[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                dfs(adjList, visited, isInPath, isSafe, i);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i< isSafe.length; i++){
            if(isSafe[i]){
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean dfs(List<List<Integer>> adjList, boolean[] visited, boolean[] isInPath, boolean[] isSafe, int i) {
        visited[i] = true;
        isInPath[i] = true;
        isSafe[i] = false;

        for(int adjNode:adjList.get(i)){
            if(!visited[adjNode]){
                if(dfs(adjList, visited, isInPath, isSafe, adjNode)){
                    return true;
                }
            }else if(isInPath[adjNode]){
                return true;
            }
        }
        isInPath[i] = false;
        isSafe[i] = true;
        return false;
    }

    // Approach 2

    public List<Integer> eventualSafeNodes2(int[][] graph) {
        // conversion of graph to adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        // reverse the direction and calculate inDegree
        List<List<Integer>> reversedAdj = new ArrayList<>();
        int[] inDegree = new int[adj.size()];

        for(int i=0; i<adj.size(); i++){
            reversedAdj.add(new ArrayList<>());
        }

        for(int i=0; i<adj.size(); i++){
            for(int val: adj.get(i)){
                reversedAdj.get(val).add(i);
                inDegree[i]++;
            }
        }

        // initialize queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            answer.add(temp);
            for(int adjVal:reversedAdj.get(temp)){
                inDegree[adjVal]--;
                if(inDegree[adjVal] == 0){
                    queue.offer(adjVal);
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
