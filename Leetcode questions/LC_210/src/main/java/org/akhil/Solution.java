package org.akhil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses<2){
            return new int[] {0};
        }

        // create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        // populate adjacency list
        for(int i=0; i< prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // create inDegree
        int[] inDegree = new int[numCourses];
        for(int i=0; i<adj.size(); i++){
            for(int val:adj.get(i)){
                inDegree[val]++;
            }
        }

        // kahn's algorithm
        // populate queue
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            result.add(temp);
            for(int adjValue:adj.get(temp)){
                inDegree[adjValue]--;
                if(inDegree[adjValue] == 0){
                    queue.offer(adjValue);
                }
            }
        }

        if(result.size() != numCourses){
            return new int[]{};
        }
        int[] arr = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
}
