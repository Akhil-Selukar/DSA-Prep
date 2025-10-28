package org.akhil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int kruskalsAlgo(List<int[]> adj, int numOfNodes) {             // this can be List<Edge>
        if(numOfNodes == 0){
            return 0;
        }

        List<Edge> edges = new ArrayList<>();

        for(int[] edge : adj) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            edges.add(new Edge(weight, source, destination));
        }

        Collections.sort(edges, (a,b)->{
            return a.weight-b.weight;
        });

        DisjointSet ds = new DisjointSet(numOfNodes);
        int mstWeight = 0;
        List<int[]> mst = new ArrayList<>();

        for(int i=0; i<edges.size(); i++){
            int weight = edges.get(i).weight;
            int start = edges.get(i).start;
            int end = edges.get(i).end;

            if(!ds.isConnected(start, end)){
                ds.union(start, end);
                mstWeight = mstWeight + weight;
                mst.add(new int[]{start, end});
            }
        }

        if(ds.totalComponents > 1){
            return Integer.MAX_VALUE;
        }
        return mstWeight;
    }
}
