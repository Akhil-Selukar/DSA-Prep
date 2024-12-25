package org.akhil;

public class Solution {

    public int makeConnected(int noOfNodes, int[][] connections) {
        DisjointSet ds = new DisjointSet(noOfNodes);
        int extraEdges = 0;

        for(int i = 0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findParent(u) == ds.findParent(v)){
                extraEdges++;
            } else {
                ds.unionBySize(u,v);
            }
        }

        int components = 0;
        for(int i=0; i<noOfNodes; i++){
            if(i == ds.findParent(i)){
                components++;
            }
        }

        if(extraEdges >= components-1){
            return components-1;
        } else {
            return -1;
        }
    }
}
