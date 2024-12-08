package org.akhil;

import java.util.ArrayList;
import java.util.List;

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
}
