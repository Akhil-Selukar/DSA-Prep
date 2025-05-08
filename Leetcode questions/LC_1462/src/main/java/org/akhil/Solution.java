package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // Time Complexity: O(N³ + P + Q)   where N is numCourses, P is the number of prerequisites, and Q is the number of queries.
    // Space complexity: O(N^2 + N + P), for the answers matrix, adjacency list, inDegree array, and queue.

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // create 2D matrix to store prerequisites
        boolean[][] answers = new boolean[numCourses][numCourses];

        // create adj list.
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
            answers[edge[0]][edge[1]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int polled = queue.poll();

            for(int nei:adj.get(polled)) {
                for (int i = 0; i < numCourses; i++) {
                    if(answers[i][polled]){
                        answers[i][nei] = true;
                    }
                }
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            res.add(answers[u][v]);
        }

        return res;
    }
}
