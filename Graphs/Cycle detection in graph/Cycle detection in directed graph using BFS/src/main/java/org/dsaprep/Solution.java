package org.dsaprep;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean isCyclic(List<List<Integer>> adj) {
        int[] inDegree = new int[adj.size()];

        for(int i=0; i<adj.size(); i++){
            for(int adjValue:adj.get(i)){
                inDegree[adjValue]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            count++;
            for(int adjValue:adj.get(temp)){
                inDegree[adjValue]--;
                if(inDegree[adjValue] == 0){
                    queue.offer(adjValue);
                }
            }
        }

        if(count == adj.size()){
            return false;   // no cycle present
        }
        return true; // cycle is present
    }
}
