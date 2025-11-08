package org.akhil;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DisjointSet ds = new DisjointSet(c);

        for(int[] connection:connections){
            int u = connection[0] - 1;      // -1 because nodes given are 1 indexed, so converting to 0 index
            int v = connection[1] - 1;

            ds.union(u, v);
        }

        List<Integer> result = new ArrayList<>();

        for(int[] query:queries){
            int operationType = query[0];
            int plantNo = query[1] - 1;

            if(operationType == 2){
                ds.markPlantOffline(plantNo);
            } else {
                int closestOnlinePlant = ds.findClosestOnlinePlant(plantNo);
                if(closestOnlinePlant < 0) {
                    result.add(closestOnlinePlant);
                } else {
                    result.add(closestOnlinePlant + 1);      // +1 because conversion from 0 indexed graph to 1 indexed
                }
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
