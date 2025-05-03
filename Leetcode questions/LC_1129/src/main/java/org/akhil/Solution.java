package org.akhil;

import java.util.*;

public class Solution {

    // O(V+E)/O(V+E)
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();          // int to store {destination, color of edge}
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] redEdge:redEdges){
            adj.get(redEdge[0]).add(new int[]{redEdge[1], 0});
        }

        for(int[] blueEdge:blueEdges){
            adj.get(blueEdge[0]).add(new int[]{blueEdge[1], 1});
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});          // starting from 0th node and there is no edge before zero hence color of that edge is -1.
        int[] result = new int[n];
        Arrays.fill(result, -1);        // default value of result.
        boolean[][] visited = new boolean[n][2]; // visited[node][color]: color 0 for red, 1 for blue

        result[0] = 0;                      // distance of 0th node from 0th node will always be 0;
        int length = 1;
        visited[0][0] = true; // Mark starting node as visited (from a hypothetical red edge)
        visited[0][1] = true; // Mark starting node as visited (from a hypothetical blue edge)

        while(!queue.isEmpty()){
            int levelSize = queue.size(); // Process all nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                int[] temp = queue.poll();

                int prevNode = temp[0];
                int prevColor = temp[1];

                for (int[] neighbour : adj.get(prevNode)) {
                    int neighbourNode = neighbour[0];
                    int neighbourColor = neighbour[1];

                    if (neighbourColor != prevColor) {
                        if (!visited[neighbourNode][neighbourColor]) {
                            visited[neighbourNode][neighbourColor] = true; // Mark as visited
                            queue.offer(new int[]{neighbourNode, neighbourColor});
                            if (result[neighbourNode] == -1) {
                                result[neighbourNode] = length;
                            }
                        }
                    }
                }
            }
            length++;
        }
        return result;
    }
}
