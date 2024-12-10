package org.dsaprep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public void topoSort(List<List<Integer>> adj){
        int[] inDegree = new int[adj.size()];

        // Fill inDegree array
        for(int i=0; i<adj.size(); i++){
            for(int adjValue:adj.get(i)){
                inDegree[adjValue]++;
            }
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<adj.size(); i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while(!queue.isEmpty()){
            int tempNode = queue.poll();
            topoOrder.add(tempNode);
            for(int adjValue:adj.get(tempNode)){
                inDegree[adjValue]--;
                if(inDegree[adjValue] == 0){
                    queue.offer(adjValue);
                }
            }
        }

        System.out.println(topoOrder);
    }
}
