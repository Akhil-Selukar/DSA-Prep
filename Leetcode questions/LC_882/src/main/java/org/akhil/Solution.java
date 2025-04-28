package org.akhil;

import java.util.*;

public class Solution {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        // creating graph
        int[][] graph = new int[n][n];

        for (int[] edge : graph) {
            Arrays.fill(edge, -1);
        }
        for (int[] edge: edges) {
            // source -> end = Distance / Intermediatory nodes
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        // Dijkstras Algorithm concept
        Set<Integer> visited = new HashSet<>();
        int answer = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        //starting from 0th node
        queue.offer(new int[]{0, maxMoves});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int movesAllowed = curr[1];

            if(visited.contains(currNode)){
                continue;
            }

            visited.add(currNode);
            answer++;

            for(int neighbour=0; neighbour<n; neighbour++){
                if(graph[currNode][neighbour] != -1){
                    if(!visited.contains(neighbour) && movesAllowed >= graph[currNode][neighbour]+1){
                        queue.add(new int[]{neighbour, movesAllowed - graph[currNode][neighbour] - 1});
                    }

                    int movesTaken = Math.min(movesAllowed, graph[currNode][neighbour]);

                    graph[neighbour][currNode] -= movesTaken;
                    graph[currNode][neighbour] -= movesTaken;

                    answer = answer + movesTaken;
                }
            }
        }
        return answer;
    }
}
