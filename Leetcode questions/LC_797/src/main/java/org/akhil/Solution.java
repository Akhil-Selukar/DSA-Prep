package org.akhil;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(V + E) - due to the graph traversal nature of DFS.
// Space Complexity: O(V) - for the visited array, the temp list during recursion, and the recursion stack depth. The space for the output list ans is O(P * V), where P is the number of paths.
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[] visited = new int[graph.length];

        List<Integer> temp = new ArrayList<Integer>();
        // we are standing at 0 that means 0 is visited.
        temp.add(0);
        visited[0]=1;

        traverse(graph, visited, 0, temp);

        return ans;
    }

    private void traverse(int[][] graph, int[] visited, int node, List<Integer> temp) {
        if(graph[node].length == 0){
            if(node != graph.length-1){
                return;
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int neighbour:graph[node]){
            if(visited[neighbour] != 1){
                temp.add(neighbour);
                visited[neighbour] = 1;
                traverse(graph, visited, neighbour, temp);
                temp.remove(temp.size()-1);
                visited[neighbour] = 0;
            }
        }
    }
}
