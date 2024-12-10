package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // create an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);      // every time course dependency will be like [targetCourse, requiredCourse]. Hence required course i.e. [i][1] should be completed first before taking target course [i][0];
        }

        // Kahn's algorithm

        // calculate inDegree
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int val:adj.get(i)){
                inDegree[val]++;
            }
        }

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count=0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            count++;
            for(int adjValue:adj.get(temp)){
                inDegree[adjValue]--;
                if(inDegree[adjValue] == 0){
                    queue.add(adjValue);
                }
            }
        }
        return count == numCourses;
    }
}
